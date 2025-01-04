package com.business_app;

import com.business_app.Employee;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    public void removeEmployee(String employeeId) {
        Employee toRemove = null;
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                toRemove = employee;
                break;
            }
        }
        if (toRemove != null) {
            employees.remove(toRemove);
            System.out.println("Employee removed: " + toRemove.getName());
        } else {
            System.out.println("Employee with Id " + employeeId + " not found!");
        }
    }

    public Employee findEmployee(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    public double getTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary = totalSalary + employee.getSalary();
        }
        return totalSalary;
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in " + name + ".");
        } else {
            System.out.println("Employees in " + name + ":");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}