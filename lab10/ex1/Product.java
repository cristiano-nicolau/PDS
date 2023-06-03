package lab10.ex1;

import java.util.ArrayList;
import java.util.Date;

public class Product {
    private static int codegenerator=0;
    private String descricao;
    private double price;
    private int code;
    private State state;

    ArrayList<Observer> participants = new ArrayList<Observer>();
    Date startTime;
    int maxTime=0;

    public Product(double price) {
        this.price = price;
        this.code=codegenerator++;
    }

    public boolean makeBid (double v, Observer o) {
        Date currentDate= new Date();
        int seconds=0;
        if (startTime!=null) {
            seconds = (int) ((currentDate.getTime() - startTime.getTime()) / 1000);
        }

        if (v<=price || this.state!=State.Auction || o.getType()!= "Client") {
            if (seconds > maxTime) {
                this.state=State.Sold;
            }
            return false;
        }
        price=v;
        return true;    
    }

    public boolean addOberserver(Observer o) {
        if (this.state==State.Auction) {
            participants.add(o);
            return true;
        }
        return false;
    }

    public void startAuction(int maxTime) {
        this.state=State.Auction;
        this.startTime= new Date();
        this.maxTime=maxTime;
    }

    public void notify(String s) {
        for (Observer o : participants) {
            o.update("["+  o.getType()+ " - "+ o.getName()+"] "+ s);
        }
    }

    public void setDisc(String s) {
        this.descricao=s;
    }

    public String getDisc() {
        return this.descricao;
    }

    public int getCode() {
        return this.code;
    }
}


