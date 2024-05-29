package model;

public class Employee {
    private String name;
    private int enrollment;
    private int password;
    private String function;
    private boolean isAdmin;

    public Employee(String name, int enrollment, int password, String function, boolean isAdmin){
        this.name = name;
        this.enrollment = enrollment;
        this.function = function;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getEnrollment(){
        return enrollment;
    }

    public void setEnrollment(int enrollment){
        this.enrollment = enrollment;
    }

    public String getFunction(){
        return function;
    }

    public void setFunction(String function){
        this.function = function;
    }

    public int getPassword(){
        return password;
    }

    public void setPassword(int password){
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
