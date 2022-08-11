package view;

import controller.MainController;
import model.TennisGame;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter scores for each player.");
        System.out.print("Enter 1st player score: ");
        int scorePlayer1= Integer.parseInt(scanner.nextLine());
        System.out.print("Enter 2st player score: ");
        int scorePlayer2= Integer.parseInt(scanner.nextLine());
        System.out.println(MainController.returnResult(scorePlayer1, scorePlayer2));
    }
}