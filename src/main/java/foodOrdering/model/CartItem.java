package main.java.foodOrdering.model;

public class CartItem {
    private final FoodItem item;
    private int quantity;

    public CartItem(FoodItem item){
        this.item = item;
        this.quantity = 1;
    }

    public FoodItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increase(){
        quantity++;
    }

    public void decrease(){
        if(quantity > 1) quantity--;
    }

    public double getSubTotal(){
        return item.getPrice() * quantity;
    }
}
