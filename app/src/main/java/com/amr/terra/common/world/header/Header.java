package com.amr.terra.common.world.header;

import com.amr.terra.data.Dimen;
import com.amr.terra.data.Point;
import com.amr.terra.data.Rect;
import com.amr.terra.enums.Difficulty;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Header {
  public static final int MAX_BANNER_TYPES = 293;
  public static final int MAX_TREE_ARIA_ID = 13;

  // ── Identity & Geometry ──────────────────────────────────────────────────
  private String label;
  private String seed;
  private BigInteger genVersion;
  private UUID uniqueId;
  private int id;
  private Rect bounds;
  private Dimen dimen;
  private Difficulty difficulty;

  // ── World Header Type Flags ─────────────────────────────────────────────────────
  private boolean isDrunkWorld;
  private boolean isWorthyWorld;
  private boolean isMK10World;
  private boolean isStarveWorld;
  private boolean isBeesWorld;
  private boolean isRemixWorld;
  private boolean isTrapsWorld;
  private boolean isZenithWorld;
  private boolean isSkyblockWorld;
  private LocalDateTime creationTime;
  private LocalDateTime lastPlayed;

  // ── Scenery Styles ───────────────────────────────────────────────────────
  private int moonType;
  private int[] treeX         = new int[3];
  private int[] treeStyle     = new int[4];
  private int[] caveBackX     = new int[3];
  private int[] caveBackStyle = new int[4];
  private int tundraBackStyle;
  private int jungleBackStyle;
  private int hellBackStyle;

  // ── Geography & Time ─────────────────────────────────────────────────────
  private Point spawnPoint;
  private double surface;
  private double cavern;
  private double currentTime;
  private boolean isDayTime;
  private int moonPhase;
  private boolean isBloodMoon;
  private boolean isEclipse;
  private Point dungeonPoint;

  // ── Early Progression ────────────────────────────────────────────────────
  private boolean isCrimson;
  private boolean isDefeatedEyeOfCthulhu;
  private boolean isDefeatedEaterOfWorlds;
  private boolean isDefeatedSkeletron;
  private boolean isDefeatedQueenBee;
  private boolean isDefeatedTheDestroyer;
  private boolean isDefeatedTwins;
  private boolean isDefeatedSkeletronPrime;
  private boolean isDefeatedAnyMechnicalBoss;
  private boolean isDefeatedPlantera;
  private boolean isDefeatedGolem;
  private boolean isDefeatedKingSlime;
  private boolean hasGoblinTinkerer;
  private boolean hasWizard;
  private boolean hasMechanic;
  private boolean isDefeatedGoblinArmy;
  private boolean isDefeatedClown;
  private boolean isDefeatedFrostMoon;
  private boolean isDefeatedPirateInvasion;
  private boolean shadowOrbSmashed;
  private boolean spawnMeteor;
  private int shadowOrbCount;
  private int altarCount;
  private boolean isHardMode;
  private boolean isDoomedParty;

  // ── Invasion State ───────────────────────────────────────────────────────
  private int invasionDelay;
  private int invasionSize;
  private int invasionType;
  private double invasionX;

  // ── Weather & Hardmode Ores ──────────────────────────────────────────────
  private double slimeRainTime;
  private int sundialCooldown;
  private boolean isRaining;
  private int rainTime;
  private float maxRain;
  private int oreCobalt;
  private int oreMythril;
  private int oreAdamantite;

  // ── Biome Environment ────────────────────────────────────────────────────
  private int bgStyleForest;
  private int bgStyleCorruption;
  private int bgStyleJungle;
  private int bgStyleTundra;
  private int bgStyleHallow;
  private int bgStyleCrimson;
  private int bgStyleDesert;
  private int bgStyleOcean;
  private float cloudBGActive;
  private int numClouds;
  private float windSpeed;

  // ── NPCs & Angler ────────────────────────────────────────────────────────
  private String[] anglerWhoFinishedToday = new String[0];
  private boolean hasAngler;
  private int anglerQuest;
  private boolean hasStylist;
  private boolean hasTaxCollector;
  private boolean hasGolfer;
  private int invasionSizeStart;
  private int cultistDelay;

  // ── Banners ──────────────────────────────────────────────────────────────
  private int[] banners          = new int[0];
  private int[] claimableBanners = new int[0];

  // ── Late Progression ─────────────────────────────────────────────────────
  private boolean isRunningSundial;
  private boolean isDefeatedDukeFishron;
  private boolean isDefeatedMartianMadness;
  private boolean isDefeatedLunaticCultist;
  private boolean isDefeatedMoonLord;
  private boolean isDefeatedPumpKing;
  private boolean isDefeatedMourningWood;
  private boolean isDefeatedIceQueen;
  private boolean isDefeatedSantaNK1;
  private boolean isDefeatedEverscream;
  private boolean isDefeatedSolarPillar;
  private boolean isDefeatedVortexPillar;
  private boolean isDefeatedNebulaPillar;
  private boolean isDefeatedStardustPillar;
  private boolean isActiveSolarPillar;
  private boolean isActiveVortexPillar;
  private boolean isActiveNebulaPillar;
  private boolean isActiveStardustPillar;
  private boolean isActiveLunarApocalypse;

  // ── Party & Sandstorm ────────────────────────────────────────────────────
  private boolean isPartyManual;
  private boolean isPartyGenuine;
  private int partyCooldown;
  private int[] partyCelebratingNPCs  = new int[0];
  private boolean isActiveSandstorm;
  private int sandstormTimeLeft;
  private float sandstormSeverity;
  private float sandstormIntendedSeverity;

  // ── Old One's Army & Late Environment ────────────────────────────────────
  private boolean hasBartender;
  private boolean[] isDefeatedDD2Invasion = new boolean[3];
  private int bgStyleMushroom;
  private int bgStyleUnderworld;
  private int bgStyleForest2;
  private int bgStyleForest3;
  private int bgStyleForest4;
  private boolean hasUsedCombatBook;
  private int lanternNightCooldown;
  private boolean lanternNightGenuine;
  private boolean lanternNightManual;
  private boolean lanternNightImminent;
  private int[] treeTopsVariations = new int[0];

  // ── Final State ──────────────────────────────────────────────────────────
  private boolean isHalloweenDay;
  private boolean isChristmasDay;
  private int oreCopper;
  private int oreIron;
  private int oreSilver;
  private int oreGold;
  private boolean hasBoughtCat;
  private boolean hasBoughtDog;
  private boolean hasBoughtBunny;
  private boolean isDefeatedEmpressOfLight;
  private boolean isDefeatedQueenSlime;
  private boolean isDefeatedDeerclops;
  private boolean hasSlimeNerdy;
  private boolean hasMerchant;
  private boolean hasDemolitionist;
  private boolean hasPartyGirl;
  private boolean hasDyeTrader;
  private boolean hasTruffle;
  private boolean hasArmsDealer;
  private boolean hasNurse;
  private boolean hasPrincess;
  private boolean hasUsedCombatBookV2;
  private boolean hasUsedPeddlerSatchel;
  private boolean hasSlimeCool;
  private boolean hasSlimeElder;
  private boolean hasSlimeClumsy;
  private boolean hasSlimeDiva;
  private boolean hasSlimeSurly;
  private boolean hasSlimeMystic;
  private boolean hasSlimeSquire;
  private boolean isRunningMoondial;
  private int moondialCooldown;
  private boolean isEndlessHalloweenWorld;
  private boolean isEndlessChristmasWorld;
  private boolean isVampireWorld;
  private boolean isInfectedWorld;
  private int meteorShowerCount;
  private int coinRain;
  private boolean isTeamBasedSpawnsWorld;
  private Point[] teamSpawnPoints = new Point[0];
  private boolean isDualDungeonWorld;
  private long internalVersion;
  private String manifest;

  // ── Constructors ─────────────────────────────────────────────────────────

  protected Header() { }

  public Header(
    String label,
    String seed,
    BigInteger genVersion,
    UUID uniqueId,
    int id,
    Rect bounds,
    Dimen dimen,
    int gameMode,
    boolean isDrunkWorld,
    boolean isWorthyWorld,
    boolean isMK10World,
    boolean isStarveWorld,
    boolean isBeesWorld,
    boolean isRemixWorld,
    boolean isTrapsWorld,
    boolean isZenithWorld,
    boolean isSkyblockWorld,
    LocalDateTime creationTime,
    LocalDateTime lastPlayed,
    int moonType,
    int[] treeX,
    int[] treeStyle,
    int[] caveBackX,
    int[] caveBackStyle,
    int tundraBackStyle,
    int jungleBackStyle,
    int hellBackStyle,
    Point spawnPoint,
    double surface,
    double cavern,
    double currentTime,
    boolean isDayTime,
    int moonPhase,
    boolean isBloodMoon,
    boolean isEclipse,
    Point dungeonPoint,
    boolean isCrimson,
    boolean isDefeatedEyeOfCthulhu,
    boolean isDefeatedEaterOfWorlds,
    boolean isDefeatedSkeletron,
    boolean isDefeatedQueenBee,
    boolean isDefeatedTheDestroyer,
    boolean isDefeatedTwins,
    boolean isDefeatedSkeletronPrime,
    boolean isDefeatedAnyMechnicalBoss,
    boolean isDefeatedPlantera,
    boolean isDefeatedGolem,
    boolean isDefeatedKingSlime,
    boolean hasGoblinTinkerer,
    boolean hasWizard,
    boolean hasMechanic,
    boolean isDefeatedGoblinArmy,
    boolean isDefeatedClown,
    boolean isDefeatedFrostMoon,
    boolean isDefeatedPirateInvasion,
    boolean shadowOrbSmashed,
    boolean spawnMeteor,
    int shadowOrbCount,
    int altarCount,
    boolean isHardMode,
    boolean isDoomedParty,
    int invasionDelay,
    int invasionSize,
    int invasionType,
    double invasionX,
    double slimeRainTime,
    int sundialCooldown,
    boolean isRaining,
    int rainTime,
    float maxRain,
    int oreCobalt,
    int oreMythril,
    int oreAdamantite,
    int bgStyleForest,
    int bgStyleCorruption,
    int bgStyleJungle,
    int bgStyleTundra,
    int bgStyleHallow,
    int bgStyleCrimson,
    int bgStyleDesert,
    int bgStyleOcean,
    float cloudBGActive,
    int numClouds,
    float windSpeed,
    String[] anglerWhoFinishedToday,
    boolean hasAngler,
    int anglerQuest,
    boolean hasStylist,
    boolean hasTaxCollector,
    boolean hasGolfer,
    int invasionSizeStart,
    int cultistDelay,
    int[] banners,
    int[] claimableBanners,
    boolean isRunningSundial,
    boolean isDefeatedDukeFishron,
    boolean isDefeatedMartianMadness,
    boolean isDefeatedLunaticCultist,
    boolean isDefeatedMoonLord,
    boolean isDefeatedPumpKing,
    boolean isDefeatedMourningWood,
    boolean isDefeatedIceQueen,
    boolean isDefeatedSantaNK1,
    boolean isDefeatedEverscream,
    boolean isDefeatedSolarPillar,
    boolean isDefeatedVortexPillar,
    boolean isDefeatedNebulaPillar,
    boolean isDefeatedStardustPillar,
    boolean isActiveSolarPillar,
    boolean isActiveVortexPillar,
    boolean isActiveNebulaPillar,
    boolean isActiveStardustPillar,
    boolean isActiveLunarApocalypse,
    boolean isPartyManual,
    boolean isPartyGenuine,
    int partyCooldown,
    int[] partyCelebratingNPCs,
    boolean isActiveSandstorm,
    int sandstormTimeLeft,
    float sandstormSeverity,
    float sandstormIntendedSeverity,
    boolean hasBartender,
    boolean[] isDefeatedDD2Invasion,
    int bgStyleMushroom,
    int bgStyleUnderworld,
    int bgStyleForest2,
    int bgStyleForest3,
    int bgStyleForest4,
    boolean hasUsedCombatBook,
    int lanternNightCooldown,
    boolean lanternNightGenuine,
    boolean lanternNightManual,
    boolean lanternNightImminent,
    int[] treeTopsVariations,
    boolean isHalloweenDay,
    boolean isChristmasDay,
    int oreCopper,
    int oreIron,
    int oreSilver,
    int oreGold,
    boolean hasBoughtCat,
    boolean hasBoughtDog,
    boolean hasBoughtBunny,
    boolean isDefeatedEmpressOfLight,
    boolean isDefeatedQueenSlime,
    boolean isDefeatedDeerclops,
    boolean hasSlimeNerdy,
    boolean hasMerchant,
    boolean hasDemolitionist,
    boolean hasPartyGirl,
    boolean hasDyeTrader,
    boolean hasTruffle,
    boolean hasArmsDealer,
    boolean hasNurse,
    boolean hasPrincess,
    boolean hasUsedCombatBookV2,
    boolean hasUsedPeddlerSatchel,
    boolean hasSlimeCool,
    boolean hasSlimeElder,
    boolean hasSlimeClumsy,
    boolean hasSlimeDiva,
    boolean hasSlimeSurly,
    boolean hasSlimeMystic,
    boolean hasSlimeSquire,
    boolean isRunningMoondial,
    int moondialCooldown,
    boolean isEndlessHalloweenWorld,
    boolean isEndlessChristmasWorld,
    boolean isVampireWorld,
    boolean isInfectedWorld,
    int meteorShowerCount,
    int coinRain,
    boolean isTeamBasedSpawnsWorld,
    Point[] teamSpawnPoints,
    boolean isDualDungeonWorld,
    long internalVersion,
    String manifest
  ) {
    this.label = label;
    this.seed = seed;
    this.genVersion = genVersion;
    this.uniqueId = uniqueId;
    this.id = id;
    this.bounds = bounds;
    this.dimen = dimen;
    this.difficulty = difficulty;
    this.isDrunkWorld = isDrunkWorld;
    this.isWorthyWorld = isWorthyWorld;
    this.isMK10World = isMK10World;
    this.isStarveWorld = isStarveWorld;
    this.isBeesWorld = isBeesWorld;
    this.isRemixWorld = isRemixWorld;
    this.isTrapsWorld = isTrapsWorld;
    this.isZenithWorld = isZenithWorld;
    this.isSkyblockWorld = isSkyblockWorld;
    this.creationTime = creationTime;
    this.lastPlayed = lastPlayed;
    this.moonType = moonType;
    this.treeX = treeX;
    this.treeStyle = treeStyle;
    this.caveBackX = caveBackX;
    this.caveBackStyle = caveBackStyle;
    this.tundraBackStyle = tundraBackStyle;
    this.jungleBackStyle = jungleBackStyle;
    this.hellBackStyle = hellBackStyle;
    this.spawnPoint = spawnPoint;
    this.surface = surface;
    this.cavern = cavern;
    this.currentTime = currentTime;
    this.isDayTime = isDayTime;
    this.moonPhase = moonPhase;
    this.isBloodMoon = isBloodMoon;
    this.isEclipse = isEclipse;
    this.dungeonPoint = dungeonPoint;
    this.isCrimson = isCrimson;
    this.isDefeatedEyeOfCthulhu = isDefeatedEyeOfCthulhu;
    this.isDefeatedEaterOfWorlds = isDefeatedEaterOfWorlds;
    this.isDefeatedSkeletron = isDefeatedSkeletron;
    this.isDefeatedQueenBee = isDefeatedQueenBee;
    this.isDefeatedTheDestroyer = isDefeatedTheDestroyer;
    this.isDefeatedTwins = isDefeatedTwins;
    this.isDefeatedSkeletronPrime = isDefeatedSkeletronPrime;
    this.isDefeatedAnyMechnicalBoss = isDefeatedAnyMechnicalBoss;
    this.isDefeatedPlantera = isDefeatedPlantera;
    this.isDefeatedGolem = isDefeatedGolem;
    this.isDefeatedKingSlime = isDefeatedKingSlime;
    this.hasGoblinTinkerer = hasGoblinTinkerer;
    this.hasWizard = hasWizard;
    this.hasMechanic = hasMechanic;
    this.isDefeatedGoblinArmy = isDefeatedGoblinArmy;
    this.isDefeatedClown = isDefeatedClown;
    this.isDefeatedFrostMoon = isDefeatedFrostMoon;
    this.isDefeatedPirateInvasion = isDefeatedPirateInvasion;
    this.shadowOrbSmashed = shadowOrbSmashed;
    this.spawnMeteor = spawnMeteor;
    this.shadowOrbCount = shadowOrbCount;
    this.altarCount = altarCount;
    this.isHardMode = isHardMode;
    this.isDoomedParty = isDoomedParty;
    this.invasionDelay = invasionDelay;
    this.invasionSize = invasionSize;
    this.invasionType = invasionType;
    this.invasionX = invasionX;
    this.slimeRainTime = slimeRainTime;
    this.sundialCooldown = sundialCooldown;
    this.isRaining = isRaining;
    this.rainTime = rainTime;
    this.maxRain = maxRain;
    this.oreCobalt = oreCobalt;
    this.oreMythril = oreMythril;
    this.oreAdamantite = oreAdamantite;
    this.bgStyleForest = bgStyleForest;
    this.bgStyleCorruption = bgStyleCorruption;
    this.bgStyleJungle = bgStyleJungle;
    this.bgStyleTundra = bgStyleTundra;
    this.bgStyleHallow = bgStyleHallow;
    this.bgStyleCrimson = bgStyleCrimson;
    this.bgStyleDesert = bgStyleDesert;
    this.bgStyleOcean = bgStyleOcean;
    this.cloudBGActive = cloudBGActive;
    this.numClouds = numClouds;
    this.windSpeed = windSpeed;
    this.anglerWhoFinishedToday = anglerWhoFinishedToday;
    this.hasAngler = hasAngler;
    this.anglerQuest = anglerQuest;
    this.hasStylist = hasStylist;
    this.hasTaxCollector = hasTaxCollector;
    this.hasGolfer = hasGolfer;
    this.invasionSizeStart = invasionSizeStart;
    this.cultistDelay = cultistDelay;
    this.banners = banners;
    this.claimableBanners = claimableBanners;
    this.isRunningSundial = isRunningSundial;
    this.isDefeatedDukeFishron = isDefeatedDukeFishron;
    this.isDefeatedMartianMadness = isDefeatedMartianMadness;
    this.isDefeatedLunaticCultist = isDefeatedLunaticCultist;
    this.isDefeatedMoonLord = isDefeatedMoonLord;
    this.isDefeatedPumpKing = isDefeatedPumpKing;
    this.isDefeatedMourningWood = isDefeatedMourningWood;
    this.isDefeatedIceQueen = isDefeatedIceQueen;
    this.isDefeatedSantaNK1 = isDefeatedSantaNK1;
    this.isDefeatedEverscream = isDefeatedEverscream;
    this.isDefeatedSolarPillar = isDefeatedSolarPillar;
    this.isDefeatedVortexPillar = isDefeatedVortexPillar;
    this.isDefeatedNebulaPillar = isDefeatedNebulaPillar;
    this.isDefeatedStardustPillar = isDefeatedStardustPillar;
    this.isActiveSolarPillar = isActiveSolarPillar;
    this.isActiveVortexPillar = isActiveVortexPillar;
    this.isActiveNebulaPillar = isActiveNebulaPillar;
    this.isActiveStardustPillar = isActiveStardustPillar;
    this.isActiveLunarApocalypse = isActiveLunarApocalypse;
    this.isPartyManual = isPartyManual;
    this.isPartyGenuine = isPartyGenuine;
    this.partyCooldown = partyCooldown;
    this.partyCelebratingNPCs = partyCelebratingNPCs;
    this.isActiveSandstorm = isActiveSandstorm;
    this.sandstormTimeLeft = sandstormTimeLeft;
    this.sandstormSeverity = sandstormSeverity;
    this.sandstormIntendedSeverity = sandstormIntendedSeverity;
    this.hasBartender = hasBartender;
    this.isDefeatedDD2Invasion = isDefeatedDD2Invasion;
    this.bgStyleMushroom = bgStyleMushroom;
    this.bgStyleUnderworld = bgStyleUnderworld;
    this.bgStyleForest2 = bgStyleForest2;
    this.bgStyleForest3 = bgStyleForest3;
    this.bgStyleForest4 = bgStyleForest4;
    this.hasUsedCombatBook = hasUsedCombatBook;
    this.lanternNightCooldown = lanternNightCooldown;
    this.lanternNightGenuine = lanternNightGenuine;
    this.lanternNightManual = lanternNightManual;
    this.lanternNightImminent = lanternNightImminent;
    this.treeTopsVariations = treeTopsVariations;
    this.isHalloweenDay = isHalloweenDay;
    this.isChristmasDay = isChristmasDay;
    this.oreCopper = oreCopper;
    this.oreIron = oreIron;
    this.oreSilver = oreSilver;
    this.oreGold = oreGold;
    this.hasBoughtCat = hasBoughtCat;
    this.hasBoughtDog = hasBoughtDog;
    this.hasBoughtBunny = hasBoughtBunny;
    this.isDefeatedEmpressOfLight = isDefeatedEmpressOfLight;
    this.isDefeatedQueenSlime = isDefeatedQueenSlime;
    this.isDefeatedDeerclops = isDefeatedDeerclops;
    this.hasSlimeNerdy = hasSlimeNerdy;
    this.hasMerchant = hasMerchant;
    this.hasDemolitionist = hasDemolitionist;
    this.hasPartyGirl = hasPartyGirl;
    this.hasDyeTrader = hasDyeTrader;
    this.hasTruffle = hasTruffle;
    this.hasArmsDealer = hasArmsDealer;
    this.hasNurse = hasNurse;
    this.hasPrincess = hasPrincess;
    this.hasUsedCombatBookV2 = hasUsedCombatBookV2;
    this.hasUsedPeddlerSatchel = hasUsedPeddlerSatchel;
    this.hasSlimeCool = hasSlimeCool;
    this.hasSlimeElder = hasSlimeElder;
    this.hasSlimeClumsy = hasSlimeClumsy;
    this.hasSlimeDiva = hasSlimeDiva;
    this.hasSlimeSurly = hasSlimeSurly;
    this.hasSlimeMystic = hasSlimeMystic;
    this.hasSlimeSquire = hasSlimeSquire;
    this.isRunningMoondial = isRunningMoondial;
    this.moondialCooldown = moondialCooldown;
    this.isEndlessHalloweenWorld = isEndlessHalloweenWorld;
    this.isEndlessChristmasWorld = isEndlessChristmasWorld;
    this.isVampireWorld = isVampireWorld;
    this.isInfectedWorld = isInfectedWorld;
    this.meteorShowerCount = meteorShowerCount;
    this.coinRain = coinRain;
    this.isTeamBasedSpawnsWorld = isTeamBasedSpawnsWorld;
    this.teamSpawnPoints = teamSpawnPoints;
    this.isDualDungeonWorld = isDualDungeonWorld;
    this.internalVersion = internalVersion;
    this.manifest = manifest;
  }

  // ── Identity & Geometry ──────────────────────────────────────────────────
  public String getLabel() { return label; }
  public void setLabel(String label) { this.label = label; }

  public String getSeed() { return seed; }
  public void setSeed(String seed) { this.seed = seed; }

  public BigInteger getGeneratorVersion() { return genVersion; }
  public void setGeneratorVersion(BigInteger genVersion) { this.genVersion = genVersion; }

  public UUID getUniqueId() { return uniqueId; }
  public void setUniqueId(UUID uniqueId) { this.uniqueId = uniqueId; }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public Rect getBounds() { return bounds; }
  public void setBounds(Rect bounds) { this.bounds = bounds; }
  public void setBounds(int l, int r, int t, int b) { this.bounds = new Rect(l, r, t, b); }

  public Dimen getDimen() { return dimen; }
  public void setDimen(Dimen dimen) { this.dimen = dimen; }
  public void setDimen(int w, int h) { this.dimen = new Dimen(w, h); }

  public Difficulty getDifficulty() { return difficulty; }
  public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
  public void setDifficulty(int difficulty) { this.difficulty = Difficulty.fromInt(difficulty); }

  public boolean isDrunkWorld() { return isDrunkWorld; }
  public void setDrunkWorld(boolean v) { this.isDrunkWorld = v; }

  public boolean isWorthyWorld() { return isWorthyWorld; }
  public void setWorthyWorld(boolean v) { this.isWorthyWorld = v; }

  public boolean isMK10World() { return isMK10World; }
  public void setMK10World(boolean v) { this.isMK10World = v; }

  public boolean isStarveWorld() { return isStarveWorld; }
  public void setStarveWorld(boolean v) { this.isStarveWorld = v; }

  public boolean isBeesWorld() { return isBeesWorld; }
  public void setBeesWorld(boolean v) { this.isBeesWorld = v; }

  public boolean isRemixWorld() { return isRemixWorld; }
  public void setRemixWorld(boolean v) { this.isRemixWorld = v; }

  public boolean isTrapsWorld() { return isTrapsWorld; }
  public void setTrapsWorld(boolean v) { this.isTrapsWorld = v; }

  public boolean isZenithWorld() { return isZenithWorld; }
  public void setZenithWorld(boolean v) { this.isZenithWorld = v; }

  public boolean isSkyblockWorld() { return isSkyblockWorld; }
  public void setSkyblockWorld(boolean v) { this.isSkyblockWorld = v; }

  public LocalDateTime getCreationTime() { return creationTime; }
  public void setCreationTime(LocalDateTime creationTime) { this.creationTime = creationTime; }

  public LocalDateTime getLastPlayed() { return lastPlayed; }
  public void setLastPlayed(LocalDateTime lastPlayed) { this.lastPlayed = lastPlayed; }

  // ── Scenery Styles ───────────────────────────────────────────────────────
  public int getMoonType() { return moonType; }
  public void setMoonType(int moonType) { this.moonType = moonType; }

  public int[] getTreeX() { return treeX; }
  public void setTreeX(int[] treeX) { this.treeX = treeX; }

  public int[] getTreeStyle() { return treeStyle; }
  public void setTreeStyle(int[] treeStyle) { this.treeStyle = treeStyle; }

  public int[] getCaveBackX() { return caveBackX; }
  public void setCaveBackX(int[] caveBackX) { this.caveBackX = caveBackX; }

  public int[] getCaveBackStyle() { return caveBackStyle; }
  public void setCaveBackStyle(int[] caveBackStyle) { this.caveBackStyle = caveBackStyle; }

  public int getTundraBackStyle() { return tundraBackStyle; }
  public void setTundraBackStyle(int v) { this.tundraBackStyle = v; }

  public int getJungleBackStyle() { return jungleBackStyle; }
  public void setJungleBackStyle(int v) { this.jungleBackStyle = v; }

  public int getHellBackStyle() { return hellBackStyle; }
  public void setHellBackStyle(int v) { this.hellBackStyle = v; }

  // ── Geography & Time ─────────────────────────────────────────────────────
  public Point getSpawnPoint() { return spawnPoint; }
  public void setSpawnPoint(Point spawnPoint) { this.spawnPoint = spawnPoint; }
  public void setSpawnPoint(int x, int y) { this.spawnPoint = new Point(x, y); }

  public double getSurface() { return surface; }
  public void setSurface(double surface) { this.surface = surface; }

  public double getCavern() { return cavern; }
  public void setCavern(double cavern) { this.cavern = cavern; }

  public double getCurrentTime() { return currentTime; }
  public void setCurrentTime(double currentTime) { this.currentTime = currentTime; }

  public boolean isDayTime() { return isDayTime; }
  public void setDayTime(boolean v) { this.isDayTime = v; }

  public int getMoonPhase() { return moonPhase; }
  public void setMoonPhase(int moonPhase) { this.moonPhase = moonPhase; }

  public boolean isBloodMoon() { return isBloodMoon; }
  public void setBloodMoon(boolean v) { this.isBloodMoon = v; }

  public boolean isEclipse() { return isEclipse; }
  public void setEclipse(boolean v) { this.isEclipse = v; }

  public Point getDungeonPoint() { return dungeonPoint; }
  public void setDungeonPoint(Point dungeonPoint) { this.dungeonPoint = dungeonPoint; }
  public void setDungeonPoint(int x, int y) { this.dungeonPoint = new Point(x, y); }

  // ── Early Progression ────────────────────────────────────────────────────
  public boolean isCrimson() { return isCrimson; }
  public void setCrimson(boolean v) { this.isCrimson = v; }

  public boolean isDefeatedEyeOfCthulhu() { return isDefeatedEyeOfCthulhu; }
  public void setDefeatedEyeOfCthulhu(boolean v) { this.isDefeatedEyeOfCthulhu = v; }

  public boolean isDefeatedEaterOfWorlds() { return isDefeatedEaterOfWorlds; }
  public void setDefeatedEaterOfWorlds(boolean v) { this.isDefeatedEaterOfWorlds = v; }

  public boolean isDefeatedSkeletron() { return isDefeatedSkeletron; }
  public void setDefeatedSkeletron(boolean v) { this.isDefeatedSkeletron = v; }

  public boolean isDefeatedQueenBee() { return isDefeatedQueenBee; }
  public void setDefeatedQueenBee(boolean v) { this.isDefeatedQueenBee = v; }

  public boolean isDefeatedTheDestroyer() { return isDefeatedTheDestroyer; }
  public void setDefeatedTheDestroyer(boolean v) { this.isDefeatedTheDestroyer = v; }

  public boolean isDefeatedTwins() { return isDefeatedTwins; }
  public void setDefeatedTwins(boolean v) { this.isDefeatedTwins = v; }

  public boolean isDefeatedSkeletronPrime() { return isDefeatedSkeletronPrime; }
  public void setDefeatedSkeletronPrime(boolean v) { this.isDefeatedSkeletronPrime = v; }

  public boolean isDefeatedAnyMechnicalBoss() { return isDefeatedAnyMechnicalBoss; }
  public void setDefeatedAnyMechnicalBoss(boolean v) { this.isDefeatedAnyMechnicalBoss = v; }

  public boolean isDefeatedPlantera() { return isDefeatedPlantera; }
  public void setDefeatedPlantera(boolean v) { this.isDefeatedPlantera = v; }

  public boolean isDefeatedGolem() { return isDefeatedGolem; }
  public void setDefeatedGolem(boolean v) { this.isDefeatedGolem = v; }

  public boolean isDefeatedKingSlime() { return isDefeatedKingSlime; }
  public void setDefeatedKingSlime(boolean v) { this.isDefeatedKingSlime = v; }

  public boolean hasGoblinTinkerer() { return hasGoblinTinkerer; }
  public void setHasGoblinTinkerer(boolean v) { this.hasGoblinTinkerer = v; }

  public boolean hasWizard() { return hasWizard; }
  public void setHasWizard(boolean v) { this.hasWizard = v; }

  public boolean hasMechanic() { return hasMechanic; }
  public void setHasMechanic(boolean v) { this.hasMechanic = v; }

  public boolean isDefeatedGoblinArmy() { return isDefeatedGoblinArmy; }
  public void setDefeatedGoblinArmy(boolean v) { this.isDefeatedGoblinArmy = v; }

  public boolean isDefeatedClown() { return isDefeatedClown; }
  public void setDefeatedClown(boolean v) { this.isDefeatedClown = v; }

  public boolean isDefeatedFrostMoon() { return isDefeatedFrostMoon; }
  public void setDefeatedFrostMoon(boolean v) { this.isDefeatedFrostMoon = v; }

  public boolean isDefeatedPirateInvasion() { return isDefeatedPirateInvasion; }
  public void setDefeatedPirateInvasion(boolean v) { this.isDefeatedPirateInvasion = v; }

  public boolean isShadowOrbSmashed() { return shadowOrbSmashed; }
  public void setShadowOrbSmashed(boolean v) { this.shadowOrbSmashed = v; }

  public boolean isSpawnMeteor() { return spawnMeteor; }
  public void setSpawnMeteor(boolean v) { this.spawnMeteor = v; }

  public int getShadowOrbCount() { return shadowOrbCount; }
  public void setShadowOrbCount(int shadowOrbCount) { this.shadowOrbCount = shadowOrbCount; }

  public int getAltarCount() { return altarCount; }
  public void setAltarCount(int altarCount) { this.altarCount = altarCount; }

  public boolean isHardMode() { return isHardMode; }
  public void setHardMode(boolean v) { this.isHardMode = v; }

  public boolean isDoomedParty() { return isDoomedParty; }
  public void setDoomedParty(boolean v) { this.isDoomedParty = v; }

  // ── Invasion State ───────────────────────────────────────────────────────
  public int getInvasionDelay() { return invasionDelay; }
  public void setInvasionDelay(int invasionDelay) { this.invasionDelay = invasionDelay; }

  public int getInvasionSize() { return invasionSize; }
  public void setInvasionSize(int invasionSize) { this.invasionSize = invasionSize; }

  public int getInvasionType() { return invasionType; }
  public void setInvasionType(int invasionType) { this.invasionType = invasionType; }

  public double getInvasionX() { return invasionX; }
  public void setInvasionX(double invasionX) { this.invasionX = invasionX; }

  // ── Weather & Hardmode Ores ──────────────────────────────────────────────
  public double getSlimeRainTime() { return slimeRainTime; }
  public void setSlimeRainTime(double slimeRainTime) { this.slimeRainTime = slimeRainTime; }

  public int getSundialCooldown() { return sundialCooldown; }
  public void setSundialCooldown(int sundialCooldown) { this.sundialCooldown = sundialCooldown; }

  public boolean isRaining() { return isRaining; }
  public void setRaining(boolean v) { this.isRaining = v; }

  public int getRainTime() { return rainTime; }
  public void setRainTime(int rainTime) { this.rainTime = rainTime; }

  public float getMaxRain() { return maxRain; }
  public void setMaxRain(float maxRain) { this.maxRain = maxRain; }

  public int getOreCobalt() { return oreCobalt; }
  public void setOreCobalt(int oreCobalt) { this.oreCobalt = oreCobalt; }

  public int getOreMythril() { return oreMythril; }
  public void setOreMythril(int oreMythril) { this.oreMythril = oreMythril; }

  public int getOreAdamantite() { return oreAdamantite; }
  public void setOreAdamantite(int oreAdamantite) { this.oreAdamantite = oreAdamantite; }

  // ── Biome Environment ────────────────────────────────────────────────────
  public int getBgStyleForest() { return bgStyleForest; }
  public void setBgStyleForest(int v) { this.bgStyleForest = v; }

  public int getBgStyleCorruption() { return bgStyleCorruption; }
  public void setBgStyleCorruption(int v) { this.bgStyleCorruption = v; }

  public int getBgStyleJungle() { return bgStyleJungle; }
  public void setBgStyleJungle(int v) { this.bgStyleJungle = v; }

  public int getBgStyleTundra() { return bgStyleTundra; }
  public void setBgStyleTundra(int v) { this.bgStyleTundra = v; }

  public int getBgStyleHallow() { return bgStyleHallow; }
  public void setBgStyleHallow(int v) { this.bgStyleHallow = v; }

  public int getBgStyleCrimson() { return bgStyleCrimson; }
  public void setBgStyleCrimson(int v) { this.bgStyleCrimson = v; }

  public int getBgStyleDesert() { return bgStyleDesert; }
  public void setBgStyleDesert(int v) { this.bgStyleDesert = v; }

  public int getBgStyleOcean() { return bgStyleOcean; }
  public void setBgStyleOcean(int v) { this.bgStyleOcean = v; }

  public float getCloudBGActive() { return cloudBGActive; }
  public void setCloudBGActive(float cloudBGActive) { this.cloudBGActive = cloudBGActive; }

  public int getNumClouds() { return numClouds; }
  public void setNumClouds(int numClouds) { this.numClouds = numClouds; }

  public float getWindSpeed() { return windSpeed; }
  public void setWindSpeed(float windSpeed) { this.windSpeed = windSpeed; }

  // ── NPCs & Angler ────────────────────────────────────────────────────────
  public String[] getAnglerWhoFinishedToday() { return anglerWhoFinishedToday; }
  public void setAnglerWhoFinishedToday(String[] v) { this.anglerWhoFinishedToday = v; }

  public boolean hasAngler() { return hasAngler; }
  public void setHasAngler(boolean v) { this.hasAngler = v; }

  public int getAnglerQuest() { return anglerQuest; }
  public void setAnglerQuest(int anglerQuest) { this.anglerQuest = anglerQuest; }

  public boolean hasStylist() { return hasStylist; }
  public void setHasStylist(boolean v) { this.hasStylist = v; }

  public boolean hasTaxCollector() { return hasTaxCollector; }
  public void setHasTaxCollector(boolean v) { this.hasTaxCollector = v; }

  public boolean hasGolfer() { return hasGolfer; }
  public void setHasGolfer(boolean v) { this.hasGolfer = v; }

  public int getInvasionSizeStart() { return invasionSizeStart; }
  public void setInvasionSizeStart(int invasionSizeStart) { this.invasionSizeStart = invasionSizeStart; }

  public int getCultistDelay() { return cultistDelay; }
  public void setCultistDelay(int cultistDelay) { this.cultistDelay = cultistDelay; }

  // ── Banners ──────────────────────────────────────────────────────────────
  public int[] getBanners() { return banners; }
  public void setBanners(int[] banners) { this.banners = banners; }

  public int[] getClaimableBanners() { return claimableBanners; }
  public void setClaimableBanners(int[] claimableBanners) { this.claimableBanners = claimableBanners; }

  // ── Late Progression ─────────────────────────────────────────────────────
  public boolean isRunningSundial() { return isRunningSundial; }
  public void setRunningSundial(boolean v) { this.isRunningSundial = v; }

  public boolean isDefeatedDukeFishron() { return isDefeatedDukeFishron; }
  public void setDefeatedDukeFishron(boolean v) { this.isDefeatedDukeFishron = v; }

  public boolean isDefeatedMartianMadness() { return isDefeatedMartianMadness; }
  public void setDefeatedMartianMadness(boolean v) { this.isDefeatedMartianMadness = v; }

  public boolean isDefeatedLunaticCultist() { return isDefeatedLunaticCultist; }
  public void setDefeatedLunaticCultist(boolean v) { this.isDefeatedLunaticCultist = v; }

  public boolean isDefeatedMoonLord() { return isDefeatedMoonLord; }
  public void setDefeatedMoonLord(boolean v) { this.isDefeatedMoonLord = v; }

  public boolean isDefeatedPumpKing() { return isDefeatedPumpKing; }
  public void setDefeatedPumpKing(boolean v) { this.isDefeatedPumpKing = v; }

  public boolean isDefeatedMourningWood() { return isDefeatedMourningWood; }
  public void setDefeatedMourningWood(boolean v) { this.isDefeatedMourningWood = v; }

  public boolean isDefeatedIceQueen() { return isDefeatedIceQueen; }
  public void setDefeatedIceQueen(boolean v) { this.isDefeatedIceQueen = v; }

  public boolean isDefeatedSantaNK1() { return isDefeatedSantaNK1; }
  public void setDefeatedSantaNK1(boolean v) { this.isDefeatedSantaNK1 = v; }

  public boolean isDefeatedEverscream() { return isDefeatedEverscream; }
  public void setDefeatedEverscream(boolean v) { this.isDefeatedEverscream = v; }

  public boolean isDefeatedSolarPillar() { return isDefeatedSolarPillar; }
  public void setDefeatedSolarPillar(boolean v) { this.isDefeatedSolarPillar = v; }

  public boolean isDefeatedVortexPillar() { return isDefeatedVortexPillar; }
  public void setDefeatedVortexPillar(boolean v) { this.isDefeatedVortexPillar = v; }

  public boolean isDefeatedNebulaPillar() { return isDefeatedNebulaPillar; }
  public void setDefeatedNebulaPillar(boolean v) { this.isDefeatedNebulaPillar = v; }

  public boolean isDefeatedStardustPillar() { return isDefeatedStardustPillar; }
  public void setDefeatedStardustPillar(boolean v) { this.isDefeatedStardustPillar = v; }

  public boolean isActiveSolarPillar() { return isActiveSolarPillar; }
  public void setActiveSolarPillar(boolean v) { this.isActiveSolarPillar = v; }

  public boolean isActiveVortexPillar() { return isActiveVortexPillar; }
  public void setActiveVortexPillar(boolean v) { this.isActiveVortexPillar = v; }

  public boolean isActiveNebulaPillar() { return isActiveNebulaPillar; }
  public void setActiveNebulaPillar(boolean v) { this.isActiveNebulaPillar = v; }

  public boolean isActiveStardustPillar() { return isActiveStardustPillar; }
  public void setActiveStardustPillar(boolean v) { this.isActiveStardustPillar = v; }

  public boolean isActiveLunarApocalypse() { return isActiveLunarApocalypse; }
  public void setActiveLunarApocalypse(boolean v) { this.isActiveLunarApocalypse = v; }

  // ── Party & Sandstorm ────────────────────────────────────────────────────
  public boolean isPartyManual() { return isPartyManual; }
  public void setPartyManual(boolean v) { this.isPartyManual = v; }

  public boolean isPartyGenuine() { return isPartyGenuine; }
  public void setPartyGenuine(boolean v) { this.isPartyGenuine = v; }

  public int getPartyCooldown() { return partyCooldown; }
  public void setPartyCooldown(int partyCooldown) { this.partyCooldown = partyCooldown; }

  public int[] getPartyCelebratingNPCs() { return partyCelebratingNPCs; }
  public void setPartyCelebratingNPCs(int[] v) { this.partyCelebratingNPCs = v; }

  public boolean isActiveSandstorm() { return isActiveSandstorm; }
  public void setActiveSandstorm(boolean v) { this.isActiveSandstorm = v; }

  public int getSandstormTimeLeft() { return sandstormTimeLeft; }
  public void setSandstormTimeLeft(int sandstormTimeLeft) { this.sandstormTimeLeft = sandstormTimeLeft; }

  public float getSandstormSeverity() { return sandstormSeverity; }
  public void setSandstormSeverity(float sandstormSeverity) { this.sandstormSeverity = sandstormSeverity; }

  public float getSandstormIntendedSeverity() { return sandstormIntendedSeverity; }
  public void setSandstormIntendedSeverity(float v) { this.sandstormIntendedSeverity = v; }

  // ── Old One's Army & Late Environment ────────────────────────────────────
  public boolean hasBartender() { return hasBartender; }
  public void setHasBartender(boolean v) { this.hasBartender = v; }

  public boolean isDefeatedDD2Invasion(int tier) { return tier >= 1 && tier <= 3 && isDefeatedDD2Invasion[tier - 1]; }
  public void setDefeatedDD2Invasion(boolean[] v) { this.isDefeatedDD2Invasion = v; }
  public void setDefeatedDD2Invasion(boolean tier1, boolean tier2, boolean tier3) { this.isDefeatedDD2Invasion = new boolean[] { tier1, tier2, tier3 }; }

  public int getBgStyleMushroom() { return bgStyleMushroom; }
  public void setBgStyleMushroom(int v) { this.bgStyleMushroom = v; }

  public int getBgStyleUnderworld() { return bgStyleUnderworld; }
  public void setBgStyleUnderworld(int v) { this.bgStyleUnderworld = v; }

  public int getBgStyleForest2() { return bgStyleForest2; }
  public void setBgStyleForest2(int v) { this.bgStyleForest2 = v; }

  public int getBgStyleForest3() { return bgStyleForest3; }
  public void setBgStyleForest3(int v) { this.bgStyleForest3 = v; }

  public int getBgStyleForest4() { return bgStyleForest4; }
  public void setBgStyleForest4(int v) { this.bgStyleForest4 = v; }

  public boolean hasUsedCombatBook() { return hasUsedCombatBook; }
  public void setHasUsedCombatBook(boolean v) { this.hasUsedCombatBook = v; }

  public int getLanternNightCooldown() { return lanternNightCooldown; }
  public void setLanternNightCooldown(int v) { this.lanternNightCooldown = v; }

  public boolean isLanternNightGenuine() { return lanternNightGenuine; }
  public void setLanternNightGenuine(boolean v) { this.lanternNightGenuine = v; }

  public boolean isLanternNightManual() { return lanternNightManual; }
  public void setLanternNightManual(boolean v) { this.lanternNightManual = v; }

  public boolean isLanternNightImminent() { return lanternNightImminent; }
  public void setLanternNightImminent(boolean v) { this.lanternNightImminent = v; }

  public int[] getTreeTopsVariations() { return treeTopsVariations; }
  public void setTreeTopsVariations(int[] v) { this.treeTopsVariations = v; }

  // ── Final State ──────────────────────────────────────────────────────────
  public boolean isHalloweenDay() { return isHalloweenDay; }
  public void setHalloweenDay(boolean v) { this.isHalloweenDay = v; }

  public boolean isChristmasDay() { return isChristmasDay; }
  public void setChristmasDay(boolean v) { this.isChristmasDay = v; }

  public int getOreCopper() { return oreCopper; }
  public void setOreCopper(int oreCopper) { this.oreCopper = oreCopper; }

  public int getOreIron() { return oreIron; }
  public void setOreIron(int oreIron) { this.oreIron = oreIron; }

  public int getOreSilver() { return oreSilver; }
  public void setOreSilver(int oreSilver) { this.oreSilver = oreSilver; }

  public int getOreGold() { return oreGold; }
  public void setOreGold(int oreGold) { this.oreGold = oreGold; }

  public boolean hasBoughtCat() { return hasBoughtCat; }
  public void setHasBoughtCat(boolean v) { this.hasBoughtCat = v; }

  public boolean hasBoughtDog() { return hasBoughtDog; }
  public void setHasBoughtDog(boolean v) { this.hasBoughtDog = v; }

  public boolean hasBoughtBunny() { return hasBoughtBunny; }
  public void setHasBoughtBunny(boolean v) { this.hasBoughtBunny = v; }

  public boolean isDefeatedEmpressOfLight() { return isDefeatedEmpressOfLight; }
  public void setDefeatedEmpressOfLight(boolean v) { this.isDefeatedEmpressOfLight = v; }

  public boolean isDefeatedQueenSlime() { return isDefeatedQueenSlime; }
  public void setDefeatedQueenSlime(boolean v) { this.isDefeatedQueenSlime = v; }

  public boolean isDefeatedDeerclops() { return isDefeatedDeerclops; }
  public void setDefeatedDeerclops(boolean v) { this.isDefeatedDeerclops = v; }

  public boolean hasSlimeNerdy() { return hasSlimeNerdy; }
  public void setHasSlimeNerdy(boolean v) { this.hasSlimeNerdy = v; }

  public boolean hasMerchant() { return hasMerchant; }
  public void setHasMerchant(boolean v) { this.hasMerchant = v; }

  public boolean hasDemolitionist() { return hasDemolitionist; }
  public void setHasDemolitionist(boolean v) { this.hasDemolitionist = v; }

  public boolean hasPartyGirl() { return hasPartyGirl; }
  public void setHasPartyGirl(boolean v) { this.hasPartyGirl = v; }

  public boolean hasDyeTrader() { return hasDyeTrader; }
  public void setHasDyeTrader(boolean v) { this.hasDyeTrader = v; }

  public boolean hasTruffle() { return hasTruffle; }
  public void setHasTruffle(boolean v) { this.hasTruffle = v; }

  public boolean hasArmsDealer() { return hasArmsDealer; }
  public void setHasArmsDealer(boolean v) { this.hasArmsDealer = v; }

  public boolean hasNurse() { return hasNurse; }
  public void setHasNurse(boolean v) { this.hasNurse = v; }

  public boolean hasPrincess() { return hasPrincess; }
  public void setHasPrincess(boolean v) { this.hasPrincess = v; }

  public boolean hasUsedCombatBookV2() { return hasUsedCombatBookV2; }
  public void setHasUsedCombatBookV2(boolean v) { this.hasUsedCombatBookV2 = v; }

  public boolean hasUsedPeddlerSatchel() { return hasUsedPeddlerSatchel; }
  public void setHasUsedPeddlerSatchel(boolean v) { this.hasUsedPeddlerSatchel = v; }

  public boolean hasSlimeCool() { return hasSlimeCool; }
  public void setHasSlimeCool(boolean v) { this.hasSlimeCool = v; }

  public boolean hasSlimeElder() { return hasSlimeElder; }
  public void setHasSlimeElder(boolean v) { this.hasSlimeElder = v; }

  public boolean hasSlimeClumsy() { return hasSlimeClumsy; }
  public void setHasSlimeClumsy(boolean v) { this.hasSlimeClumsy = v; }

  public boolean hasSlimeDiva() { return hasSlimeDiva; }
  public void setHasSlimeDiva(boolean v) { this.hasSlimeDiva = v; }

  public boolean hasSlimeSurly() { return hasSlimeSurly; }
  public void setHasSlimeSurly(boolean v) { this.hasSlimeSurly = v; }

  public boolean hasSlimeMystic() { return hasSlimeMystic; }
  public void setHasSlimeMystic(boolean v) { this.hasSlimeMystic = v; }

  public boolean hasSlimeSquire() { return hasSlimeSquire; }
  public void setHasSlimeSquire(boolean v) { this.hasSlimeSquire = v; }

  public boolean isRunningMoondial() { return isRunningMoondial; }
  public void setRunningMoondial(boolean v) { this.isRunningMoondial = v; }

  public int getMoondialCooldown() { return moondialCooldown; }
  public void setMoondialCooldown(int moondialCooldown) { this.moondialCooldown = moondialCooldown; }

  public boolean isEndlessHalloweenWorld() { return isEndlessHalloweenWorld; }
  public void setEndlessHalloweenWorld(boolean v) { this.isEndlessHalloweenWorld = v; }

  public boolean isEndlessChristmasWorld() { return isEndlessChristmasWorld; }
  public void setEndlessChristmasWorld(boolean v) { this.isEndlessChristmasWorld = v; }

  public boolean isVampireWorld() { return isVampireWorld; }
  public void setVampireWorld(boolean v) { this.isVampireWorld = v; }

  public boolean isInfectedWorld() { return isInfectedWorld; }
  public void setInfectedWorld(boolean v) { this.isInfectedWorld = v; }

  public int getMeteorShowerCount() { return meteorShowerCount; }
  public void setMeteorShowerCount(int meteorShowerCount) { this.meteorShowerCount = meteorShowerCount; }

  public int getCoinRain() { return coinRain; }
  public void setCoinRain(int coinRain) { this.coinRain = coinRain; }

  public boolean isTeamBasedSpawnsWorld() { return isTeamBasedSpawnsWorld; }
  public void setTeamBasedSpawnsWorld(boolean v) { this.isTeamBasedSpawnsWorld = v; }

  public Point[] getTeamSpawnPoints() { return teamSpawnPoints; }
  public void setTeamSpawnPoints(Point[] teamSpawnPoints) { this.teamSpawnPoints = teamSpawnPoints; }

  public boolean isDualDungeonWorld() { return isDualDungeonWorld; }
  public void setDualDungeonWorld(boolean v) { this.isDualDungeonWorld = v; }

  public long getInternalVersion() { return internalVersion; }
  public void setInternalVersion(long v) { this.internalVersion = v; }

  public String getManifest() { return manifest; }
  public void setManifest(String v) { this.manifest = v; }

  // ── Object overrides ─────────────────────────────────────────────────────

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return Objects.equals(uniqueId, ((Header) o).uniqueId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uniqueId);
  }

  @Override
  public String toString() {
    return "Header(" +
        "label=\"" + label + '"' +
        ", seed=\"" + seed + '"' +
        ", genVersion=" + genVersion +
        ", id=" + id +
        ", uniqueId=" + uniqueId +
        ", dimen=" + dimen +
        ", bounds=" + bounds +
        ", difficulty=" + difficulty +
        ", surface=" + surface +
        ", cavern=" + cavern +

        ", isDrunkWorld=" + isDrunkWorld +
        ", isWorthyWorld=" + isWorthyWorld +
        ", isMK10World=" + isMK10World +
        ", isStarveWorld=" + isStarveWorld +
        ", isBeesWorld=" + isBeesWorld +
        ", isRemixWorld=" + isRemixWorld +
        ", isTrapsWorld=" + isTrapsWorld +
        ", isZenithWorld=" + isZenithWorld +
        ", isSkyblockWorld=" + isSkyblockWorld +
        ", creationTime=" + creationTime +
        ", lastPlayed=" + lastPlayed +

        ", moonType=" + moonType +
        ", treeX=" + Arrays.toString(treeX) +
        ", treeStyle=" + Arrays.toString(treeStyle) +
        ", caveBackX=" + Arrays.toString(caveBackX) +
        ", caveBackStyle=" + Arrays.toString(caveBackStyle) +
        ", tundraBackStyle=" + tundraBackStyle +
        ", jungleBackStyle=" + jungleBackStyle +
        ", hellBackStyle=" + hellBackStyle +

        ", spawnPoint=" + spawnPoint +
        ", surface=" + surface +
        ", cavern=" + cavern +
        ", currentTime=" + currentTime +
        ", isDayTime=" + isDayTime +
        ", moonPhase=" + moonPhase +
        ", isBloodMoon=" + isBloodMoon +
        ", isEclipse=" + isEclipse +
        ", dungeonPoint=" + dungeonPoint +

        ", isCrimson=" + isCrimson +
        ", isDefeatedEyeOfCthulhu=" + isDefeatedEyeOfCthulhu +
        ", isDefeatedEaterOfWorlds=" + isDefeatedEaterOfWorlds +
        ", isDefeatedSkeletron=" + isDefeatedSkeletron +
        ", isDefeatedQueenBee=" + isDefeatedQueenBee +
        ", isDefeatedTheDestroyer=" + isDefeatedTheDestroyer +
        ", isDefeatedTwins=" + isDefeatedTwins +
        ", isDefeatedSkeletronPrime=" + isDefeatedSkeletronPrime +
        ", isDefeatedAnyMechnicalBoss=" + isDefeatedAnyMechnicalBoss +
        ", isDefeatedPlantera=" + isDefeatedPlantera +
        ", isDefeatedGolem=" + isDefeatedGolem +
        ", isDefeatedKingSlime=" + isDefeatedKingSlime +
        ", hasGoblinTinkerer=" + hasGoblinTinkerer +
        ", hasWizard=" + hasWizard +
        ", hasMechanic=" + hasMechanic +
        ", isDefeatedGoblinArmy=" + isDefeatedGoblinArmy +
        ", isDefeatedClown=" + isDefeatedClown +
        ", isDefeatedFrostMoon=" + isDefeatedFrostMoon +
        ", isDefeatedPirateInvasion=" + isDefeatedPirateInvasion +
        ", shadowOrbSmashed=" + shadowOrbSmashed +
        ", spawnMeteor=" + spawnMeteor +
        ", shadowOrbCount=" + shadowOrbCount +
        ", altarCount=" + altarCount +
        ", isHardMode=" + isHardMode +
        ", isDoomedParty=" + isDoomedParty +

        ", invasionDelay=" + invasionDelay +
        ", invasionSize=" + invasionSize +
        ", invasionType=" + invasionType +
        ", invasionX=" + invasionX +

        ", slimeRainTime=" + slimeRainTime +
        ", sundialCooldown=" + sundialCooldown +
        ", isRaining=" + isRaining +
        ", rainTime=" + rainTime +
        ", maxRain=" + maxRain +
        ", oreCobalt=" + oreCobalt +
        ", oreMythril=" + oreMythril +
        ", oreAdamantite=" + oreAdamantite +

        ", bgStyleForest=" + bgStyleForest +
        ", bgStyleCorruption=" + bgStyleCorruption +
        ", bgStyleJungle=" + bgStyleJungle +
        ", bgStyleTundra=" + bgStyleTundra +
        ", bgStyleHallow=" + bgStyleHallow +
        ", bgStyleCrimson=" + bgStyleCrimson +
        ", bgStyleDesert=" + bgStyleDesert +
        ", bgStyleOcean=" + bgStyleOcean +
        ", cloudBGActive=" + cloudBGActive +
        ", numClouds=" + numClouds +
        ", windSpeed=" + windSpeed +

        ", anglerWhoFinishedToday=" + Arrays.toString(anglerWhoFinishedToday) +
        ", hasAngler=" + hasAngler +
        ", anglerQuest=" + anglerQuest +
        ", hasStylist=" + hasStylist +
        ", hasTaxCollector=" + hasTaxCollector +
        ", hasGolfer=" + hasGolfer +
        ", invasionSizeStart=" + invasionSizeStart +
        ", cultistDelay=" + cultistDelay +

        ", banners=" + Arrays.toString(banners) +
        ", claimableBanners=" + Arrays.toString(claimableBanners) +

        ", isRunningSundial=" + isRunningSundial +
        ", isDefeatedDukeFishron=" + isDefeatedDukeFishron +
        ", isDefeatedMartianMadness=" + isDefeatedMartianMadness +
        ", isDefeatedLunaticCultist=" + isDefeatedLunaticCultist +
        ", isDefeatedMoonLord=" + isDefeatedMoonLord +
        ", isDefeatedPumpKing=" + isDefeatedPumpKing +
        ", isDefeatedMourningWood=" + isDefeatedMourningWood +
        ", isDefeatedIceQueen=" + isDefeatedIceQueen +
        ", isDefeatedSantaNK1=" + isDefeatedSantaNK1 +
        ", isDefeatedEverscream=" + isDefeatedEverscream +
        ", isDefeatedSolarPillar=" + isDefeatedSolarPillar +
        ", isDefeatedVortexPillar=" + isDefeatedVortexPillar +
        ", isDefeatedNebulaPillar=" + isDefeatedNebulaPillar +
        ", isDefeatedStardustPillar=" + isDefeatedStardustPillar +
        ", isActiveSolarPillar=" + isActiveSolarPillar +
        ", isActiveVortexPillar=" + isActiveVortexPillar +
        ", isActiveNebulaPillar=" + isActiveNebulaPillar +
        ", isActiveStardustPillar=" + isActiveStardustPillar +
        ", isActiveLunarApocalypse=" + isActiveLunarApocalypse +

        ", isPartyManual=" + isPartyManual +
        ", isPartyGenuine=" + isPartyGenuine +
        ", partyCooldown=" + partyCooldown +
        ", partyCelebratingNPCs=" + Arrays.toString(partyCelebratingNPCs) +
        ", isActiveSandstorm=" + isActiveSandstorm +
        ", sandstormTimeLeft=" + sandstormTimeLeft +
        ", sandstormSeverity=" + sandstormSeverity +
        ", sandstormIntendedSeverity=" + sandstormIntendedSeverity +

        ", hasBartender=" + hasBartender +
        ", isDefeatedDD2Invasion=" + Arrays.toString(isDefeatedDD2Invasion) +
        ", bgStyleMushroom=" + bgStyleMushroom +
        ", bgStyleUnderworld=" + bgStyleUnderworld +
        ", bgStyleForest2=" + bgStyleForest2 +
        ", bgStyleForest3=" + bgStyleForest3 +
        ", bgStyleForest4=" + bgStyleForest4 +
        ", hasUsedCombatBook=" + hasUsedCombatBook +
        ", lanternNightCooldown=" + lanternNightCooldown +
        ", lanternNightGenuine=" + lanternNightGenuine +
        ", lanternNightManual=" + lanternNightManual +
        ", lanternNightImminent=" + lanternNightImminent +
        ", treeTopsVariations=" + Arrays.toString(treeTopsVariations) +

        ", isHalloweenDay=" + isHalloweenDay +
        ", isChristmasDay=" + isChristmasDay +
        ", oreCopper=" + oreCopper +
        ", oreIron=" + oreIron +
        ", oreSilver=" + oreSilver +
        ", oreGold=" + oreGold +
        ", hasBoughtCat=" + hasBoughtCat +
        ", hasBoughtDog=" + hasBoughtDog +
        ", hasBoughtBunny=" + hasBoughtBunny +
        ", isDefeatedEmpressOfLight=" + isDefeatedEmpressOfLight +
        ", isDefeatedQueenSlime=" + isDefeatedQueenSlime +
        ", isDefeatedDeerclops=" + isDefeatedDeerclops +
        ", hasSlimeNerdy=" + hasSlimeNerdy +
        ", hasMerchant=" + hasMerchant +
        ", hasDemolitionist=" + hasDemolitionist +
        ", hasPartyGirl=" + hasPartyGirl +
        ", hasDyeTrader=" + hasDyeTrader +
        ", hasTruffle=" + hasTruffle +
        ", hasArmsDealer=" + hasArmsDealer +
        ", hasNurse=" + hasNurse +
        ", hasPrincess=" + hasPrincess +
        ", hasUsedCombatBookV2=" + hasUsedCombatBookV2 +
        ", hasUsedPeddlerSatchel=" + hasUsedPeddlerSatchel +
        ", hasSlimeCool=" + hasSlimeCool +
        ", hasSlimeElder=" + hasSlimeElder +
        ", hasSlimeClumsy=" + hasSlimeClumsy +
        ", hasSlimeDiva=" + hasSlimeDiva +
        ", hasSlimeSurly=" + hasSlimeSurly +
        ", hasSlimeMystic=" + hasSlimeMystic +
        ", hasSlimeSquire=" + hasSlimeSquire +
        ", isRunningMoondial=" + isRunningMoondial +
        ", moondialCooldown=" + moondialCooldown +
        ", isEndlessHalloweenWorld=" + isEndlessHalloweenWorld +
        ", isEndlessChristmasWorld=" + isEndlessChristmasWorld +
        ", isVampireWorld=" + isVampireWorld +
        ", isInfectedWorld=" + isInfectedWorld +
        ", meteorShowerCount=" + meteorShowerCount +
        ", coinRain=" + coinRain +
        ", isTeamBasedSpawnsWorld=" + isTeamBasedSpawnsWorld +
        ", teamSpawnPoints=" + Arrays.toString(teamSpawnPoints) +
        ", isDualDungeonWorld=" + isDualDungeonWorld +
        ", internalVersion=" + internalVersion +
        ", manifest=\"" + manifest + '"' +
        ')';
  }
}