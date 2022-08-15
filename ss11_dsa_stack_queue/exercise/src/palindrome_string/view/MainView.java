package palindrome_string.view;

import palindrome_string.service.PalindromeString;

public class MainView {
    public static void main(String[] args) {
        String string1 = "abcd e dcba";
        String string2 = "abjk e ddba";
        PalindromeString.checkPalindromeString(string1);
        PalindromeString.checkPalindromeString(string2);
    }
}
