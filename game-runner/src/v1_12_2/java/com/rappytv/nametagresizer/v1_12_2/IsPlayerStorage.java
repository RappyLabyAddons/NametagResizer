package com.rappytv.nametagresizer.v1_12_2;

public class IsPlayerStorage {

    private static boolean isPlayer = false;

    public static boolean isPlayer() {
        return isPlayer;
    }

    public static void setPlayer(boolean player) {
        isPlayer = player;
    }
}
