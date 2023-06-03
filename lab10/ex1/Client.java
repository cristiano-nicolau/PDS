package lab10.ex1;

public class Client implements Observer {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getType() {
        return "Client";
    }

    public String getName() {
        return this.name;
    }

    public void update(String s) {
        System.out.println(s);
    }

    public void bid(Product p, double v) {
        if (p!=null) {
            p.makeBid(v, this);
            p.notify("New bid: " + v);   
        }else{
            System.out.println("Product not found");
        }
    }    
}
