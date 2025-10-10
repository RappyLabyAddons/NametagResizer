package com.rappytv.nametagresizer.v1_21_10;

public class RenderStateAccessor {

  private static boolean player = false;

  public static boolean isPlayer() {
    return player;
  }

  public static void setPlayer(boolean player) {
    RenderStateAccessor.player = player;
  }
}
