package model.products;

public class Container extends Product {
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
    public Container(int typeNumber, String name, int quantity) {
        super(typeNumber, name);
        this.typeNumber = 3;
        this.quantity = quantity;
    }
    //STRING
    public String toString() {
        return "Контейнер " + "\t" + super.toString() + "\t" + quantity + " шт.";
    }

}

