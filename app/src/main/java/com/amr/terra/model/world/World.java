package com.amr.terra.model.world;

import com.amr.terra.common.world.bestiary.Bestiary;
import com.amr.terra.common.world.chest.Chest;
import com.amr.terra.common.world.creative.Creative;
import com.amr.terra.common.world.header.Header;
import com.amr.terra.common.world.npc.Npc;
import com.amr.terra.common.world.pressureplate.PressurePlate;
import com.amr.terra.common.world.sign.Sign;
import com.amr.terra.common.world.tileentity.TileEntity;
import com.amr.terra.common.world.townroom.TownRoom;
import com.amr.terra.metadata.Metadata;
import java.util.Arrays;
import java.util.Objects;

public class World {

  private int version;
  private Metadata meta;
  private Header header;
  private Chest[] chests;
  private Sign[] signs;
  private Npc[] npcs;
  private TileEntity[] entities;
  private PressurePlate[] pressurePlates;
  private TownRoom[] townRooms;
  private Bestiary bestiary;
  private Creative creative;

  protected World() { }

  public World(
    int version,
    Metadata meta,
    Header header,
    Object[] tiles,
    Chest[] chests,
    Sign[] signs,
    Npc[] npcs,
    TileEntity[] entities,
    PressurePlate[] pressurePlates,
    TownRoom[] townRooms,
    Bestiary bestiary,
    Creative creative
  ) {
    this.version        = version;
    this.meta           = meta;
    this.header         = header;
    this.chests         = chests;
    this.signs          = signs;
    this.npcs           = npcs;
    this.entities       = entities;
    this.pressurePlates = pressurePlates;
    this.townRooms      = townRooms;
    this.bestiary       = bestiary;
    this.creative       = creative;
  }

  public int getVersion()                                       { return version; }
  public void setVersion(int version)                           { this.version = version; }

  public Metadata getMetadata()                                 { return meta; }
  public void setMetadata(Metadata meta)                        { this.meta = meta; }

  public Header getHeader()                                     { return header; }
  public void setHeader(Header header)                          { this.header = header; }

  public Chest[] getChests()                                    { return chests; }
  public void setChests(Chest[] chests)                         { this.chests = chests; }

  public Sign[] getSigns()                                      { return signs; }
  public void setSigns(Sign[] signs)                            { this.signs = signs; }

  public Npc[] getNpcs()                                        { return npcs; }
  public void setNpcs(Npc[] npcs)                               { this.npcs = npcs; }

  public TileEntity[] getTileEntities()                         { return entities; }
  public void setTileEntities(TileEntity[] entities)            { this.entities = entities; }

  public PressurePlate[] getPressurePlates()                    { return pressurePlates; }
  public void setPressurePlates(PressurePlate[] pressurePlates) { this.pressurePlates = pressurePlates; }

  public TownRoom[] getTownRooms()                              { return townRooms; }
  public void setTownRooms(TownRoom[] townRooms)                { this.townRooms = townRooms; }

  public Bestiary getBestiary()                                 { return bestiary; }
  public void setBestiary(Bestiary bestiary)                    { this.bestiary = bestiary; }

  public Creative getCreative()                                 { return creative; }
  public void setCreative(Creative creative)                    { this.creative = creative; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return Objects.equals(header, ((World) o).header);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header.getUniqueId());
  }

  @Override
  public String toString() {
    return "World("         +
        "version="          + version +
        ", metadata="       + meta +
        ", header="         + header +
        ", chests="         + Arrays.toString(chests) +
        ", signs="          + Arrays.toString(signs) +
        ", npcs="           + Arrays.toString(npcs) +
        ", entities="       + Arrays.toString(entities) +
        ", pressurePlates=" + Arrays.toString(pressurePlates) +
        ", townRooms="      + Arrays.toString(townRooms) +
        ", bestiary="       + bestiary +
        ", creative="       + creative +
        ')';
  }
}