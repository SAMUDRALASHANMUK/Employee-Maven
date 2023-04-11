package com.marketsimplified;

import java.sql.SQLException;
import java.util.Scanner;

public class  Main2
{
    public static void main(String[] args) throws SQLException
    {
        Scanner scanner = new Scanner(System.in);

        boolean bool = true;

        while (bool)
        {
            AddEmployee.add();
            System.out.println("If you want to continue add press true otherwise press false");
            bool = scanner.nextBoolean();
        }

        System.out.println("If you want to perform update press true otherwise false");
        boolean bool2 = scanner.nextBoolean();
        while (bool2)
        {
            UpdateEmployee.update();
            System.out.println("If you want to continue update operation press true otherwise press false");
            bool2 = scanner.nextBoolean();
        }
        System.out.println("If you want to perform delete press true otherwise false");
        boolean bool3 = scanner.nextBoolean();
        while (bool3)
        {
            DeleteEmployee.delete();
            System.out.println("If you want to continue delete operation  press true otherwise press false");
            bool3 = scanner.nextBoolean();
        }
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        employeeDatabase.permanentJson();
        employeeDatabase.partTimeJson();
        employeeDatabase.contractJson();

    }
}
