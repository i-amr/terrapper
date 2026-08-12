package com.amr.terra.model.world;

import com.amr.terra.common.world.bestiary.BestiaryIO;
import com.amr.terra.common.world.chest.ChestIO;
import com.amr.terra.common.world.creative.CreativeIO;
import com.amr.terra.common.world.header.HeaderIO;
import com.amr.terra.common.world.npc.NpcIO;
import com.amr.terra.common.world.pressureplate.PressurePlateIO;
import com.amr.terra.common.world.sign.SignIO;
import com.amr.terra.common.world.tileentity.TileEntityIO;
import com.amr.terra.common.world.townroom.TownRoomIO;
import com.amr.terra.constants.RenderOptions;
import com.amr.terra.enums.FileType;
import com.amr.terra.exception.MetadataError;
import com.amr.terra.exception.SectionMismatchError;
import com.amr.terra.exception.UnsupportedVersionError;
import com.amr.terra.io.BinaryReader;
import com.amr.terra.jni.TerrapperLib;
import com.amr.terra.metadata.MetadataIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WorldIO {
  public static final int MIN_VERSION = 269;
  public static final int MAX_VERSION = 318;

  public static final int ENOFILE = -1; // world file isnt exist, or stb is running..
  public static final int ELOAD   = 1;  // during parsing world
  public static final int ESAVE   = 2;  // during drawing using stb
  public static final int EREND   = 3;  // during rendring world
  public static final int SUCCESS = 0;

  private static boolean hasLoaded;

  // --- Status Stuff ---

  public static boolean hasLoaded() { return hasLoaded; }

  // --- Section Guard ---

  private static void assertSection(BinaryReader br, int[] positions, int section) throws SectionMismatchError, IOException {
    long actual = br.getFilePointer();
    long expected = positions[section];
    if (actual != expected)
      throw new SectionMismatchError(
          String.format(
              "Section guard failed at section %d.\n"
                  + "Expected position: %d\n"
                  + "Actual position:   %d\n"
                  + "Drift: %+d bytes",
              section, expected, actual, actual - expected));
  }

  // --- Read ---

  public static World read(String path) throws MetadataError, SectionMismatchError, UnsupportedVersionError, IOException {
    return read(new File(path));
  }

  public static World read(File f) throws MetadataError, SectionMismatchError, UnsupportedVersionError, IOException {
    if (!f.exists()) throw new FileNotFoundException("World file does not exist!");

    try (BinaryReader br = new BinaryReader(f)) {
      final int version = br.readInt32();

      if (MIN_VERSION > version || version > MAX_VERSION)
        throw new UnsupportedVersionError(
            String.format(
                "World version %d is not supported.\n"
                    + "This app is strictly tuned for versions %d to %d.\n"
                    + "Please provide a compatible world file from Terraria 1.4.4+.",
                version, MIN_VERSION, MAX_VERSION));

      final World world = new World();
      world.setVersion(version);
      world.setMetadata(MetadataIO.read(br, FileType.WORLD));

      final int[] positions = new int[br.readInt16()];
      for (int i = 0; i < positions.length; i++) positions[i] = br.readInt32();
      final boolean[] importance = br.readBitArray(br.readUInt16());

      world.setHeader(HeaderIO.read(br, version));
      assertSection(br, positions, 1);

      // Tiles handled by C - load via JNI, seek past tile data
      load(f.getAbsolutePath());
      br.seek(positions[2]);

      world.setChests(ChestIO.read(br, version));
      assertSection(br, positions, 3);

      world.setSigns(SignIO.read(br, version));
      assertSection(br, positions, 4);

      world.setNpcs(NpcIO.read(br, version));
      assertSection(br, positions, 5);

      world.setTileEntities(TileEntityIO.read(br, version));
      assertSection(br, positions, 6);

      world.setPressurePlates(PressurePlateIO.read(br));
      assertSection(br, positions, 7);

      world.setTownRooms(TownRoomIO.read(br));
      assertSection(br, positions, 8);

      world.setBestiary(BestiaryIO.read(br));
      assertSection(br, positions, 9);

      world.setCreative(CreativeIO.read(br));
      assertSection(br, positions, 10);

      return world;
    }
  }

  // --- JNI Bridge ---

  private static void load(String path) {
    TerrapperLib.loadWorld(path);
    hasLoaded = true;
  }

  public static void unload() {
    TerrapperLib.unloadWorld();
    hasLoaded = false;
  }

  // --- Render Overloads ---

  public static int render(String image, int flags) {
    return hasLoaded ? TerrapperLib.renderWorld(image, flags) : ELOAD;
  }

  public static int render(File image, int flags) {
    return render(image.getAbsolutePath(), flags);
  }

  public static int render(String image) {
    return render(image, RenderOptions.ALL);
  }

  public static int render(File image) {
    return render(image.getAbsolutePath(), RenderOptions.ALL);
  }
}
