package Decorator.ex1;

public class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text txt){
        super(txt);
    }

    @Override
    public String getContent() {
        return "<i>" + txt.getContent() + "</i>"; // Adiciona tags HTML de itálico
    }
}
