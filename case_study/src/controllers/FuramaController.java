package controllers;

public class FuramaController {
    public static void displayMainMenu() throws Exception {
        int i = 0;
        int choice = 0;
        while (i < 10) {
            System.out.println("-------------------------------------------");
            System.out.println("1. Empoyee Management.");
            System.out.println("2. Customer Management.");
            System.out.println("3. Facility Management.");
            System.out.println("4. Booking Management.");
            System.out.println("5. Promotion Management.");
            System.out.println("6. Exit");
            System.out.print("Mời bạn nhập lựa chọn: ");
            i++;
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
