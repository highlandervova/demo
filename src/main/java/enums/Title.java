package enums;

public enum Title {

    AUTHENTICATION("Authentication"),
    REGISTRATION("Registration"),
    MAIN_PAGE("Main Page"),
    DETAIL("Car Detail");

    private Title(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
