package org.example.employees;

public class HourlySalaryEmployee extends Employee {
    private final double hourlyRate;

    public HourlySalaryEmployee(String fullName, double hourlyRate) {
        super(fullName);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getAverageMonthlySalary() {
        return 20 * 8 * hourlyRate;
    }
}


