package data;

import java.util.Objects;

public class CarOption {
    private String carId;
    private String optionId;

    public CarOption() {
    }

    public CarOption(String carId, String optionId) {
        this.carId = carId;
        this.optionId = optionId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    @Override
    public String toString() {
        return "CarOption{" +
                "carId='" + carId + '\'' +
                ", optionId='" + optionId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOption carOption = (CarOption) o;
        return Objects.equals(carId, carOption.carId) && Objects.equals(optionId, carOption.optionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, optionId);
    }
}
