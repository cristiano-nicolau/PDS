package lab07.ex2;

public class CapitalizationFilter extends TextDecorator{
    public CapitalizationFilter(TextInterface i) {
        super(i);
    }
    @Override
    public boolean hasnext() {
        return super.hasnext();
    }
    @Override
    public String next(){
        String text = super.next();
        
        text = text.substring(0, 1).toUpperCase() + text.substring(1, text.length()-1).toLowerCase() + text.substring(text.length()-1).toUpperCase();
        return text;
    }
}
