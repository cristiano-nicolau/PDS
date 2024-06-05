package Decorator.ex1;

public class TextDecorator implements Text {
    protected Text txt;

    public TextDecorator(Text text){
        this.txt =text;
    }

    @Override
    public String getContent() {
        return txt.getContent();
    }

    
    
}
