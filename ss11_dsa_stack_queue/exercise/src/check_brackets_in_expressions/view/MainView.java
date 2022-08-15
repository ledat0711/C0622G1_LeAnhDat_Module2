package check_brackets_in_expressions.view;

import check_brackets_in_expressions.service.CheckBracketsInExpressions;

public class MainView {

    public static void main(String[] args) {
        String stringCheck1 = "s*(s–a)*(s–b)*(s–c)";
        String stringCheck2 = "s*(s–a)*(s–b*(s–c)";
        System.out.println(CheckBracketsInExpressions.check(stringCheck1));
        System.out.println(CheckBracketsInExpressions.check(stringCheck2));
    }
}