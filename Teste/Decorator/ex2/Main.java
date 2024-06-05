package Decorator.ex2;

public class Main {
    public static void main(String[] args) {
        Cafe expresso = new Expresso();
        System.out.println("Cafe expresso");
        System.out.println("Description: " + expresso.descricao());
        System.out.println("Cost: $" + expresso.custo());

        Cafe leiite = new MilkDecorator(expresso);
        System.out.println("Cafe expresso com leite");
        System.out.println("Description: " + leiite.descricao());
        System.out.println("Cost: $" + leiite.custo());

        Cafe acucar = new AcucarDecorator(expresso);
        System.out.println("Cafe expresso com acucar");
        System.out.println("Description: " + acucar.descricao());
        System.out.println("Cost: $" + acucar.custo());

        Cafe acucarleite = new AcucarDecorator(new MilkDecorator(expresso));
        System.out.println("Cafe expresso com acucar");
        System.out.println("Description: " + acucarleite.descricao());
        System.out.println("Cost: $" + acucarleite.custo());
    }
}
