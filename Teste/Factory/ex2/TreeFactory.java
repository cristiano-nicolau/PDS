package Factory.ex2;

public class TreeFactory {
    public static Tree creaTree(String type){
        if (type.contains("Apple")){
            return new AppleTree();
        } else if (type.contains("Lemon")){
            return new LemonTree();
        } else if (type.contains("Peach")){
            return new PeaachTree();
        } else {
            return null;
        }
    }
}
