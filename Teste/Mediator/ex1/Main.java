package Mediator.ex1;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        Colleague c1 = new Colleague(mediator, "João");
        Colleague c2 = new Colleague(mediator, "Pedro");
        Colleague c3 = new Colleague(mediator, "Maria");

        mediator.addColleague(c1);
        mediator.addColleague(c2);
        mediator.addColleague(c3);

        c1.sendMessage();
        c2.sendMessage();
        c3.sendMessage();
    }
}

class ChatMediator {
    private ArrayList<Colleague> list = new ArrayList<>();

    public void addColleague(Colleague c1) {
        System.out.println("[" + c1.getName() + "] joined the chat");
        list.add(c1);
    }

    public void sendMessage(Colleague sender) {
        for (Colleague colleague : list) {
            if (colleague != sender) {
                colleague.receiveMessage(sender.getName());
            }
        }
    }
}

class Colleague {
    private ChatMediator chat;
    private String name;

    public Colleague(ChatMediator mediator, String name) {
        this.chat = mediator;
        this.name = name;
    }

    public void sendMessage() {
        System.out.println("[" + name + "] sent a message by the mediator");
        chat.sendMessage(this);
    }

    public void receiveMessage(String senderName) {
        System.out.println("[" + name + "] received a message from [" + senderName + "]");
    }

    public String getName() {
        return name;
    }
}
