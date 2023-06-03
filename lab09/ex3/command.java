package lab09.ex3;

public interface command<E> {
    public boolean execute(E elem);
    public void undo();
}

