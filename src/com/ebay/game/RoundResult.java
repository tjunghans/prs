package com.ebay.game;


public enum RoundResult {
    TIE(0),
    WIN(1),
    LOOSE(-1);

    private int roundResult;

    private RoundResult(int roundResult) {
        this.roundResult = roundResult;
    }

    //todo refactor
    public static RoundResult getByIndex(int index) {
        RoundResult result = RoundResult.TIE;
        for (RoundResult r : RoundResult.values()) {
            if (r.getRoundResult() == index) {
                result = r;
            }
        }
        return result;
    }

    public int getRoundResult() {
        return roundResult;
    }
}
