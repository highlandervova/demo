package data;

import enums.OptionColor;

import java.util.Objects;

public class Option {
    private String id;
    private String name;
    private int color;

    public Option() {
    }

    public Option(String id, String name, int color) {
        this.id = id;
        this.name = name;
        this.color = color;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String out = "";
        String color = OptionColor.getColorNameById(this.color);
        out += color + " " + name;
        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return color == option.color && Objects.equals(id, option.id) && Objects.equals(name, option.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }

    public static Option copy(Option o) {
        Option out = new Option();
        out.setId(o.getId());
        out.setName(o.getName());
        out.setColor(o.getColor());
        return out;
    }
}
