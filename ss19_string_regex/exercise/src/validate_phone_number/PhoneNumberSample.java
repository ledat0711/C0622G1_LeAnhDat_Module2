package validate_phone_number;

public class PhoneNumberSample {
    private static final String PHONE_NUMBER_FORMAT = "^[(][0-9]{2}[)][-][(][0][0-9]{9}[)]$";

    public PhoneNumberSample() {
    }

    public boolean validate(String stringInput) {
        return stringInput.matches(PHONE_NUMBER_FORMAT);
    }
}
