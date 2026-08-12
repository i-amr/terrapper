package com.amr.terra.common.world.header;

import com.amr.terra.data.Point;
import com.amr.terra.enums.Difficulty;
import com.amr.terra.io.BinaryReader;
import com.amr.terra.util.DateTime;
import java.io.IOException;

public class HeaderIO {

  public static Header read(BinaryReader br, int v) throws IOException {
    final Header header = new Header();

    readIdentityAndGeometry(br, header);
    readWorldTypeFlags(br, header, v);
    readSceneryStyles(br, header);
    readGeographyAndTime(br, header);
    readEarlyProgression(br, header);
    readInvasionState(br, header);
    readWeatherAndOres(br, header);
    readBiomeEnvironment(br, header);
    readNPCsAndAngler(br, header);
    readBanners(br, header, v);
    readLateProgression(br, header);
    readPartyAndSandstorm(br, header);
    readDD2AndLateEnvironment(br, header);
    readFinalState(br, header, v);

    return header;
  }

  public static void readIdentityAndGeometry(BinaryReader br, Header header) throws IOException {
    header.setLabel(br.readString());
    header.setSeed(br.readString());
    header.setGeneratorVersion(br.readUInt64());

    header.setUniqueId(br.readUUID());
    header.setId(br.readInt32());

    header.setBounds(br.readInt32(), br.readInt32(), br.readInt32(), br.readInt32());

    final int height = br.readInt32();
    final int width = br.readInt32();
    header.setDimen(width, height);

    header.setDifficulty(br.readInt32());
  }

  public static void readWorldTypeFlags(BinaryReader br, Header header, int v) throws IOException {
    header.setDrunkWorld(br.readBoolean());
    header.setWorthyWorld(br.readBoolean());
    header.setMK10World(br.readBoolean());
    header.setStarveWorld(br.readBoolean());
    header.setBeesWorld(br.readBoolean());
    header.setRemixWorld(br.readBoolean());
    header.setTrapsWorld(br.readBoolean());
    header.setZenithWorld(br.readBoolean());
    header.setSkyblockWorld(v >= 302 && br.readBoolean());

    header.setCreationTime(DateTime.fromBinary(br.readInt64()));
    header.setLastPlayed(v >= 284 ? DateTime.fromBinary(br.readInt64()) : null);
  }

  public static void readSceneryStyles(BinaryReader br, Header header) throws IOException {
    header.setMoonType(br.readUByte());

    final int[] treeX = new int[3];
    final int[] treeStyle = new int[4];
    final int[] caveBackX = new int[3];
    final int[] caveBackStyle = new int[4];

    for (int i = 0; i < 3; i++) treeX[i] = br.readInt32();
    for (int i = 0; i < 4; i++) treeStyle[i] = br.readInt32();
    for (int i = 0; i < 3; i++) caveBackX[i] = br.readInt32();
    for (int i = 0; i < 4; i++) caveBackStyle[i] = br.readInt32();

    header.setTreeX(treeX);
    header.setTreeStyle(treeStyle);
    header.setCaveBackX(caveBackX);
    header.setCaveBackStyle(caveBackStyle);

    header.setTundraBackStyle(br.readInt32());
    header.setJungleBackStyle(br.readInt32());
    header.setHellBackStyle(br.readInt32());
  }

  public static void readGeographyAndTime(BinaryReader br, Header header) throws IOException {
    header.setSpawnPoint(br.readInt32(), br.readInt32());

    header.setSurface(br.readDouble());
    header.setCavern(br.readDouble());

    header.setCurrentTime(br.readDouble());
    header.setDayTime(br.readBoolean());
    header.setMoonPhase(br.readInt32());
    header.setBloodMoon(br.readBoolean());
    header.setEclipse(br.readBoolean());

    header.setDungeonPoint(br.readInt32(), br.readInt32());
  }

  public static void readEarlyProgression(BinaryReader br, Header header) throws IOException {
    header.setCrimson(br.readBoolean());

    header.setDefeatedEyeOfCthulhu(br.readBoolean());
    header.setDefeatedEaterOfWorlds(br.readBoolean());
    header.setDefeatedSkeletron(br.readBoolean());
    header.setDefeatedQueenBee(br.readBoolean());
    header.setDefeatedTheDestroyer(br.readBoolean());
    header.setDefeatedTwins(br.readBoolean());
    header.setDefeatedSkeletronPrime(br.readBoolean());
    header.setDefeatedAnyMechnicalBoss(br.readBoolean());
    header.setDefeatedPlantera(br.readBoolean());
    header.setDefeatedGolem(br.readBoolean());
    header.setDefeatedKingSlime(br.readBoolean());

    header.setHasGoblinTinkerer(br.readBoolean());
    header.setHasWizard(br.readBoolean());
    header.setHasMechanic(br.readBoolean());

    header.setDefeatedGoblinArmy(br.readBoolean());
    header.setDefeatedClown(br.readBoolean());
    header.setDefeatedFrostMoon(br.readBoolean());
    header.setDefeatedPirateInvasion(br.readBoolean());

    header.setShadowOrbSmashed(br.readBoolean());
    header.setSpawnMeteor(br.readBoolean());
    header.setShadowOrbCount(br.readUByte());
    header.setAltarCount(br.readInt32());

    header.setHardMode(br.readBoolean());
    header.setDoomedParty(br.readBoolean());
  }

