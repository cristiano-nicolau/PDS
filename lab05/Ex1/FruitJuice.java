package Ex1;

public class FruitJuice extends PortionFactory implements Portion {
    String fruit;

    public FruitJuice(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    @Override
    public State getState() {
        return State.Liquid;
    }

    public String getFruit(){
        return fruit;
    }

    @Override
    public String toString(){
        return "FruitJuice:" + getFruit() + ", Temperature: " + getTemperature() + ", State: " + getState() + "";
    }


    
}
