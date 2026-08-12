package com.amr.terra;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.amr.terra.exception.TerrapperError;
import com.amr.terra.model.player.Player;
import com.amr.terra.model.player.PlayerIO;
import java.io.File;
import java.io.IOException;

public class PlayerActivity extends Activity {
  public static final int PERM_REQUEST = 101;

  private TextView textView, status;
  private Button parse;
  private EditText path;

  private File plrPath;

  private Runnable pendingAction;

  private View prv, hair, skin, leye, reye, shirt, ushirt, pants, shoe;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player);

    textView = findViewById(R.id.text_view);
    status   = findViewById(R.id.status);
    parse    = findViewById(R.id.parse);
    path     = findViewById(R.id.path);

    parse.setOnClickListener(v -> tryWithPermission(this::parse));

    prv    = findViewById(R.id.plr_prv);
    hair   = findViewById(R.id.plr_hair);
    skin   = findViewById(R.id.plr_skin);
    leye   = findViewById(R.id.plr_leye);
    reye   = findViewById(R.id.plr_reye);
    shirt  = findViewById(R.id.plr_shirt);
    ushirt = findViewById(R.id.plr_ushirt);
    pants  = findViewById(R.id.plr_pants);
    shoe   = findViewById(R.id.plr_shoe);
  }

  // --- Actions ---

  private void parse() {

    plrPath = new File(path.getText().toString());

    if (!plrPath.exists()) {
      status.setText("player file does not exist!");
      return;
    } else if (!plrPath.isFile() || !plrPath.getName().endsWith(".plr")) {
      status.setText("invalid player file!");
      return;
    }

    setLoading(true);
    new Thread(
            () -> {
              final StringBuilder sb = new StringBuilder();
              final long start = System.currentTimeMillis();
              Player player = null; 

              try {
                player = PlayerIO.read(plrPath);
                sb.append(player.toString());
              } catch (IOException | TerrapperError e) {
                sb.append(e.toString());
              }

              final Player plr = player;
              final long elapsed = System.currentTimeMillis() - start;

              runOnUiThread(
                  () -> {
                    status.setText("Parse - " + elapsed / 1000.0 + "s");
                    if (sb.length() > 0) textView.setText(sb.toString());
                    setLoading(false);

                    if (plr != null) {
                      prv.setVisibility(View.VISIBLE);
                      hair.setBackgroundColor(plr.getHairColor().toInteger());
                      skin.setBackgroundColor(plr.getSkinColor().toInteger());
                      leye.setBackgroundColor(plr.getEyeColor().toInteger());
                      reye.setBackgroundColor(plr.getEyeColor().toInteger());
                      shirt.setBackgroundColor(plr.getShirtColor().toInteger());
                      ushirt.setBackgroundColor(plr.getUnderShirtColor().toInteger());
                      shoe.setBackgroundColor(plr.getShoeColor().toInteger());
                      pants.setBackgroundColor(plr.getPantsColor().toInteger());
                    }
                  });
            })
        .start();
  }

  // --- Permission Helpers ---

  private void tryWithPermission(Runnable action) {
    if (!hasPermissions()) {
      pendingAction = action;
      requestStoragePermissions();
      return;
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
      startActivity(new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION));
      return;
    }
    action.run();
  }

  private boolean hasPermissions() {
    return checkSelfPermission(READ_EXTERNAL_STORAGE) == PERMISSION_GRANTED
        && checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PERMISSION_GRANTED;
  }

  private void requestStoragePermissions() {
    requestPermissions(new String[] {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PERM_REQUEST);
  }

  @Override
  public void onRequestPermissionsResult(int code, String[] perms, int[] results) {
    if (code != PERM_REQUEST) return;
    for (int r : results) if (r != PERMISSION_GRANTED) return;
    if (pendingAction != null) {
      pendingAction.run();
      pendingAction = null;
    }
  }

  // --- UI Helpers ---

  private void setLoading(boolean loading) {
    parse.setEnabled(!loading);
    parse.setText(loading ? "..." : "Parse");
  }
}
