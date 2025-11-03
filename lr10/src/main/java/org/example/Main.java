package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Демонстрация структуры предприятия и обработки исключений\n");

        Company company = new Company("ООО Ромашка");
        Department dept = new Department("ИТ", 2);
        System.out.println("Фирма: " + company.getName());
        System.out.println("Отдел: " + dept.getName() + ", сотрудников: " + dept.getEmployeeCount());

        // a) Проверка расчёта зарплаты и обработки исключений в методе calculateSalary
        try {
            StaffEmployee s1 = new StaffEmployee("Иванов И.И.", "Инженер", 50000, -3000);
            double salary1 = s1.calculateSalary(); // внутри будет поймано PremiyaException
            System.out.println("Зарплата (штатный): " + salary1);

            ContractEmployee c1 = new ContractEmployee("Петров П.П.", "Подрядчик", 70000);
            double salary2 = c1.calculateSalary();
            System.out.println("Зарплата (контракт): " + salary2);
        } catch (OkladException e) {
            // сюда попадём, если оклад отрицательный при создании сотрудника
            System.out.println("Ошибка создания сотрудника: " + e.getMessage());
        }

        // б) ОкладException: демонстрация обработки при создании сотрудника
        try {
            try {
                Employee bad = new StaffEmployee("Сидоров С.С.", "Менеджер", -1000, 1000);
                System.out.println("Создан сотрудник: " + bad.getFullName());
            } catch (OkladException e) {
                System.out.println("Невозможно создать сотрудника – указан отрицательный оклад: " + e.getInvalidOklad());
                throw e; // повторно создаём (пробрасываем) Exception
            }
        } catch (OkladException e) {
            System.out.println("Во внешнем обработчике перехвачен OkladException\n");
        }

        System.out.println("Готово.");
    }
}