package com.business_app;

import java.util.HashSet;
import java.util.Scanner;

public class BusinessManagement {

    static Scanner scanner = new Scanner(System.in);
    static Business business = new Business("MyCompany");


    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addDepartment();
                case 2 -> removeDepartment();
                case 3 -> addEmployee();
                case 4 -> removeEmployee();
                case 5 -> showAllEmployees();
                case 6 -> showAllPositions();
                case 7 -> showTotalSalary();
                case 8 -> {
                    System.out.println("Exiting the application.");
                    running = false;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
        scanner.close();

    }

    private static void showMenu() {

        System.out.println("\n--- Business Management System ---");
        System.out.println("1. Add Department");
        System.out.println("2. Remove Department");
        System.out.println("3. Add Employee to Department");
        System.out.println("4. Remove Employee from Department");
        System.out.println("5. Show All Employees in a Department");
        System.out.println("6. Show All Unique Positions");
        System.out.println("7. Show Total Company Salary");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");

    }

    private static void addDepartment() {
        System.out.print("Enter department name: ");
        String deptName = scanner.nextLine();
        business.addDepartment(new Department(deptName));
    }

    private static void removeDepartment() {
        System.out.print("Enter department name to remove: ");
        String deptName = scanner.nextLine();
        business.removeDepartment(deptName);
    }

    private static void addEmployee() {
        System.out.print("Enter department name: ");
        String deptName = scanner.nextLine();
        Department department = business.getDepartment(deptName);

        if (department != null) {
            System.out.print("Enter employee ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee position: ");
            String position = scanner.nextLine();
            System.out.print("Enter employee salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            department.addEmployee(new Employee(id, name, position, salary));
        } else {
            System.out.println("Department not found!");
        }
    }

    private static void removeEmployee() {
        System.out.print("Enter department name: ");
        String deptName = scanner.nextLine();
        Department department = business.getDepartment(deptName);

        if (department != null) {
            System.out.print("Enter employee ID to remove: ");
            String employeeId = scanner.nextLine();
            department.removeEmployee(employeeId);
        } else {
            System.out.println("Department not found!");
        }
    }

    private static void showAllEmployees() {
        System.out.print("Enter department name: ");
        String deptName = scanner.nextLine();
        Department department = business.getDepartment(deptName);

        if (department != null) {
            department.listEmployees();
        } else {
            System.out.println("Department not found!");
        }
    }

    private static void showAllPositions() {
        HashSet<String> positions = business.getAllPositions();
        System.out.println("Unique Positions in Company: " + positions);
    }

    private static void showTotalSalary() {
        double totalSalary = business.getTotalCompanySalary();
        System.out.println("Total Company Salary: " + totalSalary);
    }
}