package Builder.ex1;

public class Main {
    public static void main(String[] args) {
        Waiter emp1 = new Waiter();

        Pizza p1 = emp1.constructPizza("HawaiianPizza", Tipo.Circulo, "Thin", "Tomato", "Pineapple");
        System.out.println(p1.showPizza());

        Pizza p2 = emp1.constructPizza("MargheritaPizza", Tipo.Quadrado, "Thick", "Tomato", "Cheese");
        System.out.println(p2.showPizza());

    }
}
