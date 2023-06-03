package lab11.ex1;

public class mobile {
    private String processador;
    private float price;
    private float memory;
    private String camera;

    public mobile(String processador, float price, float memory, String camera) {
        this.processador = processador;
        this.price = price;
        this.memory = memory;
        this.camera = camera;
    }   

    public String getProcessador() {
        return processador;
    }

    public float getPrice() {
        return price;
    }

    public float getMemory() {
        return memory;
    }

    public String getCamera() {
        return camera;
    }
}
