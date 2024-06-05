package Decorator.ex2;

public class CafeDecorator implements Cafe{
    protected Cafe cafe;

    public CafeDecorator(Cafe cf){
        this.cafe=cf;
    }

    @Override
    public double custo() {
        return cafe.custo();
    }

    @Override
    public String descricao() {
       return cafe.descricao();
    }

    
}
