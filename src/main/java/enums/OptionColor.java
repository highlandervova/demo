package enums;

public enum OptionColor {
    BLACK(1, "Black"),
    RED(5, "Red");

    int id;
    String color;
    OptionColor(int id, String color) {
        this.id = id;
        this.color = color;
    }
    public static String getColorNameById(int colorId) {
        switch (colorId) {
            case 1:
                return BLACK.color;
            case 5:
                return RED.color;
        }
        return "";
    }
}
