package Visitor;


class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }

    public double getRadius() {
        return radius;
    }

}
