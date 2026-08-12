package com.amr.terra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
  private TextView title;
  private Button world, map, player;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    title  = findViewById(R.id.title);
    world  = findViewById(R.id.wld);
    player = findViewById(R.id.plr);

    title.setText(Html.fromHtml("Terra<font color=\"gray\">riaWra</font>pper", Html.FROM_HTML_MODE_LEGACY));

    world.setOnClickListener(v -> startActivity(new Intent(this, WorldActivity.class)));
    player.setOnClickListener(v -> startActivity(new Intent(this, PlayerActivity.class)));
  }
}
