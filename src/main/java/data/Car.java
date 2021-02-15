package data;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Car implements Serializable {
    private String id;
    private String name;
    private int    type;
    private int    price;
    private String description;
    private String picture;

    public Car() {
        this.id=UUID.randomUUID().toString();
    }

    public Car(String id, String name, int type, int price, String description, String picture) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return type == car.type && price == car.price && id.equals(car.id) && name.equals(car.name) && description.equals(car.description) && picture.equals(car.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price, description, picture);
    }
}
