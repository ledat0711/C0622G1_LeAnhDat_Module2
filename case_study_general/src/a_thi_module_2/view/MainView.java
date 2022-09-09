package a_thi_module_2.view;

import a_thi_module_2.controller.HumanResourceController;

public class MainView {
    public static void main(String[] args) {
        HumanResourceController humanResourceController = new HumanResourceController();
        humanResourceController.displayHumanResourceMenu();
    }
}