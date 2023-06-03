package ex1;

public class Empregado {
    private String nome;
    private String apelido;
    private int codigo;
    private int salario;

    public Empregado(String nome, String apelido, int codigo, int salario) {
        this.nome = nome;
        this.apelido = apelido;
        this.codigo = (int) codigo;
        this.salario = salario;
    }

    public String apelido() {
        return apelido;
    }

    public String nome() {
        return nome;
    }

    public int codigo() {
        return codigo;
    }

    public int salario() {
        return salario;
    }
}
