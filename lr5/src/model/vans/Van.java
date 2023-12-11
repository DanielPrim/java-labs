package model.vans;

import java.io.Serializable;

public abstract class Van implements Serializable {
    protected String cargoName;
    //GET
    public String getCargoName() {return cargoName;}
    //SET
    public void setCargoName() {this.cargoName = cargoName;}
    //CONSTRUCTOR
    protected Van(String cargoName) {
        this.cargoName = cargoName;
    }
    //STRING
    public String toString() {
        return cargoName;
    }
}
