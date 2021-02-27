package enums;

public enum SpringBeanName {
    USER_SERVICE("userService"),
    HTML_SERVICE("htmlService");
    private String name;
    SpringBeanName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
