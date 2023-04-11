package com.marketsimplified;

public class PermanentEmployee extends Employee
{
    private final int bonus;
    public PermanentEmployee(int id, String name, int age, int salary, int bonus)
    {
        super(id, name, age, salary);
        this.bonus = bonus;
    }
    public int getBonus()
    {
        return bonus;
    }



}