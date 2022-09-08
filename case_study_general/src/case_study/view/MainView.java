package case_study.view;

import case_study.controller.FuramaController;

public class MainView {
    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}