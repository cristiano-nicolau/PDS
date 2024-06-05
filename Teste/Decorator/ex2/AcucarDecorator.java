package Decorator.ex2;

public class AcucarDecorator extends CafeDecorator{
    public AcucarDecorator(Cafe cf){
        super(cf);
    }

    @Override
    public double custo() {
        return cafe.custo() + 0.75;
    }

    @Override
    public String descricao() {
       return cafe.descricao() + ", com açucar"; 
    }
}
