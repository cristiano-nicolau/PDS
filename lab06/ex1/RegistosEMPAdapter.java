package ex1;

public class RegistosEMPAdapter implements EmployeeAdapter{
    private Empregado empregado;
    public RegistosEMPAdapter(Empregado empregado) {
        this.empregado = empregado;
    }

    @Override
    public String getName() {
        return empregado.nome()+ " " +empregado.apelido();
    }   

    @Override
    public int getEmpNum() {
        return empregado.codigo();
    }

    @Override
    public int getSalary() {
        return empregado.salario();
    }  
}
