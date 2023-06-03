package Ex1;

public class TermicBottle extends Container{
    Portion menuchoice;

    public TermicBottle(Portion menuchoice){
        this.menuchoice = menuchoice;
    }

    public Portion gePortion(){
        return menuchoice;
    }

    public void setPortion(Portion menuchoice){
        this.menuchoice = menuchoice;
    }

    public Temperature getTemperature(){
        return Temperature.WARM;
    }

    public State getState(){
        return State.Liquid;
    }

    @Override
    public String toString(){
        return "TermicBottle  with portion:" + menuchoice;
    }

    
}
