package view;

import controller.MemberController;

public class MainView {
    public static void main(String[] args) {
        MemberController memberController = new MemberController();
        memberController.menuManagementMember();
    }
}
