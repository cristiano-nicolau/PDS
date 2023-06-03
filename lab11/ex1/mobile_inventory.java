package lab11.ex1;

import java.util.ArrayList;
import java.util.List;

public class mobile_inventory {
    private List<mobile> lista ;
    
    public mobile_inventory() {
        lista=new ArrayList<>();
    }

    public void addMobile(mobile m) {
        lista.add(m);
    }

    public List<mobile> getMobileList(sorting s, SpecType type){
        return s.sort(lista, type);
    }
}
