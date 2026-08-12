package com.amr.terra.util;

import android.graphics.drawable.Drawable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageCache {

  private final File cacheDir;

  public ImageCache(File cacheDir) {
    this.cacheDir = cacheDir;
  }

  public String key(File f) {
    return f.lastModified() + "_" + f.length() + ".png";
  }

  public File cacheFile(File f) {
    return new File(cacheDir, key(f));
  }

  public boolean has(File f) {
    return cacheFile(f).exists();
  }

  public void save(File src, File dest) throws IOException {
    Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
  }

  public Drawable restore(File f) {
    File cached = cacheFile(f);
    if (!cached.exists()) return null;
    return Drawable.createFromPath(cached.getAbsolutePath());
  }
}
