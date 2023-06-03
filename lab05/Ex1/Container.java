package Ex1;


public abstract class Container implements Portion {

    public static Container create(Portion menuchoice){

        if (menuchoice == null){
            return null;
        }

        Container[] containers =new Container[] {new PlasticBottle(menuchoice),new TermicBottle(menuchoice),new Tupperware(menuchoice), new PlasticBag(menuchoice)};

        for (Container container : containers){
            if(menuchoice.getTemperature().equals(container.getTemperature()) && menuchoice.getState().equals(container.getState())){
                return container;
            }
        }

        return null;
    }




}
