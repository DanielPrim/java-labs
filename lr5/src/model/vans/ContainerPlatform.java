package model.vans;

public class ContainerPlatform extends Van{
    private int capacity;
    // GET
    public int getCapacity() {
        return capacity;
    }
    //SET
    public void setCapacity() {
        this.capacity = capacity;
    }
    //CONSTRUCTOR
    public ContainerPlatform(String cargoName, int capacity) {
        super(cargoName);
        this.capacity = capacity;
    }
    //STRING
    public String toString() {
        return "Платформа для контейнеров" + "\t" + super.toString() + "\t" + capacity + " шт.";
    }
}
