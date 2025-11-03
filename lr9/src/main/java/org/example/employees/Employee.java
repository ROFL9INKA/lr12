package org.example.employees;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Employee implements Comparable<Employee> {
    private static final AtomicLong ID_SEQUENCE = new AtomicLong(1);

    private final long id;
    private final String fullName;

    protected Employee(String fullName) {
        this.id = ID_SEQUENCE.getAndIncrement();
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public abstract double getAverageMonthlySalary();

    @Override
    public int compareTo(Employee other) {
        int cmp = Double.compare(other.getAverageMonthlySalary(), this.getAverageMonthlySalary());
        if (cmp != 0) {
            return cmp;
        }
        return this.fullName.compareToIgnoreCase(other.fullName);
    }
}


