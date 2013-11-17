package com.ebay.game;

public enum GameType {
    PLAYER_VS_COMPUTER(0),
    COMPUTER_VS_COMPUTER(1);

    private final int index;

    GameType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    // ToDo: Refactor. There must be a better way
    public static GameType getByIndex(int index) {
        GameType result = GameType.PLAYER_VS_COMPUTER;
        for (GameType r : GameType.values()) {
            if (r.getIndex() == index) {
                result = r;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        switch (this) {
            case COMPUTER_VS_COMPUTER:
                return "Computer vs Computer";
            case PLAYER_VS_COMPUTER:
                default:
                return "Player vs Computer";
        }
    }
}
