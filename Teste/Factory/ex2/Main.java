package Factory.ex2;

public class Main {
    public static void main(String[] args) {
        Tree apple = TreeFactory.creaTree("Apple");
        Tree peach = TreeFactory.creaTree("Peach");
        Tree lemon = TreeFactory.creaTree("Lemon");

        apple.getFruit();
        peach.getFruit();
        lemon.getFruit();
    }
}