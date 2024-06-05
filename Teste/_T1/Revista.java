package _T1;

import java.util.ArrayList;
import java.util.List;

class Revista {
    private List<Computador> computadores;

    public Revista() {
        computadores = new ArrayList<>();
    }

    public void addComputador(Computador computador) {
        computadores.add(computador);
    }

    public List<Computador> getComputadores() {
        return computadores;
    }

}
