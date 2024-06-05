package Factory.ex1;

public class Main {
    public static void main(String[] args) {
        Interface circulo = Factory.createShape("Circulo", 6);
        Interface retangulo = Factory.createShape("retangulo",5, 7);

        System.out.println("Circulo");
        System.out.println("Area: "+ circulo.area());
        System.out.println("Perimetro: "+ circulo.perimeter());
        System.out.println("\nRetangulo");
        System.out.println("Area: "+ retangulo.area());
        System.out.println("Perimetro: "+ retangulo.perimeter());

    }
}
