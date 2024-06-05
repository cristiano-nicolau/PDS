package Mediator.ex2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TowerMediator tw = new TowerMediator("Aeroporto Sa Carneiro");
        System.out.println(tw.toString());

        AirPlane a1 = new AirPlane("A12345", tw);
        AirPlane a2 = new AirPlane("A54321", tw);
        AirPlane a3 = new AirPlane("A09876", tw);
        AirPlane a4 = new AirPlane("A67890", tw);
        AirPlane a5 = new AirPlane("A13690", tw);

        tw.addAP(a5);
        tw.addAP(a4);
        tw.addAP(a3);
        tw.addAP(a2);
        tw.addAP(a1);

        a1.sendMessage("Venho da madeira e quero aterrar");
        a2.sendMessage("Vou evantar Voo");
        a3.sendMessage("Estou a abastecer na pista");
        a4.sendMessage("Vou arrancar para Sevilha");
    }
}

class TowerMediator{
    private ArrayList<AirPlane> airPlanes = new ArrayList<>();
    private String name;

    public TowerMediator(String name){
        this.name=name;
    }

    public void addAP(AirPlane ap){
        airPlanes.add(ap);
    }

    public void broadcastMessage(AirPlane airPlane, String message) {
        for (AirPlane ap : airPlanes){
            if (ap != airPlane){
                ap.receiveMessage(airPlane.getCode(), message);
            }
        }
    }

    @Override
    public String toString() {
        return "TowerMediator [name=" + name + "]";
    }

}

class AirPlane{
    private String code;
    private TowerMediator tw;

    public AirPlane(String cd, TowerMediator t){
        this.code = cd;
        this.tw=t;
    }

    public void sendMessage(String message) {
        System.out.println("[" + code + "] sent a message: " + message);
        tw.broadcastMessage(this, message);
    }

    public void receiveMessage(String senderCode, String message) {
        System.out.println("[" + code + "] received a message from [" + senderCode + "]: " + message);
    }

    public String getCode() {
        return code;
    }
}
