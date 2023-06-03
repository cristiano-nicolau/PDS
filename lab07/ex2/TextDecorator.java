package lab07.ex2;

abstract class TextDecorator implements TextInterface {
    TextInterface i;
    public TextDecorator(TextInterface i) {
        this.i = i;
    }
    public boolean hasnext() {
        return i.hasnext();
    }
    public String next() {
        return i.next();
    }

}
