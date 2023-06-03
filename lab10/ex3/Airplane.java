package ex3;

public class Airplane {
    private String name;
    private Mediator mediator;

    public Airplane(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        System.out.println(name + " manda mensagem: " + message);
        mediator.sendMessage(this, message);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " recebe mensagem: " + message);
    }

}
