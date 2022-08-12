package view;

import controller.StudentController;

public class MainView {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.menuManagement();
    }
}