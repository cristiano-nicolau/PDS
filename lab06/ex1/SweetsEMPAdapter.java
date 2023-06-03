package ex1;

public class SweetsEMPAdapter implements EmployeeAdapter{
    private Employee empregado;

    public SweetsEMPAdapter(Employee empregado) {
        this.empregado = empregado;
    }

    @Override
    public String getName() {
        return empregado.getName();
    }

    @Override
    public int getEmpNum() {
        return empregado.getEmpNum();
    }

    @Override
    public int getSalary() {
        return empregado.getSalary();
    }
    
}
