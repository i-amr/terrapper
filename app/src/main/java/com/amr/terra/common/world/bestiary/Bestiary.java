package com.amr.terra.common.world.bestiary;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bestiary {
  private List<Pair<String, Integer>> kills; // mob name -> kill count
  private List<String> sights;
  private List<String> chats;

  protected Bestiary() {
    kills = new ArrayList<>();
    sights = new ArrayList<>();
    chats = new ArrayList<>();
  }

  public Bestiary(List<Pair<String, Integer>> kills, List<String> sights, List<String> chats) {
    this.kills = kills;
    this.sights = sights;
    this.chats = chats;
  }

  public List<Pair<String, Integer>> getKills() {
    return kills;
  }

  public void setKills(List<Pair<String, Integer>> kills) {
    this.kills = kills;
  }

  public List<String> getSights() {
    return sights;
  }

  public void setSights(List<String> sights) {
    this.sights = sights;
  }

  public List<String> getChats() {
    return chats;
  }

  public void setChats(List<String> chats) {
    this.chats = chats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bestiary bestiary = (Bestiary) o;
    return kills.equals(bestiary.kills)
        && sights.equals(bestiary.sights)
        && chats.equals(bestiary.chats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kills, sights, chats);
  }

  @Override
  public String toString() {
    return "Bestiary(kills=" + kills + ", sights=" + sights + ", chats=" + chats + ')';
  }
}
