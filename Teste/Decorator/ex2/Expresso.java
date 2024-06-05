package Decorator.ex2;

public class Expresso implements Cafe {

    @Override
    public double custo() {
        return 2.0;
    }

    @Override
    public String descricao() {
       return "Cafe expresso";
    }

}
