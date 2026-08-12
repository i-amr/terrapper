package com.amr.terra.metadata;

import com.amr.terra.enums.FileType;
import java.util.Objects;

public class Metadata {

  public static final String RELOGIC = "relogic";

  private FileType fileType;
  private long revision;
  private boolean favorite;

  protected Metadata() { }
  public Metadata(FileType fileType, long revision, boolean favorite) {
    this.fileType = fileType;
    this.revision = revision;
    this.favorite = favorite;
  }

  public FileType getFileType() { return fileType; }
  public void setFileType(FileType fileType) { this.fileType = fileType; }

  public long getRevision() { return revision; }
  public void setRevision(long revision) { this.revision = revision; }

  public boolean isFavorite() { return favorite; }
  public void setFavorite(boolean favorite) { this.favorite = favorite; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Metadata metadata = (Metadata) o;
    return fileType == metadata.fileType && 
        Long.compare(revision, metadata.revision) == 0 && 
        favorite == metadata.favorite;
  }

  @Override public int hashCode() { return Objects.hash(fileType, revision, favorite); }

  @Override
  public String toString() {
    return "Metadata(" +
        "fileType=" + fileType +
        ", revision=" + revision +
        ", favorite=" + favorite +
        ')';
  }
}
