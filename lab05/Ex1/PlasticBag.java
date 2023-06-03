package Ex1;


public class PlasticBag extends Container {
    Portion menuchoice;

    public PlasticBag (Portion menuchoice){
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
        return State.Solid;
    }


    @Override
    public String toString(){
        return "PlasticBag  with portion:" + menuchoice;
    }
    
    
}
