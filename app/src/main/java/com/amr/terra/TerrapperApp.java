package com.amr.terra;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class TerrapperApp extends Application {
  public static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    context = getApplicationContext();
  }

  public Context getContext() {
    return getApplicationContext();
  }

  public static void makeToast(String s) {
    new Handler(Looper.getMainLooper())
        .post(
            () -> {
              Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
            });
  }
}
