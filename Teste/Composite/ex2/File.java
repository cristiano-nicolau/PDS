package Composite.ex2;

public class File implements Interface{
    private String nome;
    private int tamanho;

    public File (String s, int t){
        nome = s;
        tamanho = t;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void show() {
        System.out.println("Filename: " + nome);
        System.out.println("File Size: " + tamanho);
    }

    
}
