package _T2.XIII2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SeaPort implements Port {
    private Map<String, Ship> ships;

    public SeaPort() {
        this.ships = new HashMap<>();
    }

    @Override
    public boolean add(String ref, Ship ship) {
        if (exists(ref)) {
            ships.replace(ref, ship);
        } else {
            ships.put(ref, ship);
        }
        return true;
    }

    @Override
    public boolean exists(String ref) {
        return ships.containsKey(ref);
    }

    @Override
    public Ship remove(String ref) {
        return ships.remove(ref);
    }
    

    @Override
    public Iterator<String> iterator() {
        return ships.keySet().iterator();
    }


    public String show(String ref) {
        StringBuilder sb = new StringBuilder();
        sb.append(ref).append(": ").append(ships.get(ref)).append("\n");
        return sb.toString();
    }
}