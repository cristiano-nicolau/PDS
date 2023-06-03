package lab09.ex3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RemoveCommand<E> implements command<E> {
    private List<E> commands = new ArrayList<>();
    private Collection<E> collection;

    public RemoveCommand (Collection<E> collection) {
        this.collection = collection;
    }

    public boolean execute( E elem) {
        boolean result = collection.add(elem);
        if (result == true) {
            commands.add(elem);
            return true;
        }
        return false;
    }

    public void undo() {
        if (commands!= null) {
            collection.remove(commands.get(commands.size()-1));
            commands.remove(commands.get(commands.size()-1));
        }
    }
}
