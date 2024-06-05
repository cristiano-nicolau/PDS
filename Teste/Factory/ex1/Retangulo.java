package Factory.ex1;

public class Retangulo implements Interface{
    private double cump;
    private double larg;
    public Retangulo(double c, double l){
        cump = c;
        larg =l;
    }
    @Override
    public double perimeter() {
       return (cump * 2 + larg * 2 );
    }
    @Override
    public double area() {
        return (cump * larg);
    }


}
