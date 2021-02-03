package enums;

public enum RedirectPath {

    AUTH_PAGE("/demo_war_exploded/auth"),
    MAIN_PAGE("/demo_war_exploded/main"),
    FIRST_PAGE("/demo_war_exploded/index.jsp"),
    REG_PAGE("/demo_war_exploded/reg"),
    ADD_PAGE("/demo_war_exploded/add"),
    DETAIL_PAGE("/demo_war_exploded/detail");

    private RedirectPath(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
