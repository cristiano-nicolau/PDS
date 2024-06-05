package Builder.ex1;

public class Waiter {
    private PizzaBuilder pizzaBuilder;

    public Waiter() {
        this.pizzaBuilder = new PizzaBuilder();
    }

    public Pizza constructPizza(String name, Tipo tipo, String dough, String sauce, String topping){
        return pizzaBuilder.addName(name)
                        .addTipo(tipo)
                        .addDough(dough)
                        .addSauce(sauce)
                        .addTopping(topping)
                        .build();
    }
}
