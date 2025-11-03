package org.example.employees;

public class FixedSalaryEmployee extends Employee {
    private final double monthlySalary;

    public FixedSalaryEmployee(String fullName, double monthlySalary) {
        super(fullName);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double getAverageMonthlySalary() {
        return monthlySalary;
    }
}


