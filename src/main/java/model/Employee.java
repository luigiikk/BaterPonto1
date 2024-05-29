package model;

public class Employee {
    private String name;
    private int enrollment;
    private int password;
    private String function;
    private boolean isAdmin;
    private long saldoHoras;
    private double salario;
    private String horasTotais;
    private String horasExtras;
    private String horasAPagar;
    private double salarioCalculado;

    public Employee(String name, int enrollment, int password, String function, boolean isAdmin, long saldoHoras, double salario){
        this.name = name;
        this.enrollment = enrollment;
        this.password = password;
        this.function = function;
        this.isAdmin = isAdmin;
        this.saldoHoras = saldoHoras;
        this.salario = salario;
    }
    public String getHorasTotais() {
        return horasTotais;
    }

    public void setHorasTotais(String horasTotais) {
        this.horasTotais = horasTotais;
    }

    public String getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(String horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getHorasAPagar() {
        return horasAPagar;
    }

    public void setHorasAPagar(String horasAPagar) {
        this.horasAPagar = horasAPagar;
    }

    public double getSalarioCalculado() {
        return salarioCalculado;
    }

    public void setSalarioCalculado(double salarioCalculado) {
        this.salarioCalculado = salarioCalculado;
    }

    public long getSaldoHoras() {
        return saldoHoras;
    }

    public void setSaldoHoras(long saldoHoras) {
        this.saldoHoras = saldoHoras;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", enrollment=" + enrollment +
                ", function='" + function + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
