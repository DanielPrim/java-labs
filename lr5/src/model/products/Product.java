package model.products;

public abstract class Product {
    protected String name;
    protected int typeNumber;
    //GET
    public String getName() {
        return name;
    }
    public int getTypeNumber() {
        return typeNumber;
    }
    //SET
    public void setName() {
        this.name = name;
    }
    public void setTypeNumber() {
        this.typeNumber = typeNumber;
    }
    //CONSTRUCTOR
    protected Product(int typeNumber, String name) {
        this.typeNumber = typeNumber;
        this.name = name;
    }
    //STRING
    public String toString() {
        return name;
    }
}
