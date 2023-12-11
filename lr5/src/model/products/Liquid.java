package model.products;

public class Liquid extends Product{
    private float volume;
    // GET
    public float getQuantity() {
        return volume;
    }
    //SET
    public void setQuantity() {
        this.volume = volume;
    }
    //CONSTRUCTOR
    public Liquid(int typeNumber, String name, float volume) {
        super(typeNumber, name);
        this.typeNumber = 1;
        this.volume = volume;
    }
    //STRING
    public String toString() {
        return "Жидкость" + "\t" + super.toString() + "\t" + volume + " л";
    }
}

