package com.amr.terra.common.world.creative;

import java.util.Objects;

public class Creative {

  // Time Section
  public static final int POWER_ID_TIME_LOCKED   = 0;  // FreezeTime                     `time_setfrozen`
  public static final int POWER_ID_SET_DAWN      = 1;  // StartDayImmediately            `time_setdawn`     04:30 AM
  public static final int POWER_ID_SET_NOON      = 2;  // StartNoonImmediately           `time_setnoon`     12:00 PM
  public static final int POWER_ID_SET_DUSK      = 3;  // StartNightImmediately          `time_setdusk`     07:30 PM
  public static final int POWER_ID_SET_MOON      = 4;  // StartMidnightImmediately       `time_setmidnight` 12:00 AM
  public static final int POWER_ID_TIME_RATE     = 8;  // ModifyTimeRate                 `time_setspeed`

  // Weather Section
  public static final int POWER_ID_WIND_STRENGTH = 6;  // ModifyWindDirectionAndStrength `wind_setstrength`
  public static final int POWER_ID_WIND_LOCKED   = 10; // FreezeWindDirectionAndStrength `wind_setfrozen`
  public static final int POWER_ID_RAIN_STRENGTH = 7;  // ModifyRainPower                `rain_setstrength`
  public static final int POWER_ID_RAIN_LOCKED   = 9;  // FreezeRainPower                `rain_setfrozen`

  // Powers Section
  public static final int POWER_ID_GODMODE       = 5;  // GodmodePower                   `godmode`
  public static final int POWER_ID_EXTEND_RANGE  = 11; // FarPlacementRangePower         `increaseplacementrange`
  public static final int POWER_ID_SPAWN_RATE    = 14; // SpawnRateSliderPerPlayerPower  `setspawnrate`
  public static final int POWER_ID_SPREAD_LOCKED = 13; // StopBiomeSpreadPower           `biomespread_setfrozen`
  public static final int POWER_ID_DIFFICULTY    = 12; // DifficultySliderPower          `setdifficulty`

  private boolean isTimeLocked, isGodMode, isRainLocked, isWindLocked, isExtendedRange, isBiomeSpread;
  private float timeRate, difficulty, spawnRate;

  protected Creative() { }
  public Creative(
    boolean isTimeLocked, boolean isGodMode, boolean isRainLocked,
    boolean isWindLocked, boolean isExtendedRange, boolean isBiomeSpread,
    float timeRate, float difficulty, float spawnRate
  ) {
    this.isTimeLocked = isTimeLocked;
    this.isGodMode = isGodMode;
    this.isRainLocked = isRainLocked;
    this.isWindLocked = isWindLocked;
    this.isExtendedRange = isExtendedRange;
    this.isBiomeSpread = isBiomeSpread;
    this.timeRate = timeRate;
    this.difficulty = difficulty;
    this.spawnRate = spawnRate;
  }

  public boolean isTimeLocked() { return isTimeLocked; }
  public void setTimeLocked(boolean isTimeLocked) { this.isTimeLocked = isTimeLocked; }

  public boolean isGodMode() { return isGodMode; }
  public void setGodMode(boolean isGodMode) { this.isGodMode = isGodMode; }

  public boolean isRainLocked() { return isRainLocked; }
  public void setRainLocked(boolean isRainLocked) { this.isRainLocked = isRainLocked; }

  public boolean isWindLocked() { return isWindLocked; }
  public void setWindLocked(boolean isWindLocked) { this.isWindLocked = isWindLocked; }

  public boolean isExtendedRange() { return isExtendedRange; }
  public void setExtendedRange(boolean isExtendedRange) { this.isExtendedRange = isExtendedRange; }

  public boolean isBiomeSpread() { return isBiomeSpread; }
  public void setBiomeSpread(boolean isBiomeSpread) { this.isBiomeSpread = isBiomeSpread; }

  public float getTimeRate() { return timeRate; }
  public void setTimeRate(float timeRate) { this.timeRate = timeRate; }

  public float getDifficulty() { return difficulty; }
  public void setDifficulty(float difficulty) { this.difficulty = difficulty; }

  public float getSpawnRate() { return spawnRate; }
  public void setSpawnRate(float spawnRate) { this.spawnRate = spawnRate; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Creative creative = (Creative) o;
    return isTimeLocked == creative.isTimeLocked
        && isGodMode == creative.isGodMode
        && isRainLocked == creative.isRainLocked
        && isWindLocked == creative.isWindLocked
        && isExtendedRange == creative.isExtendedRange
        && isBiomeSpread == creative.isBiomeSpread
        && Float.compare(timeRate, creative.timeRate) == 0
        && Float.compare(difficulty, creative.difficulty) == 0
        && Float.compare(spawnRate, creative.spawnRate) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(isTimeLocked, isGodMode, isRainLocked, isWindLocked, isExtendedRange, isBiomeSpread, timeRate, difficulty, spawnRate);
  }

  @Override
  public String toString() {
    return "Creative("
        + "isTimeLocked=" + isTimeLocked
        + ", isGodMode=" + isGodMode
        + ", isRainLocked=" + isRainLocked
        + ", isWindLocked=" + isWindLocked
        + ", isExtendedRange=" + isExtendedRange
        + ", isBiomeSpread=" + isBiomeSpread
        + ", timeRate=" + timeRate
        + ", difficulty=" + difficulty
        + ", spawnRate=" + spawnRate
        + ')';
  }
}
