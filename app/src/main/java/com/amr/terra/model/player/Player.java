package com.amr.terra.model.player;

import com.amr.terra.common.player.data.DisplayDevice;
import com.amr.terra.common.player.enums.BuilderAccessoriesId;
import com.amr.terra.data.Buff;
import com.amr.terra.data.Color;
import com.amr.terra.data.Item;
import com.amr.terra.data.Spawn;
import com.amr.terra.enums.Difficulty;
import com.amr.terra.enums.TeamId;
import com.amr.terra.metadata.Metadata;
import com.amr.terra.util.DateTime;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Player {

  private int version;
  private Metadata meta;
  private String name;
  private Difficulty difficulty;
  private Duration playTime;
  private TeamId team;
  private int hairStyle, hairDye, skinVariant;
  private int health, mana, healthMax, manaMax;
  private boolean usedDemonHeart, usedTochGodFavor, usedArtisanBread, usedVitalCrystal, usedAegisFruit, usedArcaneCrystal, usedGalaxyPearl, usedGummyWorm, usedAmbrosia;
  private boolean enabledTochGodFavor, defeatedDD2Invasion, hotbarLocked, dead;
  private int taxMoney, deathsPvE, deathsPvP, voidVaultInfo;
  private int anglerQuests, bartenderQuest, respawnTimer, golfScore;
  private LocalDateTime lastModifiedTime;
  private Color hairColor, skinColor, eyeColor, shirtColor, underShirtColor, pantsColor, shoeColor;
  private DisplayDevice displayDevice;

  private boolean[] hideAccessory  = new boolean[10];
  private boolean[] hideMisc       = new boolean[8];
  private Item[] equipments        = new Item[20];
  private Item[] dyes              = new Item[10];
  private Item[] inventory         = new Item[58]; // 50 item - 4 coins - 4 ammo
  private Item[] miscEquipments    = new Item[5]; // pet, light, mount, minecart, hook
  private Item[] miscDyes          = new Item[5];
  private Item[] piggyBank         = new Item[40];
  private Item[] safe              = new Item[40];
  private Item[] defenderForge     = new Item[40];
  private Item[] voidVault         = new Item[40];
  private Buff[] buffs             = new Buff[44];
  private Spawn[] spawns           = new Spawn[200];
  private int[] builderAccessories = new int[BuilderAccessoriesId.length()];

  protected Player() { }

  public Player(
    int version,
    Metadata meta,
    String name,
    Difficulty difficulty,
    Duration playTime,
    int hairStyle,
    int hairDye,
    TeamId team,
    boolean[] hideAccessory,
    boolean[] hideMisc,
    int skinVariant,
    int health,
    int healthMax,
    int mana,
    int manaMax,
    boolean usedDemonHeart,
    boolean usedTochGodFavor,
    boolean usedArtisanBread,
    boolean usedVitalCrystal,
    boolean usedAegisFruit,
    boolean usedArcaneCrystal,
    boolean usedGalaxyPearl,
    boolean usedGummyWorm,
    boolean usedAmbrosia,
    boolean enabledTochGodFavor,
    boolean defeatedDD2Invasion,
    int taxMoney,
    int deathsPvE,
    int deathsPvP,
    Color hairColor,
    Color skinColor,
    Color eyeColor,
    Color shirtColor,
    Color underShirtColor,
    Color pantsColor,
    Color shoeColor,
    Item[] equipments,
    Item[] dyes,
    Item[] inventory,
    Item[] miscEquipments,
    Item[] miscDyes,
    Item[] piggyBank,
    Item[] safe,
    Item[] defenderForge,
    Item[] voidVault,
    int voidVaultInfo,
    Buff[] buffs,
    Spawn[] spawns,
    boolean hotbarLocked,
    DisplayDevice displayDevice,
    int anglerQuests,
    int[] builderAccessories,
    int bartenderQuest,
    boolean dead,
    int respawnTimer,
    LocalDateTime lastModifiedTime
  ) {
    this.version              = version;
    this.meta                 = meta;
    this.name                 = name;
    this.difficulty           = difficulty;
    this.playTime             = playTime;
    this.hairStyle            = hairStyle;
    this.hairDye              = hairDye;
    this.team                 = team;
    this.hideAccessory        = hideAccessory;
    this.hideMisc             = hideMisc;
    this.skinVariant          = skinVariant;
    this.health               = health;
    this.healthMax            = healthMax;
    this.mana                 = mana;
    this.manaMax              = manaMax;
    this.usedDemonHeart       = usedDemonHeart;
    this.usedTochGodFavor     = usedTochGodFavor;
    this.usedArtisanBread     = usedArtisanBread;
    this.usedVitalCrystal     = usedVitalCrystal;
    this.usedAegisFruit       = usedAegisFruit;
    this.usedArcaneCrystal    = usedArcaneCrystal;
    this.usedGalaxyPearl      = usedGalaxyPearl;
    this.usedGummyWorm        = usedGummyWorm;
    this.usedAmbrosia         = usedAmbrosia;
    this.enabledTochGodFavor  = enabledTochGodFavor;
    this.defeatedDD2Invasion  = defeatedDD2Invasion;
    this.taxMoney             = taxMoney;
    this.deathsPvE            = deathsPvE;
    this.deathsPvP            = deathsPvP;
    this.hairColor            = hairColor;
    this.skinColor            = skinColor;
    this.eyeColor             = eyeColor;
    this.shirtColor           = shirtColor;
    this.underShirtColor      = underShirtColor;
    this.pantsColor           = pantsColor;
    this.shoeColor            = shoeColor;
    this.equipments           = equipments;
    this.dyes                 = dyes;
    this.inventory            = inventory;
    this.miscEquipments       = miscEquipments;
    this.miscDyes             = miscDyes;
    this.piggyBank            = piggyBank;
    this.safe                 = safe;
    this.defenderForge        = defenderForge;
    this.voidVault            = voidVault;
    this.voidVaultInfo        = voidVaultInfo;
    this.buffs                = buffs;
    this.spawns               = spawns;
    this.hotbarLocked         = hotbarLocked;
    this.displayDevice        = displayDevice;
    this.anglerQuests         = anglerQuests;
    this.builderAccessories   = builderAccessories;
    this.bartenderQuest       = bartenderQuest;
    this.dead                 = dead;
    this.respawnTimer         = respawnTimer;
    this.lastModifiedTime     = lastModifiedTime;
  }

  public int getVersion()                                       { return version; }
  public void setVersion(int version)                           { this.version = version; }

  public Metadata getMetadata()                                 { return meta; }
  public void setMetadata(Metadata meta)                        { this.meta = meta; }

  public String getName()                                       { return name; }
  public void setName(String name)                              { this.name = name; }

  public Difficulty getDifficulty()                             { return difficulty; }
  public void setDifficulty(Difficulty difficulty)              { this.difficulty = difficulty; }
  public void setDifficulty(int difficulty)                     { this.difficulty = Difficulty.fromInt(difficulty); }

  public Duration getPlayTime()                                 { return playTime; }
  public void setPlayTime(Duration playTime)                    { this.playTime = playTime; }

  // from 0 to 227, without 166
  public int getHairStyle()                                     { return hairStyle; }
  public void setHairStyle(int hairStyle)                       { this.hairStyle = hairStyle >= 228 ? 0 : hairStyle; }

  public int getHairDye()                                       { return hairDye; }
  public void setHairDye(int hairDye)                           { this.hairDye = hairDye; }

  public TeamId getTeam()                                       { return team; }
  public void setTeam(TeamId team)                              { this.team = team; }
  public void setTeam(int team)                                 { this.team = TeamId.fromInt(team); }

  public boolean isAccessoryHidden(int slot)                    { return slot >= 0 && slot < hideAccessory.length && hideAccessory[slot]; }
  public void setAccessoryHidden(int slot, boolean hidden)      { if (slot >= 0 && slot < hideAccessory.length) hideAccessory[slot] = hidden; }

  public boolean isMiscHidden(int slot)                         { return slot >= 0 && slot < hideMisc.length && hideMisc[slot]; }
  public void setMiscHidden(int slot, boolean hidden)           { if (slot >= 0 && slot < hideMisc.length) hideMisc[slot] = hidden; }

  public int getSkinVariant()                                   { return skinVariant; }
  public void setSkinVariant(int variant)                       { this.skinVariant = skinVariant >= 12 ? 0 : skinVariant; }

  public boolean isMale()                                       { return (skinVariant >= 0 && skinVariant <= 3) || skinVariant == 8 || skinVariant == 10; }

  public int getHealth()                                        { return health; }
  public void setHealth(int health)                             { this.health = health; }

  public int getHealthMax()                                     { return healthMax; }
  public void setHealthMax(int healthMax)                       { this.healthMax = healthMax > 500 ? 500 : healthMax; }

  public int getMana()                                          { return mana; }
  public void setMana(int mana)                                 { this.mana = mana > 400 ? 400 : mana; }

  public int getManaMax()                                       { return manaMax; }
  public void setManaMax(int manaMax)                           { this.manaMax = manaMax > 200 ? 200 : manaMax; }

  // dropped from wall of flesh in expert, master and legendary world
  public boolean isUsedDemonHeart()                             { return usedDemonHeart; }
  public void setUsedDemonHeart(boolean used)                   { this.usedDemonHeart = used; }

  // defeated the torch god.. google it
  public boolean isUsedTochGodFavor()                           { return usedTochGodFavor; }
  public void setUsedTochGodFavor(boolean used)                 { this.usedTochGodFavor = used; }

  // must be purchased from skeleton merchant during new moon or waning/waxing crescent
  public boolean isUsedArtisanBread()                           { return usedArtisanBread; }
  public void setUsedArtisanBread(boolean used)                 { this.usedArtisanBread = used; }

  // obtained by shimmering a life crystal
  public boolean isUsedVitalCrystal()                           { return usedVitalCrystal; }
  public void setUsedVitalCrystal(boolean used)                 { this.usedVitalCrystal = used; }

  // obtained by shimmering a life fruit
  public boolean isUsedAegisFruit()                             { return usedAegisFruit; }
  public void setUsedAegisFruit(boolean used)                   { this.usedAegisFruit = used; }

  // obtained by shimmering a mana crystal
  public boolean isUsedArcaneCrystal()                          { return usedArcaneCrystal; }
  public void setUsedArcaneCrystal(boolean used)                { this.usedArcaneCrystal = used; }

  // obtained by shimmering a pink perl
  public boolean isUsedGalaxyPearl()                            { return usedGalaxyPearl; }
  public void setUsedGalaxyPearl(boolean used)                  { this.usedGalaxyPearl = used; }

  // obtained by shimmering a goolden worm
  public boolean isUsedGummyWorm()                              { return usedGummyWorm; }
  public void setUsedGummyWorm(boolean used)                    { this.usedGummyWorm = used; }

  // obtained by shimmering a fruit, any type of fruit
  public boolean isUsedAmbrosia()                               { return usedAmbrosia; }
  public void setUsedAmbrosia(boolean used)                     { this.usedAmbrosia = used; }

  public boolean isEnabledTorchGodFavor()                       { return enabledTochGodFavor; }
  public void setEnabledTorchGodFavor(boolean enabled)          { this.enabledTochGodFavor = enabled; }

  public boolean isDefeatedDD2Invasion()                        { return defeatedDD2Invasion; }
  public void setDefeatedDD2Invasion(boolean defeated)          { this.defeatedDD2Invasion = defeated; }

  public int getTaxMoney()                                      { return taxMoney; }
  public void setTaxMoney(int taxMoney)                         { this.taxMoney = taxMoney; }

  public int getNumberOfDeathsPvE()                             { return deathsPvE; }
  public void setNumberOfDeathsPvE(int deathsPvE)               { this.deathsPvE = deathsPvE; }

  public int getNumberOfDeathsPvP()                             { return deathsPvP; }
  public void setNumberOfDeathsPvP(int deathsPvP)               { this.deathsPvP = deathsPvP; }

  public Color getHairColor()                                   { return hairColor; }
  public void setHairColor(Color hairColor)                     { this.hairColor = hairColor; }

  public Color getSkinColor()                                   { return skinColor; }
  public void setSkinColor(Color skinColor)                     { this.skinColor = skinColor; }

  public Color getEyeColor()                                    { return eyeColor; }
  public void setEyeColor(Color eyeColor)                       { this.eyeColor = eyeColor; }

  public Color getShirtColor()                                  { return shirtColor; }
  public void setShirtColor(Color shirtColor)                   { this.shirtColor = shirtColor; }

  public Color getUnderShirtColor()                             { return underShirtColor; }
  public void setUnderShirtColor(Color underShirtColor)         { this.underShirtColor = underShirtColor; }

  public Color getPantsColor()                                  { return pantsColor; }
  public void setPantsColor(Color pantsColor)                   { this.pantsColor = pantsColor; }

  public Color getShoeColor()                                   { return shoeColor; }
  public void setShoeColor(Color shoeColor)                     { this.shoeColor = shoeColor; }

  public Item[] getEquipments()                                 { return equipments; }
  public Item getEquipment(int slot)                            { return slot >= equipments.length ? null : equipments[slot]; }
  public void setEquipment(int slot, Item equipment)            { if (slot >= 0 && slot < equipments.length) equipments[slot] = equipment; }

  public Item[] getDyes()                                       { return dyes; }
  public Item getDye(int slot)                                  { return slot >= dyes.length ? null : dyes[slot]; }
  public void setDye(int slot, Item dye)                        { if (slot >= 0 && slot < dyes.length) dyes[slot] = dye; }

  public Item[] getInventory()                                  { return inventory; }
  public Item getInventoryItem(int slot)                        { return slot >= inventory.length ? null : inventory[slot]; }
  public void setInventoryItem(int slot, Item item)             { if (slot >= 0 && slot < inventory.length) inventory[slot] = item; }

  public Item[] getMiscEquipments()                             { return miscEquipments; }
  public Item getMiscEquipment(int slot)                        { return slot >= miscEquipments.length ? null : miscEquipments[slot]; }
  public void setMiscEquipment(int slot, Item equipment)        { if (slot >= 0 && slot < miscEquipments.length) miscEquipments[slot] = equipment; }

  public Item[] getMiscDyes()                                   { return miscDyes; }
  public Item getMiscDye(int slot)                              { return slot >= miscDyes.length ? null : miscDyes[slot]; }
  public void setMiscDye(int slot, Item dye)                    { if (slot >= 0 && slot < miscDyes.length) miscDyes[slot] = dye; }

  public Item[] getPiggyBank()                                  { return piggyBank; }
  public Item getPiggyBankItem(int slot)                        { return slot >= piggyBank.length ? null : piggyBank[slot]; }
  public void setPiggyBankItem(int slot, Item item)             { if (slot >= 0 && slot < piggyBank.length) piggyBank[slot] = item; }

  public Item[] getSafe()                                       { return safe; }
  public Item getSafeItem(int slot)                             { return slot >= safe.length ? null : safe[slot]; }
  public void setSafeItem(int slot, Item item)                  { if (slot >= 0 && slot < safe.length) safe[slot] = item; }

  public Item[] getDefenderForge()                              { return defenderForge; }
  public Item getDefenderForgeItem(int slot)                    { return slot >= defenderForge.length ? null : defenderForge[slot]; }
  public void setDefenderForgeItem(int slot, Item item)         { if (slot >= 0 && slot < defenderForge.length) defenderForge[slot] = item; }

  public Item[] getVoidVault()                                  { return voidVault; }
  public Item getVoidVaultItem(int slot)                        { return slot >= voidVault.length ? null : voidVault[slot]; }
  public void setVoidVaultItem(int slot, Item item)             { if (slot >= 0 && slot < voidVault.length) voidVault[slot] = item; }

  public int getVoidVaultInfo()                                 { return voidVaultInfo; }
  public void setVoidVaultInfo(int voidVaultInfo)               { this.voidVaultInfo = voidVaultInfo; }

  public Buff[] getBuffs()                                      { return buffs; }
  public Buff getBuff(int idx)                                  { return idx >= buffs.length ? null : buffs[idx]; }
  public void setBuff(int idx, Buff buff)                       { if (idx >= 0 && idx < buffs.length) buffs[idx] = buff; }

  public Spawn[] getSpawns()                                    { return spawns; }
  public Spawn getSpawn(int idx)                                { return idx >= spawns.length ? null : spawns[idx]; }
  public void setSpawn(int idx, Spawn spawn)                    { if (idx >= 0 && idx < spawns.length) spawns[idx] = spawn; }

  public boolean isHotbarLocked()                               { return hotbarLocked; }
  public void setHotbarLocked(boolean locked)                   { this.hotbarLocked = locked; }

  public DisplayDevice getDisplayDevice()                       { return displayDevice; }
  public void setDisplayDevice(DisplayDevice displayDevice)     { this.displayDevice = displayDevice; }

  public int getAnglerQuestsFinished()                          { return anglerQuests; }
  public void setAnglerQuestsFinished(int quests)               { this.anglerQuests = quests; }

  // skipping DPad Radial Bindings for now

  public int[] setBuilderAccessories()                          { return builderAccessories; }
  public int getBuilderAccessory(int slot)                      { return slot >= builderAccessories.length ? -1 : builderAccessories[slot]; }
  public void setBuilderAccessory(int slot, int itemId)         { if (slot >= 0 && slot < builderAccessories.length) builderAccessories[slot] = itemId; }


  public int getBartenderQuestLog()                             { return bartenderQuest; }
  public void setBartenderQuestLog(int questLog)                { this.bartenderQuest = questLog; }

  public boolean isDead()                                       { return dead; }
  public void setDead(boolean dead)                             { this.dead = dead; }

  public int getRespawnTimer()                                  { return dead ? respawnTimer : 0; }
  public void setRespawnTimer(int respawnTimer)                 { this.respawnTimer = respawnTimer; }

  public LocalDateTime getLastModifiedTime()                    { return lastModifiedTime; }
  public void setLastModifiedTime(LocalDateTime lastModified)   { this.lastModifiedTime = lastModified; }
  public void setLastModifiedTime(long lastModified)            { this.lastModifiedTime = DateTime.fromBinary(lastModified); }

  public int getGolferScoreAccumulated()                        { return golfScore; }
  public void setGolferScoreAccumulated(int score)              { this.golfScore = score; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Player p = (Player) o;
    return version == version
            && hairStyle == p.hairStyle
            && hairDye == p.hairDye
            && skinVariant == p.skinVariant
            && health == p.health
            && mana == p.mana
            && deathsPvE == p.deathsPvE
            && deathsPvP == p.deathsPvP
            && Objects.equals(name, p.name)
            && Objects.equals(difficulty, p.difficulty)
            && Objects.equals(playTime, p.playTime)
            && Objects.equals(team, p.team)
            && Objects.equals(hairColor, p.hairColor)
            && Objects.equals(skinColor, p.skinColor)
            && Objects.equals(eyeColor, p.eyeColor)
            && Objects.equals(shirtColor, p.shirtColor)
            && Objects.equals(underShirtColor, p.underShirtColor)
            && Objects.equals(pantsColor, p.pantsColor)
            && Objects.equals(shoeColor, p.shoeColor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
            version, name, difficulty, playTime,
            hairStyle, hairDye, team, skinVariant,
            health, mana, deathsPvE, deathsPvP,
            hairColor, skinColor, eyeColor, shirtColor,
            underShirtColor, pantsColor, shoeColor);
  }

  @Override
  public String toString() {
    return "Player("        +
        "version="          + version +
        ", metadata="       + meta +
        ", name="           + name +
        ", difficulty="     + difficulty +
        ", playTime="       + playTime +
        ", hairStyle="      + hairStyle +
        ", hairDye="        + hairDye +
        ", team="           + team +
        ", acessories="     + Arrays.toString(hideAccessory) +
        ", miscellaneous="  + Arrays.toString(hideMisc) +
        ", skinVariant="    + skinVariant +
        ", isMale="         + isMale() +
        ", health="         + health + "/" + healthMax +
        ", mana="           + mana + "/" + manaMax +
        ", demonHeart="     + usedDemonHeart +
        ", tochGodFavor="   + "(used=" + usedTochGodFavor + ", enabled=" + enabledTochGodFavor + ")" +
        ", artisanBread="   + usedArtisanBread +
        ", vitalCrystal="   + usedVitalCrystal +
        ", aegisFruit="     + usedAegisFruit +
        ", arcaneCrystal="  + usedArcaneCrystal +
        ", galaxyPearl="    + usedGalaxyPearl +
        ", gummyWorm="      + usedGummyWorm +
        ", ambrosia="       + usedAmbrosia +
        ", oldOneArmy="     + defeatedDD2Invasion + // seems to be incorrect
        ", taxMoney="       + taxMoney +
        ", deaths=("        + "PvE=" + deathsPvE + ", PvP=" + deathsPvP + ')' +
        ", hair="           + hairColor +
        ", skin="           + skinColor +
        ", eye="            + eyeColor +
        ", shirt="          + shirtColor +
        ", underShirt="     + underShirtColor +
        ", pants="          + pantsColor +
        ", shoe="           + shoeColor +
        ", equipments="     + Arrays.toString(equipments) +
        ", dyes="           + Arrays.toString(dyes) +
        ", inventory="      + Arrays.toString(inventory) +
        ", miscEquipments=" + Arrays.toString(miscEquipments) +
        ", miscDyes="       + Arrays.toString(miscDyes) +
        ", piggyBank="      + Arrays.toString(piggyBank) +
        ", safe="           + Arrays.toString(safe) +
        ", defenderForge="  + Arrays.toString(defenderForge) +
        ", voidVault="      + Arrays.toString(voidVault) +
        ", voidVaultInfo="  + voidVaultInfo +
        ", buffs="          + Arrays.toString(buffs) +
        ", spawns="         + Arrays.toString(spawns) +
        ", hotbarLocked="   + hotbarLocked +
        ", displayDevice="  + displayDevice +
        ", anglerQuests="   + anglerQuests +
        ", builderTools="   + Arrays.toString(builderAccessories) +
        ", bartenderQuest=" + bartenderQuest +
        ", dead="           + isDead() +
        ", respawnTimer="   + getRespawnTimer() +
        ", lastSave="       + lastModifiedTime +
        ", golfScore="      + golfScore +
        ')';
  }
}
