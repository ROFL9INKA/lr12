package org.example;

public class ContractEmployee extends Employee {
    public ContractEmployee(String fullName, String position, double oklad) throws OkladException {
        super(fullName, position, oklad);
    }

    @Override
    public double calculateSalary() {
        try {
            return getOklad();
        } catch (Exception e) {
            System.out.println("Ошибка расчёта зарплаты: " + e.getMessage());
            return 0.0;
        }
    }
}


