package model;

public class TennisGame {
    public static final int POINT_0 = 0;
    public static final int POINT_1 = 1;
    public static final int POINT_2 = 2;
    public static final int POINT_3 = 3;
    public static final int SCORE_DIFFERENCE_ADVANTAGE = 1;
    public static final int SCORE_DIFFERENCE_WIN = 2;
    public static String resultDisplay="";
    public static int temp;

    public static String showTieResult(int drawPoint) {
        switch (drawPoint) {
            case POINT_0:
                resultDisplay = "Love-All";
                break;
            case POINT_1:
                resultDisplay = "Fifteen-All";
                break;
            case POINT_2:
                resultDisplay = "Thirty-All";
                break;
            default:
                resultDisplay = "Deuce";
                break;
        }
        return resultDisplay;
    }

    public static String showAfterDraw40(int player1, int player2) {
        if ((player1 - player2) >= SCORE_DIFFERENCE_WIN) {
            resultDisplay = "Win for player1";
        } else if ((player1 - player2) == SCORE_DIFFERENCE_ADVANTAGE) {
            resultDisplay = "Advantage player1";
        } else if ((player2 - player1) == SCORE_DIFFERENCE_ADVANTAGE) {
            resultDisplay = "Advantage player2";
        } else {
            resultDisplay = "Win for player2";
        }
        return resultDisplay;
    }

    public static String showScoreBefore40(int player1, int player2) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                temp = player1;
            } else {
                resultDisplay += "-";
                temp = player2;
            }
            switch (temp) {
                case POINT_0:
                    resultDisplay += "Love";
                    break;
                case POINT_1:
                    resultDisplay += "Fifteen";
                    break;
                case POINT_2:
                    resultDisplay += "Thirty";
                    break;
                case POINT_3:
                    resultDisplay += "Forty";
                    break;
            }
        }
        return resultDisplay;
    }
}