package Ex1;

public class Pork extends PortionFactory implements Portion {

    @Override
    public Temperature getTemperature() {

        return Temperature.WARM;

    }

    @Override
    public State getState() {

        return State.Solid;

    }

    @Override

    public String toString() {

        return "Pork: Temperature: " + getTemperature() + ", State: " + getState();
    }
    
}
    
