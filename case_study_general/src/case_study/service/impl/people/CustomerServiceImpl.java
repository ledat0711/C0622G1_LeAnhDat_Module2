package case_study.service.impl.people;

import case_study.model.person.Customer;
import case_study.service.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private List<Customer> customerList = new LinkedList<>();

    static {

    }
    @Override
    public void display() {
    }

    @Override
    public void add() {
    }

    @Override
    public void edit() {
    }
}
