package model.products;

public class BulkCargo extends Product{
    private float weight;
    // GET
    public float getQuantity() {
        return weight;
    }
    //SET
    public void setQuantity() {
        this.weight = weight;
    }
    //CONSTRUCTOR
    public BulkCargo(int typeNumber, String name, float weight) {
        super(typeNumber, name);
        this.typeNumber = 2;
        this.weight = weight;
    }
    //STRING
    public String toString() {
        return "Сыпучий груз" + "\t" + super.toString() + "\t" + weight + " кг";
    }
}
