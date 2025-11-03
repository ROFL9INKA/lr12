package org.example;

import org.example.buildings.Building;
import org.example.buildings.House;
import org.example.buildings.Office;
import org.example.employees.Employee;
import org.example.employees.FixedSalaryEmployee;
import org.example.employees.HourlySalaryEmployee;
import org.example.employees.Report;
import org.example.students.Student;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1)
        Map<String, Building> buildings = new LinkedHashMap<>();
        buildings.put("ЖК Солнечный", new House("ЖК Солнечный"));
        buildings.put("БЦ Орбита", new Office("БЦ Орбита"));
        buildings.put("Коттедж Green", new House("Коттедж Green"));

        System.out.println("Ключи зданий:");
        for (String key : buildings.keySet()) {
            System.out.println(key);
        }

        // 2)
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иван Иванов", "A1", 1, Arrays.asList(5, 4, 3)));
        students.add(new Student("Петр Петров", "A1", 1, Arrays.asList(2, 2, 3)));
        students.add(new Student("Сидор Сидоров", "B2", 2, Arrays.asList(3, 3, 3)));

        Student.processStudents(students);

        System.out.println("Студенты на курсе 2:");
        Student.printStudents(students, 2);
        System.out.println("Студенты на курсе 3:");
        Student.printStudents(students, 3);

        // 3)
        List<Employee> employees = new ArrayList<>();
        employees.add(new FixedSalaryEmployee("Анна Каренина", 3400));
        employees.add(new HourlySalaryEmployee("Борис Годунов", 15));
        employees.add(new FixedSalaryEmployee("Виктор Цой", 2200));
        employees.add(new HourlySalaryEmployee("Геннадий Петров", 10));
        employees.add(new FixedSalaryEmployee("Дмитрий Менделеев", 2300));
        employees.add(new HourlySalaryEmployee("Елена Летучая", 20));
        employees.add(new FixedSalaryEmployee("Жанна Д'Арк", 3100));

        Collections.sort(employees);

        System.out.println("Отчет по зарплатам:");
        Report.generateReport(employees);

        // a) Вывести id, имя, среднемесячную ЗП
        System.out.println("Полный список (id | имя | ЗП):");
        for (Employee e : employees) {
            System.out.printf("%d | %s | %.2f%n", e.getId(), e.getFullName(), e.getAverageMonthlySalary());
        }

        // b) Первые 5 имен
        System.out.println("Первые 5 имен:");
        int limit = Math.min(5, employees.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(employees.get(i).getFullName());
        }

        // c) Последние 3 идентификатора
        System.out.println("Последние 3 идентификатора:");
        int start = Math.max(0, employees.size() - 3);
        for (int i = start; i < employees.size(); i++) {
            System.out.println(employees.get(i).getId());
        }
    }
}