package enums;

public enum SpringBeanName {
    USER_SERVICE("userService"),
    HTML_SERVICE("htmlService"),
    OPTION_SERVICE("optionService"),
    CAR_SERVICE("carService"),
    VALIDATION_SERVICE("validationService"),
    CARDAO("cardao"),
    OPTION_DAO("optionDao"),
    CAR_OPTION_DAO("carOptionDao"),
    USER_DAO("userDao");

    private String name;
    SpringBeanName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
