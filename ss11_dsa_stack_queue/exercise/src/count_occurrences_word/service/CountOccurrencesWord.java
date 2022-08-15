package count_occurrences_word.service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountOccurrencesWord {
    public static void countOccurrencesWordMethod() {
        String string1 = "Thu hai la ngay dau tuan chu nhat la ngay cuoi tuan";
        String[] arr = string1.toLowerCase().split(" ");
        Map<String, Integer> map1 = new TreeMap<>();
        for (String key : arr) {
            if (!map1.containsKey(key)) {
                map1.put(key, 1);
            } else {
                Integer value = map1.get(key);
                value++;
                map1.replace(key,value);
            }
        }
        System.out.println(map1);
    }
}
