package com.marketsimplified;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee
{
    public static void delete() throws SQLException
    {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        System.out.println("Choose which type of an employee you are going to delete");
        System.out.println("1.Permanent employee 2.Contract employee 3.part time employee");
        int select = scanner.nextInt();
        switch (select)
        {
            case 1:
                System.out.println("Enter the employee id to delete");
                int empId = scanner.nextInt();
                employeeDatabase.deleteEmployee1(empId);
                break;
            case 2:
                System.out.println("Enter the employee id to delete");
                empId = scanner.nextInt();
                employeeDatabase.deleteEmployee2(empId);
                break;
            case 3:
                System.out.println("Enter the employee id to delete");
                empId = scanner.nextInt();
                employeeDatabase.deleteEmployee3(empId);
                break;
            default:
                break;

        }


    }


}
