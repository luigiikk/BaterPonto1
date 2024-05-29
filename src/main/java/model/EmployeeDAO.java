package model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static List<Employee> employees = new ArrayList<>();

    static {
        Employee employee1 = new Employee("Luigi", 2, 1234, "dev", true, 72000000, 12000);
        Employee employee2 = new Employee("Lu", 3, 1234, "dev", false, 72000000, 12000);
        Employee employee3 = new Employee("mateus", 4, 1234, "dev", false, 72000000, 12000);
        Employee employee4 = new Employee("joao", 5, 1234, "dev", true, 72000000, 12000);
        Employee employee5 = new Employee("jorge", 6, 1234, "dev", true, 72000000, 12000);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

    }

    public static List<Employee> getAllEmployees() {
        return employees;
    }


    public Employee getEmployee(int enrollment) {
        for (Employee employee : employees) {
            if (employee.getEnrollment() == enrollment) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(String name, int enrollment, int password, String function, boolean isAdmin, int saldoHoras, double salario) {
        Employee newEmployee = new Employee(name, enrollment, password, function, isAdmin, saldoHoras, salario);
        employees.add(newEmployee);
    }

    public boolean isValidEmployee(int enrollment, int password) {
        for (Employee employee : employees) {
            if (employee.getEnrollment() == enrollment && employee.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdmin(int enrollment) {
        for (Employee employee : employees) {
            if (employee.getEnrollment() == enrollment) {
                return employee.isAdmin();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("EmployeeDAO{employees=[");
        for (Employee employee : employees) {
            sb.append(employee.toString()).append(", ");
        }
        if (employees.size() > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]}");
        return sb.toString();
    }

}