  public static void readInvasionState(BinaryReader br, Header header) throws IOException {
    header.setInvasionDelay(br.readInt32());
    header.setInvasionSize(br.readInt32());
    header.setInvasionType(br.readInt32());
    header.setInvasionX(br.readDouble());
  }

  public static void readWeatherAndOres(BinaryReader br, Header header) throws IOException {
    header.setSlimeRainTime(br.readDouble());
    header.setSundialCooldown(br.readUByte());
    header.setRaining(br.readBoolean());
    header.setRainTime(br.readInt32());
    header.setMaxRain(br.readSingle());

    header.setOreCobalt(br.readInt32());
    header.setOreMythril(br.readInt32());
    header.setOreAdamantite(br.readInt32());
  }

  public static void readBiomeEnvironment(BinaryReader br, Header header) throws IOException {
    header.setBgStyleForest(br.readUByte());
    header.setBgStyleCorruption(br.readUByte());
    header.setBgStyleJungle(br.readUByte());
    header.setBgStyleTundra(br.readUByte());
    header.setBgStyleHallow(br.readUByte());
    header.setBgStyleCrimson(br.readUByte());
    header.setBgStyleDesert(br.readUByte());
    header.setBgStyleOcean(br.readUByte());

    header.setCloudBGActive(br.readInt32());
    header.setNumClouds(br.readInt16());
    header.setWindSpeed(br.readSingle());
  }

  public static void readNPCsAndAngler(BinaryReader br, Header header) throws IOException {
    final String[] anglerWhoFinishedToday = new String[br.readInt32()];
    for (int i = 0; i < anglerWhoFinishedToday.length; i++)
      anglerWhoFinishedToday[i] = br.readString();
    header.setAnglerWhoFinishedToday(anglerWhoFinishedToday);

    header.setHasAngler(br.readBoolean());
    header.setAnglerQuest(br.readInt32());
    header.setHasStylist(br.readBoolean());
    header.setHasTaxCollector(br.readBoolean());
    header.setHasGolfer(br.readBoolean());

    header.setInvasionSizeStart(br.readInt32());
    header.setCultistDelay(br.readInt32());
  }

  public static void readBanners(BinaryReader br, Header header, int v) throws IOException {
    final int size = Header.MAX_BANNER_TYPES;

    final int[] banners = new int[size];
    final int bannersLength = br.readInt16();
    for (int i = 0; i < bannersLength; i++) {
      final int n = br.readInt32();
      if (i < banners.length) banners[i] = n;
    }
    header.setBanners(banners);

    if (v >= 289) {
      final int[] claimableBanners = new int[size];
      final int claimableBannersLength = br.readInt16();
      for (int i = 0; i < claimableBannersLength; i++) {
        final int n = br.readUInt16();
        if (i < claimableBanners.length) claimableBanners[i] = n;
      }
      header.setClaimableBanners(claimableBanners);
    }
  }

  public static void readLateProgression(BinaryReader br, Header header) throws IOException {
    header.setRunningSundial(br.readBoolean());

    header.setDefeatedDukeFishron(br.readBoolean());
    header.setDefeatedMartianMadness(br.readBoolean());
    header.setDefeatedLunaticCultist(br.readBoolean());
    header.setDefeatedMoonLord(br.readBoolean());
    header.setDefeatedPumpKing(br.readBoolean());
    header.setDefeatedMourningWood(br.readBoolean());
    header.setDefeatedIceQueen(br.readBoolean());
    header.setDefeatedSantaNK1(br.readBoolean());
    header.setDefeatedEverscream(br.readBoolean());

    header.setDefeatedSolarPillar(br.readBoolean());
    header.setDefeatedVortexPillar(br.readBoolean());
    header.setDefeatedNebulaPillar(br.readBoolean());
    header.setDefeatedStardustPillar(br.readBoolean());

    header.setActiveSolarPillar(br.readBoolean());
    header.setActiveVortexPillar(br.readBoolean());
    header.setActiveNebulaPillar(br.readBoolean());
    header.setActiveStardustPillar(br.readBoolean());

    header.setActiveLunarApocalypse(br.readBoolean());
  }

