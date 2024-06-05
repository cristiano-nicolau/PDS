package Factory.ex1;

public class Circulo implements Interface {
    private double raio;
    public Circulo(double r){
        raio =r;
    }
    @Override
    public double area() {
        return (3.1614 * raio * raio );
    }
    @Override
    public double perimeter() {
        return (2 * 3.1416 * raio);
    }
}
