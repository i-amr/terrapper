package com.amr.terra.model.player;

import com.amr.terra.data.Item;
import com.amr.terra.enums.FileType;
import com.amr.terra.exception.MetadataError;
import com.amr.terra.exception.UnsupportedVersionError;
import com.amr.terra.io.BinaryReader;
import com.amr.terra.metadata.MetadataIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class PlayerIO {
  public static final int MIN_VERSION = 269;
  public static final int MAX_VERSION = 318;

  // --- Read ---

  public static Player read(String path) throws MetadataError, UnsupportedVersionError, IOException {
    return read(new File(path));
  }

  public static Player read(File f) throws MetadataError, UnsupportedVersionError, IOException {
    if (!f.exists()) throw new FileNotFoundException("Player file does not exist!");

    try (BinaryReader br = new BinaryReader(f, "h3y_gUyZ")) {
      final int version = br.readInt32();

      if (MIN_VERSION > version || version > MAX_VERSION)
        throw new UnsupportedVersionError(
            String.format(
                "Player version %d is not supported.\n"
                    + "This app is strictly tuned for versions %d to %d.\n"
                    + "Please provide a compatible player file from Terraria 1.4.4+.",
                version, MIN_VERSION, MAX_VERSION));

      final Player player = new Player();
      player.setVersion(version);
      player.setMetadata(MetadataIO.read(br, FileType.PLAYER));

      player.setName(br.readString());
      player.setDifficulty(br.readUByte());

      player.setPlayTime(fromTicks(br.readInt64()));

      player.setHairStyle(br.readInt32());
      player.setHairDye(br.readUByte());

      if (version >= 283) player.setTeam(br.readUByte());

      // hide visuals flags (bitfield for accessory visibility)
      {
        final int b = br.readUByte();
        for (int i = 0; i < 8; i++)
          player.setAccessoryHidden(i, ((b >> i) & 1) == 1);
      }
      {
        final int b = br.readUByte();
        for (int i = 0; i < 2; i++)
          player.setAccessoryHidden(i + 8, ((b >> i) & 1) == 1);
      }
      {
        final int b = br.readUByte();
        for (int i = 0; i < 8; i++)
          player.setMiscHidden(i, ((b >> i) & 1) == 1);
      }

      // skin variants 0-3, 8 and 10 are male, 4-7, 9 and 11 are female.
      player.setSkinVariant(br.readUByte());

      player.setHealth(br.readInt32());
      player.setHealthMax(br.readInt32());
      player.setMana(br.readInt32());
      player.setManaMax(br.readInt32());

      // one-time power-ups

      player.setUsedDemonHeart(br.readBoolean());
      player.setUsedTochGodFavor(br.readBoolean());
      player.setEnabledTorchGodFavor(br.readBoolean());
      player.setUsedArtisanBread(br.readBoolean());
      player.setUsedVitalCrystal(br.readBoolean());
      player.setUsedAegisFruit(br.readBoolean());
      player.setUsedArcaneCrystal(br.readBoolean());
      player.setUsedGalaxyPearl(br.readBoolean());
      player.setUsedGummyWorm(br.readBoolean());
      player.setUsedAmbrosia(br.readBoolean());

      player.setDefeatedDD2Invasion(br.readBoolean());

      // it seem to have smth to do with tax collector npc
      player.setTaxMoney(br.readInt32());

      player.setNumberOfDeathsPvE(br.readInt32());
      player.setNumberOfDeathsPvP(br.readInt32());

      player.setHairColor(br.readRGB());
      player.setSkinColor(br.readRGB());
      player.setEyeColor(br.readRGB());
      player.setShirtColor(br.readRGB());
      player.setUnderShirtColor(br.readRGB());
      player.setPantsColor(br.readRGB());
      player.setShoeColor(br.readRGB());

      // 3 armor + 7 accessories + 10 vanity
      for (int i = 0; i < 20; i++) {
        final Item equipment = new Item();

        equipment.setId(br.readInt32());
        equipment.setPrefix(br.readUByte());
        equipment.setStackSize(1);

        player.setEquipment(i, equipment);
      }

      for (int i = 0; i < 10; i++) {
        final Item dye = new Item();

        dye.setId(br.readInt32());
        dye.setPrefix(br.readUByte());
        dye.setStackSize(1);

        player.setDye(i, dye);
      }

      for (int i = 0; i < 58; i++) {
        final Item item = new Item();

        item.setId(br.readInt32());
        item.setStackSize(br.readInt32());
        item.setPrefix(br.readUByte());
        item.setPinned(br.readBoolean());

        player.setInventoryItem(i, item);
      }

      // misc equipments and dyes (pet, light, minecart, mount, hook)
      for (int i = 0; i < 5; i++) {
        final Item equipment = new Item();
        equipment.setId(br.readInt32());
        equipment.setPrefix(br.readUByte());

        final Item dye = new Item();
        dye.setId(br.readInt32());
        dye.setPrefix(br.readUByte());

        player.setMiscEquipment(i, equipment);
        player.setMiscDye(i, dye);
      }

      for (int i = 0; i < 40; i++) {
        final Item item = new Item();

        item.setId(br.readInt32());
        item.setStackSize(br.readInt32());
        item.setPrefix(br.readUByte());

        player.setPiggyBankItem(i, item);
      }

      for (int i = 0; i < 40; i++) {
        final Item item = new Item();

        item.setId(br.readInt32());
        item.setStackSize(br.readInt32());
        item.setPrefix(br.readUByte());

        player.setSafeItem(i, item);
      }

      for (int i = 0; i < 40; i++) {
        final Item item = new Item();

        item.setId(br.readInt32());
        item.setStackSize(br.readInt32());
        item.setPrefix(br.readUByte());

        player.setDefenderForgeItem(i, item);
      }

      for (int i = 0; i < 40; i++) {
        final Item item = new Item();

        item.setId(br.readInt32());
        item.setStackSize(br.readInt32());
        item.setPrefix(br.readUByte());
        item.setPinned(br.readBoolean());

        player.setVoidVaultItem(i, item);
      }

      // player.voidVaultInfo = (BitsByte) br.readUByte();

      // int num = 44;
      // for (int i = 0; i < num; i++) {
      // player.buffType[i] = br.readInt32();
      // player.buffTime[i] = br.readInt32();

      // if (player.buffType[i] == 0) {
      // i--; num--;
      // }
      // }

      // for (int i = 0; i < 200; i++) {
      // int num = br.readInt32();
      // if (num != -1) {
      // player.spX[i] = num;
      // player.spY[i] = br.readInt32();
      // player.spI[i] = br.readInt32();
      // player.spN[i] = br.readString();
      // }
      // else break;
      // }

      // player.hbLocked = br.readBoolean();

      // for (int i = 0; i < 13; i++)
      // player.hideInfo[i] = br.readBoolean();

      // player.anglerQuestsFinished = br.readInt32();

      // for (int i = 0; i < 4; i++)
      // player.DpadRadial.Bindings[i] = br.readInt32();

      // for (int i = 0; i < 12; i++)
      // player.builderAccStatus[i] = br.readInt32();

      // player.bartenderQuestLog = br.readInt32();

      // player.dead = br.readBoolean();
      // if (player.dead)
      // player.respawnTimer = Utils.Clamp<int>(br.readInt32(), 0, 60000);

      // player.lastTimePlayerWasSaved = br.readInt64();
      // player.golferScoreAccumulated = br.readInt32();
      // player.creativeTracker.Load(br, version);
      // player.LoadTemporaryItemSlotContents(br);
      // player.savedPerPlayerFieldsThatArentInThePlayerClass = new
      // Player.SavedPlayerDataWithAnnoyingRules();

      // CreativePowerManager.Instance.ResetDataForNewPlayer(player);
      // CreativePowerManager.Instance.LoadToPlayer(player, br, version);

      // BitsByte bitsByte = (BitsByte) br.readUByte();
      // player.unlockedSuperCart = bitsByte[0];
      // player.enabledSuperCart = bitsByte[1];

      // int num = br.readInt32();
      // player.CurrentLoadoutIndex = Utils.Clamp<int>(num, 0, player.Loadouts.Length - 1);
      // for (int i = 0; i < player.Loadouts.Length; i++)
      // player.Loadouts[i].Deserialize(br, version);

      // if (version >= 280) {
      // player.voiceVariant = br.readUByte();
      // } else {
      // player.skinVariant = (int) MathHelper.Clamp((float) player.skinVariant, 0.0f, (float)
      // (PlayerVariantID.Count - 1));
      // player.voiceVariant = player.Male ? 1 : 2;
      // player.voicePitchOffset = 0.0f;
      // }
      // player.voicePitchOffset = version < 281 ? 0.0f : br.readSingle();

      // if (version >= 300) {
      // player._pendingRefunds = new Item[br.readInt32()];
      // for (int i = 0; i < player._pendingRefunds.Length; i++) {
      // player._pendingRefunds[i] = new Item();
      // player._pendingRefunds[i].DeserializeFrom(br, ItemSerializationContext.SavingAndLoading);
      // }
      // }

      // if (version >= 310) {
      // int num = br.readInt32();
      // for (int i = 0; i < num; i++)
      // player.oneTimeDialoguesSeen.Add(br.readString());
      // }
      // Player.LoadPlayer_LastMinuteFixes(player);

      return player;
    }
  }

  public static Duration fromTicks(long ticks) {
    long seconds = ticks / 10_000_000;
    long nanos = (ticks % 10_000_000) * 100;

    return Duration.ofSeconds(seconds, nanos);
  }
}
