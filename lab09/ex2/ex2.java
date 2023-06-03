package lab09.ex2;

public class ex2 {
    public static void main(String[] args) {
        chef chefs = new Sushi().setSucessor(
                new Pasta().setSucessor(new Burguer().setSucessor(new Pizza().setSucessor(new Dessert()))));

        System.out.println("\nCan i please get a veggie burger?");
        request r1 = new request("veggie burger", "burger");
        chefs.chef(r1);

        System.out.println("\nCan i please get a Pasta Carbonara?");
        request r2 = new request("Pasta Carbonara", "pasta");
        chefs.chef(r2);

        System.out.println("\nCan i please get a PLAIN pizza, no toppings?");
        request r3 = new request("PLAIN pizza, no toppings", "pizza");
        chefs.chef(r3);

        System.out.println("\nCan i please get a nigiri and sashimi?");
        request r4 = new request("nigiri and sashimi", "sushi");
        chefs.chef(r4);

        System.out.println("\nCan i please get a salad with tuna?");
        request r5 = new request("salad with tuna", "salad");
        chefs.chef(r5);

        System.out.println("\nCan i please get a strawberry ice cream and waffles dessert?");
        request r6 = new request("strawberry ice cream and waffles dessert", "dessert");
        chefs.chef(r6);
    }
}
