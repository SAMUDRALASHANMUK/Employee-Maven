package com.marketsimplified;

public class PartTimeEmployee extends Employee
{
    final private int hoursWorked;
    public PartTimeEmployee(int id, String name, int age, int salary, int hoursWorked)
    {
        super(id, name, age, salary);
        this.hoursWorked = hoursWorked;
    }
    public int getHoursWorked()
    {
        return hoursWorked;
    }



}