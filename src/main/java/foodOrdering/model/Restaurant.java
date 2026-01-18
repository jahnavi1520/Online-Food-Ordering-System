package main.java.foodOrdering.model;

import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String location;
    private boolean open;
    private List<FoodItem> menu;

    public Restaurant(int id, String name, String location, boolean open, List<FoodItem> menu) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.open = open;
        this.menu = menu;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    public void setMenu(List<FoodItem> menu) {
        this.menu = menu;
    }
}



