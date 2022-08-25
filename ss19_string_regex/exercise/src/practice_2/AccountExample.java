package practice_2;

public class AccountExample {
    /*Không chứa các ký tự đặc biệt
      Phải dài hơn 6 ký tự
      Không chứa các ký tự viết hoa
      Cho phép dấu gạch dưới (_)
    */
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public AccountExample() {
    }


    public boolean validate(String stringInput) {
        boolean isValid = stringInput.matches(ACCOUNT_REGEX);
        return isValid;
    }
}
