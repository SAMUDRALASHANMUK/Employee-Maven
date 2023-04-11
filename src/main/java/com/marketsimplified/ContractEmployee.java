package com.marketsimplified;

public class ContractEmployee extends Employee
{
    final private int contractPeriod;
    public ContractEmployee(int id, String name, int age, int salary, int contractPeriod)
    {
        super(id, name, age, salary);
        this.contractPeriod = contractPeriod;
    }
    public int getContractPeriod()
    {
        return contractPeriod;
    }


}