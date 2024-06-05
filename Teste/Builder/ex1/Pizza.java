package Builder.ex1;

public class Pizza {
    private String name;
    private Tipo tipo;
    private String dough;
    private String sauce;
    private String topping;

    public Pizza () {        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String showPizza() {
        return "Pizza with name=" + name + "e tipo=" + tipo + ", com dough=" + dough + ", sauce=" + sauce + ", topping="
                + topping;
    }


    
}

