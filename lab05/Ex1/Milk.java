package Ex1;

public class Milk extends PortionFactory implements Portion {


    @Override
    public Temperature getTemperature() {

        return Temperature.WARM;

    }

    @Override
    public State getState() {

        return State.Liquid;

    }

    @Override

    public String toString() {

        return "Milk: Temperature: " + getTemperature() + ", State: " + getState();
    }
    
}
