package model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private List<Employee> employees;

    public EmployeeDAO() {
        employees = new ArrayList<>();
        Employee employee1 = new Employee("Luigi", 2, 1234, "dev", false);
        Employee employee2 = new Employee("Joao", 3, 2020, "dev", true);
        employees.add(employee1);
        employees.add(employee2);
    }

    public List<Employee> getAllEmployees() {
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

    public void addEmployee(String name, int enrollment, int password, String function, boolean isAdmin) {
        Employee newEmployee = new Employee(name, enrollment, password, function, isAdmin);
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
}
