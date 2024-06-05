package _T2.XIII2;

public class CargoShip implements Ship {
    private String code;
    private String name;
    private double cargoWeight;

    public CargoShip(String code, String name, double cargoWeight) {
        this.code = code;
        this.name = name;
        this.cargoWeight = cargoWeight;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String name() {
        return name;
    }

    public double cargoWeight() {
        return cargoWeight;
    }


    @Override
    public String toString() {
        return "CargoShip [code=" + code + ", name=" + name + ", cargo=" + cargoWeight + "]";
    }

    
}
