package Visitor;

class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRectangle(this);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
