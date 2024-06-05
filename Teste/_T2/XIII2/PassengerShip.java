package _T2.XIII2;

public class PassengerShip implements Ship {
    private String code;
    private String name;
    private int maxPassengers;

    public PassengerShip(String code, String name, int maxPassengers) {
        this.code = code;
        this.name = name;
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String name() {
        return name;
    }

    public int maxPassengers() {
        return maxPassengers;
    }


    @Override
    public String toString() {
        return "PassengerShip [code=" + code + ", name=" + name + ", passengers=" + maxPassengers + "]";
    }
}
