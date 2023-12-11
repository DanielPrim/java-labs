package model.products;

public class Car extends Product{
    private int quantity;
    // GET
    public int getQuantity() {
        return quantity;
    }
    //SET
    public void setQuantity() {
        this.quantity = quantity;
    }
    //CONSTRUCTOR
    public Car(int typeNumber, String name, int quantity) {
        super(typeNumber, name);
        this.typeNumber = 4;
        this.quantity = quantity;
    }
    //STRING
    public String toString() {
        return "Автомобиль" + "\t" + super.toString() + "\t" + quantity + " шт.";
    }
}
