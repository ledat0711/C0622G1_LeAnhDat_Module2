package product_manager.service.impl;

import product_manager.model.Product;
import product_manager.utils.exception.InvalidException;

import java.util.List;
import java.util.Scanner;

public class CheckAndEnter {
    public static Product enterIDToFindUpdateRemove(List<Product> personList) {
        Scanner scanner = new Scanner(System.in);
        int i;
        int j = 0;
        String iD = scanner.nextLine();
        for (i = 0; i < personList.size(); i++) {
            if (personList.get(i).getID().equals(iD)) {
                return personList.get(i);
            }
        }
        return null;
    }
}
