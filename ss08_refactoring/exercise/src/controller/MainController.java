package controller;

import model.TennisGame;

import java.util.Scanner;

import static model.TennisGame.*;

public class MainController {
    public static String returnResult(int playerScore1, int playerScore2) {
        if (playerScore1 == playerScore2) {
            resultDisplay = showTieResult(playerScore1);
        } else if (playerScore1 >= THREE_POINT + 1 || playerScore2 >= THREE_POINT + 1) {
            resultDisplay = showAfterDraw40(playerScore1, playerScore2);
        } else {
            resultDisplay = showScoreBefore40(playerScore1, playerScore2);
        }
        return resultDisplay;
    }

}