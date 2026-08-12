package com.amr.terra;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.amr.terra.exception.TerrapperError;
import com.amr.terra.model.world.WorldIO;
import com.amr.terra.util.ImageCache;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class WorldActivity extends Activity {
  public static final int PERM_REQUEST = 101;

  private ImageView imageView;
  private TextView textView, status;
  private Button render, parse, save;
  private EditText path;
  private ImageCache cache;

  private File wldPath, imgPath;

  private Runnable pendingAction;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_world);

    imageView = findViewById(R.id.image_view);
    textView  = findViewById(R.id.text_view);
    status    = findViewById(R.id.status);
    render    = findViewById(R.id.render);
    parse     = findViewById(R.id.parse);
    path      = findViewById(R.id.path);
    save      = findViewById(R.id.save);

    cache     = new ImageCache(getCacheDir());

    render.setEnabled(false);

    parse .setOnClickListener(v -> tryWithPermission(this::parse));
    render.setOnClickListener(v -> tryWithPermission(this::render));
    save.setOnClickListener(v -> {
      if (!imgPath.exists()) {
        status.setText("you must render it first!");
        return;
      }

      try {
        Files.move(
          imgPath.toPath(),
          new File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            imgPath.getName()
          ).toPath(),
          StandardCopyOption.REPLACE_EXISTING
        );
      } catch (IOException e) { status.setText(e.toString()); }
    });
  }

  // --- Actions ---

  private void parse() {

    wldPath = new File(path.getText().toString());

    if (!wldPath.exists()) {
      status.setText("world file does not exist!");
      return;
    }

    else if (!wldPath.isFile() || !wldPath.getName().endsWith(".wld")) {
      status.setText("invalid world file!");
      return;
    }

    imgPath = new File(getCacheDir(), wldPath.getName().replace(".wld", ".png"));

    setLoading(true);
    new Thread(() -> {
      final StringBuilder sb = new StringBuilder();
      final long start = System.currentTimeMillis();

      try { sb.append(WorldIO.read(wldPath).toString()); }
      catch (IOException | TerrapperError e) { sb.append(e.toString()); }

      final long elapsed = System.currentTimeMillis() - start;

      runOnUiThread(() -> {
        status.setText("Parse - " + elapsed / 1000.0 + "s");
        if (sb.length() > 0) textView.setText(sb.toString());
        setLoading(false);
      });
    }).start();
  }

  private void render() {
    if (!WorldIO.hasLoaded()) {
      status.setText("calling render() before loading a world to render, must call parse() or load() first!");
      return;
    }

    setLoading(true);
    new Thread(() -> {
      final StringBuilder sb = new StringBuilder();
      final long start = System.currentTimeMillis();

      Drawable drawable;
      if (cache.has(wldPath)) {
        drawable = cache.restore(wldPath);
      } else {
        WorldIO.render(imgPath);
        try { cache.save(imgPath, cache.cacheFile(wldPath)); }
        catch (IOException e) { sb.append(e.toString()); }
        drawable = Drawable.createFromPath(cache.cacheFile(wldPath).getAbsolutePath());
      }

      final long elapsed = System.currentTimeMillis() - start;
      final Drawable finalDrawable = drawable;

      runOnUiThread(() -> {
        if (finalDrawable != null) imageView.setImageDrawable(finalDrawable);
        status.setText("Render - " + elapsed / 1000.0 + "s");
        if (sb.length() > 0) textView.setText(sb.toString());
        setLoading(false);
      });
    }).start();
  }

  // --- Permission Helpers ---

  private void tryWithPermission(Runnable action) {
    if (!hasPermissions()) {
      pendingAction = action;
      requestStoragePermissions();
      return;
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R
        && !Environment.isExternalStorageManager()) {
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
    requestPermissions(
      new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE},
      PERM_REQUEST);
  }

  @Override
  public void onRequestPermissionsResult(int code, String[] perms, int[] results) {
    if (code != PERM_REQUEST) return;
    for (int r : results) if (r != PERMISSION_GRANTED) return;
    if (pendingAction != null) { pendingAction.run(); pendingAction = null; }
  }

  // --- UI Helpers ---

  private void setLoading(boolean loading) {
    parse.setEnabled(!loading);
    render.setEnabled(!loading);
    parse.setText(loading ? "..." : "Parse");
    render.setText(loading ? "..." : "Render");
  }
}