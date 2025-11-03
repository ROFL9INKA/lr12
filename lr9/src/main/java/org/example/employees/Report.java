package org.example.employees;

import java.util.List;

public class Report {
    public static void generateReport(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.printf("%-15s %10.2f%n", e.getFullName(), e.getAverageMonthlySalary());
        }
    }
}


