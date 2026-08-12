package com.amr.terra.metadata;

import com.amr.terra.enums.FileType;
import com.amr.terra.exception.MetadataError;
import com.amr.terra.io.BinaryReader;
import java.io.IOException;

public class MetadataIO {

  public static Metadata read(BinaryReader br, FileType expected) throws MetadataError, IOException {
    final String signature = br.readChars(7);
    if (!signature.equals(Metadata.RELOGIC)) throw new MetadataError("Expected Re-Logic file signature.");

    final FileType fileType = FileType.fromInt(br.readUByte());
    if (fileType != expected)
      throw new MetadataError(
          String.format(
              "Metadata file type mismatch. Expected \"%s\", got \"%s\"",
              expected.name(), fileType.name()));

    final long revision = br.readUInt32();
    final boolean isFavorite = br.readUInt64().testBit(0);

    return new Metadata(fileType, revision, isFavorite);
  }
}
