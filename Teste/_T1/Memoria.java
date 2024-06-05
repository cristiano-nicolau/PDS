package _T1;

class Memoria {
    private String tipo;
    private String tamanho;

    public Memoria(String tipo, String tamanho) {
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Memoria [tipo=" + tipo + ", tamanho=" + tamanho + "]";
    }
}

