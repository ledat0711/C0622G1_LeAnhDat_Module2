package controller;

import static model.TennisGame.*;

public class MainController {
    public static String returnResult(int playerScore1, int playerScore2) {
        if (playerScore1 == playerScore2) {
            resultDisplay = showTieResult(playerScore1);
        } else if (playerScore1 >= POINT_3 + 1 || playerScore2 >= POINT_3 + 1) {
            resultDisplay = showAfterDraw40(playerScore1, playerScore2);
        } else {
            resultDisplay = showScoreBefore40(playerScore1, playerScore2);
        }
        return resultDisplay;
    }

}