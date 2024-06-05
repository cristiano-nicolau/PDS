package _T1;

import java.util.ArrayList;
import java.util.List;

class Computador {
    private String nome;
    private Processador processador;
    private Memoria memoria;
    private Armazenamento armazenamento;
    private double preco;
    private String monitor;
    private String placaGrafica;
    private String camara;
    private String bateria;
    private String peso;
    private List<String> interfaces;

    private Computador(Builder builder) {
        this.nome = builder.nome;
        this.processador = builder.processador;
        this.memoria = builder.memoria;
        this.armazenamento = builder.armazenamento;
        this.preco = builder.preco;
        this.monitor = builder.monitor;
        this.placaGrafica = builder.placaGrafica;
        this.camara = builder.camara;
        this.bateria = builder.bateria;
        this.peso = builder.peso;
        this.interfaces = builder.interfaces;
    }

    public static class Builder {
        private String nome;
        private Processador processador;
        private Memoria memoria;
        private Armazenamento armazenamento;
        private double preco;
        private String monitor;
        private String placaGrafica;
        private String camara;
        private String bateria;
        private String peso;
        private List<String> interfaces = new ArrayList<>();

        public Builder(String nome, Processador processador, Memoria memoria, Armazenamento armazenamento, double preco) {
            this.nome = nome;
            this.processador = processador;
            this.memoria = memoria;
            this.armazenamento = armazenamento;
            this.preco = preco;
        }

        public Builder monitor(String monitor) {
            this.monitor = monitor;
            return this;
        }

        public Builder placaGrafica(String placaGrafica) {
            this.placaGrafica = placaGrafica;
            return this;
        }

        public Builder camara(String camara) {
            this.camara = camara;
            return this;
        }

        public Builder bateria(String bateria) {
            this.bateria = bateria;
            return this;
        }

        public Builder peso(String peso) {
            this.peso = peso;
            return this;
        }

        public Builder addInterface(String inter) {
            this.interfaces.add(inter);
            return this;
        }

        public Computador build() {
            return new Computador(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computador - ").append(nome).append("\n")
          .append(processador).append("\n")
          .append(armazenamento).append("\n")
          .append(memoria).append("\n");

        if (monitor != null) sb.append("monitor=").append(monitor).append("\n");
        if (placaGrafica != null) sb.append("placaGrafica=").append(placaGrafica).append("\n");
        if (camara != null) sb.append("camara=").append(camara).append("\n");
        if (bateria != null) sb.append("bateria=").append(bateria).append("\n");
        if (peso != null) sb.append("peso=").append(peso).append("\n");

        if (!interfaces.isEmpty()) {
            sb.append("interfaces= ");
            for (String inter : interfaces) {
                sb.append(inter).append("; ");
            }
            sb.append("\n");
        }

        sb.append("preco=").append(preco).append("\n");

        return sb.toString();
    }
}

