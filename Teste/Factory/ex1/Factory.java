package Factory.ex1;

public class Factory {
    public static Interface createShape(String tipo, double... params){
        if (tipo.equalsIgnoreCase("circulo")){
            return new Circulo(params[0]);
        } else if (tipo.equalsIgnoreCase("retangulo")){
            return new Retangulo(params[0], params[1]);
        } else {
            return null;
        }
    }
}
