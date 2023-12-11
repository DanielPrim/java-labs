package model.vans;

public class LiquidTank extends Van{
    private float capacity;
    // GET
    public float getCapacity() {
        return capacity;
    }
    //SET
    public void setCapacity() {
        this.capacity = capacity;
    }
    //CONSTRUCTOR
    public LiquidTank(String cargoName, float capacity) {
        super(cargoName);
        this.capacity = capacity;
    }
    //STRING
    public String toString() {
        return "Цистерна" + "\t" + super.toString() + "\t" + capacity + " л";
    }
}
