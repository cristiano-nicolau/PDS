package State;

public class Main {
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        System.out.println("Current state: " + fan.getState());
        
        fan.pull(); // Turn on low speed
        System.out.println("Current state: " + fan.getState());
        
        fan.pull(); // Switch to medium speed
        System.out.println("Current state: " + fan.getState());
        
        fan.pull(); // Switch to high speed
        System.out.println("Current state: " + fan.getState());
        
        fan.pull(); // Turn off the fan
        System.out.println("Current state: " + fan.getState());
    }
}

class CeilingFan {
    private State state;

    public CeilingFan() {
        this.state = OffState.getInstance();
    }

    public void pull() {
        state.pull(this);
    }

    public String getState() {
        return state.getClass().getSimpleName();
    }

    public void setState(State state) {
        this.state = state;
    }
}

class OffState implements State{
    private static OffState instance = new OffState();

    private OffState() {
    }

    public static OffState getInstance() {
        return instance;
    }

    @Override
    public void pull(CeilingFan fan) {
        fan.setState(LowSpeedState.getInstance());
    }
    
}
class LowSpeedState implements State{
    private static LowSpeedState instance = new LowSpeedState();

    private LowSpeedState() {
    }

    public static LowSpeedState getInstance() {
        return instance;
    }

    @Override
    public void pull(CeilingFan fan) {
        fan.setState(MediumSpeedState.getInstance());
    }
    
}
class MediumSpeedState implements State{
    private static MediumSpeedState instance = new MediumSpeedState();

    private MediumSpeedState() {
    }

    public static MediumSpeedState getInstance() {
        return instance;
    }

    @Override
    public void pull(CeilingFan fan) {
        fan.setState(HighSpeedState.getInstance());
    }
    
}
class HighSpeedState implements State{
    private static HighSpeedState instance = new HighSpeedState();

    private HighSpeedState() {
    }

    public static HighSpeedState getInstance() {
        return instance;
    }

    @Override
    public void pull(CeilingFan fan) {
        fan.setState(OffState.getInstance());
    }

}
interface State {
    void pull(CeilingFan fan);
}

