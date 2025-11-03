package org.example;

public class StaffEmployee extends Employee {
    private double premiya;

    public StaffEmployee(String fullName, String position, double oklad, double premiya) throws OkladException {
        super(fullName, position, oklad);
        this.premiya = premiya;
    }

    public double getPremiya() {
        return premiya;
    }

    public void setPremiya(double premiya) {
        this.premiya = premiya;
    }

    @Override
    public double calculateSalary() {
        try {
            if (premiya < 0) {
                throw new PremiyaException(premiya);
            }
            return getOklad() + premiya;
        } catch (PremiyaException e) {
            System.out.println("Ошибка расчёта зарплаты (премия): " + e.getMessage());
            return 0.0;
        } catch (Exception e) {
            System.out.println("Ошибка расчёта зарплаты: " + e.getMessage());
            return 0.0;
        }
    }
}


