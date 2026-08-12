package com.amr.terra.jni;

public class TerrapperLib {
  static { System.loadLibrary("terrapper"); }

  public static native int loadWorld(String wld);
  public static native int renderWorld(String png, int flags);
  public static native float[] getEvilStats();
  public static native void unloadWorld();
}
