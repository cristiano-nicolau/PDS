package lab10.ex1;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(10);
        p1.setDisc("Product 1- vw golf de 99");
        Product p2 = new Product(20);
        p2.setDisc("Product 2- ferrari azul");
        Product p3 = new Product(30);
        p3.setDisc("Product 3- iphone barato");


        Client c1 = new Client("Client 1");
        Client c2 = new Client("Client 2");
        Client c3 = new Client("Client 3");

        Manager m = new Manager("Manager");

        m.addProduct(p1);
        m.addProduct(p2);
        m.addProduct(p3);
   

        m.startAuction(p1, 10);
        m.startAuction(p2, 10);
        m.startAuction(p3, 10);

        p1.addOberserver(c1);
        c1.bid(p1, 15);
        p2.addOberserver(c2);
        c2.bid(p2, 5);
        p3.addOberserver(c3);
        c3.bid(p3, 50);



    }
}
