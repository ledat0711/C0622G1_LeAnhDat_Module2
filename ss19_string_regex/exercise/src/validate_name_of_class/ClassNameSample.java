package validate_name_of_class;

public class ClassNameSample {
    private static final String CLASS_FORMAT = "^[CAP][0-9]{4}[G-IK-M]$";

    public ClassNameSample() {
    }

    public boolean validate(String stringInput) {
        return stringInput.matches(CLASS_FORMAT);
    }
}
