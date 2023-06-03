package lab10.ex1;

import java.util.ArrayList;

public class Manager implements Observer{
    private String name;
    ArrayList<Product> products =  new ArrayList<Product>();

    public Manager(String name) {
        this.name = name;
    }

    public String getType() {
        return "Manager";
    }

    public String getName() {
        return this.name;
    }

    public void update(String s) {
        System.out.println(s);
    }

    public void addProduct(Product p) {
        products.add(p);
        p.addOberserver(this);
    }

    public void startAuction(Product p, int maxTime) {
        p.startAuction(maxTime);
        p.notify("Start Auction!");
    }    
}
