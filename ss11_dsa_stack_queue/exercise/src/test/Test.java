package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("USA", "Washington DC");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        System.out.println(capitalCities);
        capitalCities.replace("USA", "Not");
        System.out.println(capitalCities);
        Queue<String> hh= new LinkedList<>();
        hh.element();
    }
}