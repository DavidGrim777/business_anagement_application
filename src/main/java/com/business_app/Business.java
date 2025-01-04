package com.business_app;

import java.util.HashMap;
import java.util.HashSet;

public class Business {

    private String name;
    private HashMap<String, Department> departments;

    public Business(String name) {
        this.name = name;
        this.departments = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDepartment(Department department) {
        if (!departments.containsKey((department.getName()))) {
            departments.put(department.getName(), department);
            System.out.println("Department added: " + department.getName());
        } else {
            System.out.println("Department with name " + department.getName() + " already exists.");
        }
    }

    void removeDepartment(String departmentName) {
        if (departments.containsKey(departmentName)) {
            departments.remove(departmentName);
            System.out.println("Department removed: " + departmentName);
        } else {
            System.out.println("Department with name " + departmentName + " not found.");
        }
    }

    Department getDepartment(String departmentName) {
        return departments.get(departmentName);
    }

    HashSet<String> getAllPositions() {
        HashSet<String> uniquePositions = new HashSet<>();
        for (Department department : departments.values()) {
            for (Employee employee : department.getEmployees()) {
                uniquePositions.add(employee.getPosition());
            }
        }
        return uniquePositions;
    }

    double getTotalCompanySalary() {
        double totalSalary = 0;
        for (Department department : departments.values()) {
            totalSalary = totalSalary + department.getTotalSalary();
        }
        return totalSalary;
    }
}
