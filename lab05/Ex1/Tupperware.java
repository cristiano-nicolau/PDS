package Ex1;

public class Tupperware extends Container {
    Portion menuchoice;

    public Tupperware(Portion menuchoice){
        this.menuchoice = menuchoice;
    }


    public Portion getPortion() {
        return menuchoice;
    }

    public void setPortion(Portion menuchoice) {
        this.menuchoice = menuchoice;
    }

    public Temperature getTemperature(){
        return Temperature.WARM;
    }

    public State getState(){
        return State.Solid;
    }

    @Override
    public String toString(){
        return "Tupperware  with portion:" + menuchoice;
    }
    
}
