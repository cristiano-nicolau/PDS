package Ex1;

public class PortionFactory{
    static String FruitName="kiwi";

    public static Portion create(String type, Temperature temperature){
        Portion[] Portions= new Portion[] {new Milk(), new FruitJuice(FruitName), new Tuna(),new Pork()};
        State state;

        if (type =="Beverage"){
            state = State.Liquid;
        }
        else if (type == "Meat"){
            state = State.Solid;
        }
        else{
            throw new IllegalArgumentException("Invalid type: " + type);
        }

        for (Portion port:Portions){
            if(port.getTemperature()==temperature && port.getState()==state){
                return port;
            }
        }

        return null;
    }

    public static Portion create(String type , Temperature temperature , String fruit_type){
        FruitName=fruit_type;
        return create(type,temperature);
    }

}