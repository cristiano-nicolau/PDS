package Decorator.ex1;

public class NegritoDecorator extends TextDecorator {
    public NegritoDecorator(Text txt){
        super(txt);
    }

    @Override
    public String getContent() {
        return "<b>" + txt.getContent() + "</b>"; // Adiciona tags HTML de itálico
    }
}
