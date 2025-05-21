package com.rappytv.nametagresizer.event;

import net.labymod.api.event.Event;

public class NametagSizeEvent implements Event {

  private final boolean isPlayer;
  private float x;
  private float y;
  private float z;

  public NametagSizeEvent(boolean isPlayer, float x, float y, float z) {
    this.isPlayer = isPlayer;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public boolean isPlayer() {
    return this.isPlayer;
  }

  public float getX() {
    return this.x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return this.y;
  }

  public void setY(float y) {
    this.y = y;
  }

  public float getZ() {
    return this.z;
  }

  public void setZ(float z) {
    this.z = z;
  }
}
