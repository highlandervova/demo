package enums;

public enum CarType {

    SEDAN(1),
    HATCHBACK(2),
    CROSSOVER(3);

    private CarType(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}
