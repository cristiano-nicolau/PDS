package lab07.ex2;
import java.text.Normalizer;

public class NormalizationFilter extends TextDecorator{

    public NormalizationFilter(TextInterface i) {
        super(i);
    }
    @Override
    public boolean hasnext() {
        return super.hasnext();
    }
    @Override
    public String next() {
        String text = super.next();
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("[^a-zA-Z0-9]", " ");
        text = text.replaceAll("[.!?\\-,]", " ");
        return text;
    }
}
