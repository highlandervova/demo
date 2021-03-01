package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "car_option")
public class CarOption {
    @Id
    private String id;
    @Column(name = "car_id")
    private String carId;
    @Column(name = "option_id")
    private String optionId;

    public CarOption() {
    }

    public CarOption(String id, String carId, String optionId) {
        this.id = id;
        this.carId = carId;
        this.optionId = optionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", carId='" + carId + '\'' +
                ", optionId='" + optionId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOption carOption = (CarOption) o;
        return Objects.equals(id, carOption.id) && Objects.equals(carId, carOption.carId) && Objects.equals(optionId, carOption.optionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId, optionId);
    }
}
