package org.example;

public abstract class Employee {
    private String fullName;
    private String position;
    private double oklad;

    public Employee(String fullName, String position, double oklad) throws OkladException {
        if (oklad < 0) {
            throw new OkladException(oklad);
        }
        this.fullName = fullName;
        this.position = position;
        this.oklad = oklad;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getOklad() {
        return oklad;
    }

    public void setOklad(double oklad) throws OkladException {
        if (oklad < 0) {
            throw new OkladException(oklad);
        }
        this.oklad = oklad;
    }

    public abstract double calculateSalary();
}


