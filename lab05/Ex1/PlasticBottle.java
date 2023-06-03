package Ex1;

public class PlasticBottle extends Container{
    Portion menuchoice;

    public PlasticBottle(Portion menuchoice){
        this.menuchoice = menuchoice;
    }

    public Portion getPortion(){
        return menuchoice;
    }

    public void setPortion(Portion menuchoice){
        this.menuchoice = menuchoice;
    }

    public Temperature getTemperature(){
        return Temperature.COLD;
    }

    public State getState(){
        return State.Liquid;
    }

    @Override
    public String toString(){
        return "PlasticBottle with portion:" + menuchoice;
    }
    
}
