package com.marketsimplified;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee
{
    public static void update() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        System.out.println("---------------------------");
        System.out.println("Enter Employee details to modify");
        System.out.println("---------------------------");
        System.out.println("Enter employee id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter employee name");
        String name = scanner.nextLine();
        System.out.println("Enter employee age");
        int age = scanner.nextInt();
        System.out.println("Enter employee salary");
        int salary = scanner.nextInt();
        System.out.println("choose the type of an employee to modify");
        System.out.println("1.Permanent employee 2.Contract employee 3.part time employee");
        int select = scanner.nextInt();
        switch (select) {
            case 1 -> {
                System.out.println("Enter bonus amount");
                int bonus = scanner.nextInt();
                PermanentEmployee permanentEmployee = new PermanentEmployee(id, name, age, salary, bonus);
                employeeDatabase.updateEmployee(permanentEmployee);
            }
            case 2 -> {
                System.out.println("Enter contract period");
                int contractperiod = scanner.nextInt();
                ContractEmployee contractEmployee = new ContractEmployee(id, name, age, salary, contractperiod);
                employeeDatabase.updateEmployee(contractEmployee);
            }
            case 3 -> {
                System.out.println("Enter hours worked");
                int hoursWorked = scanner.nextInt();
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(id, name, age, salary, hoursWorked);
                employeeDatabase.updateEmployee(partTimeEmployee);
            }
            default -> {
            }
        }
    }
}
