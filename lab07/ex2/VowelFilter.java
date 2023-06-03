package lab07.ex2;

public class VowelFilter extends TextDecorator{

    public VowelFilter(TextInterface i) {
        super(i);
    }
    @Override
    public boolean hasnext() {
        return super.hasnext();
    }

    @Override
    public String next() {
        String text = super.next();
        text = text.replaceAll("[aeiouAEIOU]", "");
        return text;
    }
    
}
