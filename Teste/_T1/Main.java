package _T1;

public class Main {
    public static void main(String[] args) {

        Processador p1 = new Processador("Intel Core i7 Dual Core", "1.6GHz", "3MB");
        Memoria m1 = new Memoria("LPDDR3-1600", "8GB");
        Armazenamento a1 = new Armazenamento("SSD", "128GB");
        Computador c1 = new Computador.Builder("Apple Macbook Air", p1, m1, a1, 1159.0)
            .monitor("13\"")
            .peso("1.35kg")
            .addInterface("2x USB 3.1")
            .addInterface("HDMI")
            .addInterface("JACK 3.5mm (Combo)")
            .build();

        Processador p2 = new Processador("Intel Core i5", "2.3GHz", "6MB");
        Memoria m2 = new Memoria("DDR4", "16GB");
        Armazenamento a2 = new Armazenamento("HDD", "1TB");
        Computador c2 = new Computador.Builder("Dell XPS", p2, m2, a2, 999.0)
            .monitor("15\"")
            .peso("1.8kg")
            .addInterface("3x USB 3.0")
            .addInterface("VGA")
            .build();

        Processador p3 = new Processador("AMD Ryzen 5", "3.6GHz", "16MB");
        Memoria m3 = new Memoria("DDR4", "32GB");
        Armazenamento a3 = new Armazenamento("SSD", "512GB");
        Computador c3 = new Computador.Builder("HP Envy", p3, m3, a3, 1299.0)
            .monitor("17\"")
            .peso("2.2kg")
            .addInterface("4x USB-C")
            .addInterface("HDMI")
            .addInterface("Ethernet")
            .build();

        Revista revista = new Revista();
        revista.addComputador(c1);
        revista.addComputador(c2);
        revista.addComputador(c3);

        for (Computador cp : revista.getComputadores()){
            System.out.println(cp.toString());
        }
    }
}

