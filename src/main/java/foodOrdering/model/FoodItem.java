package main.java.foodOrdering.model;

public class FoodItem {
    private int id;
    private String name;
    private double price;
    private boolean veg;
    private boolean available;

    public FoodItem(int id, String name, double price, boolean veg, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.veg = veg;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVeg() {
        return veg;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