  public static void readPartyAndSandstorm(BinaryReader br, Header header) throws IOException {

    header.setPartyManual(br.readBoolean());
    header.setPartyGenuine(br.readBoolean());
    header.setPartyCooldown(br.readInt32());
    final int[] partyCelebratingNPCs = new int[br.readInt32()];
    for (int i = 0; i < partyCelebratingNPCs.length; i++) partyCelebratingNPCs[i] = br.readInt32();
    header.setPartyCelebratingNPCs(partyCelebratingNPCs);

    header.setActiveSandstorm(br.readBoolean());
    header.setSandstormTimeLeft(br.readInt32());
    header.setSandstormSeverity(br.readSingle());
    header.setSandstormIntendedSeverity(br.readSingle());
  }

  public static void readDD2AndLateEnvironment(BinaryReader br, Header header) throws IOException {
    header.setHasBartender(br.readBoolean());
    header.setDefeatedDD2Invasion(br.readBoolean(), br.readBoolean(), br.readBoolean());

    header.setBgStyleMushroom(br.readUByte());
    header.setBgStyleUnderworld(br.readUByte());
    header.setBgStyleForest2(br.readUByte());
    header.setBgStyleForest3(br.readUByte());
    header.setBgStyleForest4(br.readUByte());

    header.setHasUsedCombatBook(br.readBoolean());

    header.setLanternNightCooldown(br.readInt32());
    header.setLanternNightGenuine(br.readBoolean());
    header.setLanternNightManual(br.readBoolean());
    header.setLanternNightImminent(br.readBoolean());

    final int[] treeTopsVariations = new int[Header.MAX_TREE_ARIA_ID];
    final int n = br.readInt32();
    for (int i = 0; i < n && i < treeTopsVariations.length; i++)
      treeTopsVariations[i] = br.readInt32();
    header.setTreeTopsVariations(treeTopsVariations);
  }

  public static void readFinalState(BinaryReader br, Header header, int v) throws IOException {
    header.setHalloweenDay(br.readBoolean());
    header.setChristmasDay(br.readBoolean());

    header.setOreCopper(br.readInt32());
    header.setOreIron(br.readInt32());
    header.setOreSilver(br.readInt32());
    header.setOreGold(br.readInt32());

    header.setHasBoughtCat(br.readBoolean());
    header.setHasBoughtDog(br.readBoolean());
    header.setHasBoughtBunny(br.readBoolean());

    header.setDefeatedEmpressOfLight(br.readBoolean());
    header.setDefeatedQueenSlime(br.readBoolean());
    header.setDefeatedDeerclops(br.readBoolean());

    header.setHasSlimeNerdy(br.readBoolean());
    header.setHasMerchant(br.readBoolean());
    header.setHasDemolitionist(br.readBoolean());
    header.setHasPartyGirl(br.readBoolean());
    header.setHasDyeTrader(br.readBoolean());
    header.setHasTruffle(br.readBoolean());
    header.setHasArmsDealer(br.readBoolean());
    header.setHasNurse(br.readBoolean());
    header.setHasPrincess(br.readBoolean());

    header.setHasUsedCombatBookV2(br.readBoolean());
    header.setHasUsedPeddlerSatchel(br.readBoolean());

    header.setHasSlimeCool(br.readBoolean());
    header.setHasSlimeElder(br.readBoolean());
    header.setHasSlimeClumsy(br.readBoolean());
    header.setHasSlimeDiva(br.readBoolean());
    header.setHasSlimeSurly(br.readBoolean());
    header.setHasSlimeMystic(br.readBoolean());
    header.setHasSlimeSquire(br.readBoolean());

    header.setRunningMoondial(br.readBoolean());
    header.setMoondialCooldown(br.readUByte());

    header.setEndlessHalloweenWorld(v >= 287 && br.readBoolean());
    header.setEndlessChristmasWorld(v >= 287 && br.readBoolean());
    header.setVampireWorld(v >= 288 && br.readBoolean());
    header.setInfectedWorld(v >= 296 && br.readBoolean());

    header.setMeteorShowerCount(v >= 291 ? br.readInt32() : 0);
    header.setCoinRain(v >= 291 ? br.readInt32() : 0);

    if (v >= 297) {
      header.setTeamBasedSpawnsWorld(br.readBoolean());
      final Point[] teamSpawnPoints = new Point[br.readUByte()];
      for (int i = 0; i < teamSpawnPoints.length; i++)
        teamSpawnPoints[i] = new Point(br.readInt16(), br.readInt16());
      header.setTeamSpawnPoints(teamSpawnPoints);
    }

    header.setDualDungeonWorld(v >= 304 && br.readBoolean());

    if (v >= 299) {
      if (v <= 312) {
        header.setInternalVersion(br.readUInt32());
      }
      header.setManifest(br.readString());
    }
  }
}
