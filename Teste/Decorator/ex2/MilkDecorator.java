package Decorator.ex2;

public class MilkDecorator extends CafeDecorator{
    public MilkDecorator(Cafe cf){
        super(cf);
    }

    @Override
    public double custo() {
        return cafe.custo() + 0.50;
    }

    @Override
    public String descricao() {
       return cafe.descricao() + ", com leite"; 
    }
}
