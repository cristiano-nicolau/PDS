package Builder.ex1;

public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder(){
        pizza = new Pizza();
    }

    public PizzaBuilder addName(String s){
        this.pizza.setName(s);
        return this;
    }

    public PizzaBuilder addTipo(Tipo t){
        this.pizza.setTipo(t);
        return this;
    }

    public PizzaBuilder addDough(String s){
        this.pizza.setDough(s);
        return this;
    }

    public PizzaBuilder addSauce(String s){
        this.pizza.setSauce(s);
        return this;
    }

    public PizzaBuilder addTopping(String s){
        this.pizza.setTopping(s);
        return this;
    }

    public Pizza build(){
        return pizza;
    }

}
