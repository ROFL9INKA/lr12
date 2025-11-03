package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final int TEMPERATURE_VALUES_COUNT = 15;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Задание 1: Создание файла с информацией о себе и вывод данных");
            runTask1(scanner);

            System.out.println();
            System.out.println("Задание 2: Ввод 15 значений температуры и расчёт средней");
            runTask2(scanner);

            System.out.println();
            System.out.println("Задание 3: Создание файла с именами, проверка наличия и обработка исключений");
            runTask3();
        }
    }

    private static void runTask1(Scanner scanner) {
        Path aboutMePath = Paths.get("about_me.txt");

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine().trim();
        System.out.print("Введите ваш возраст: ");
        String age = scanner.nextLine().trim();
        System.out.print("Введите ваш город: ");
        String city = scanner.nextLine().trim();

        List<String> lines = new ArrayList<>();
        lines.add("Имя: " + name);
        lines.add("Возраст: " + age);
        lines.add("Город: " + city);

        try {
            Files.write(aboutMePath, lines, StandardCharsets.UTF_8);

            System.out.println("Файл создан: " + aboutMePath.toAbsolutePath());
            BasicFileAttributes attrs = Files.readAttributes(aboutMePath, BasicFileAttributes.class);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            System.out.println("Информация о файле:");
            System.out.println("- Размер (байт): " + attrs.size());
            System.out.println("- Дата создания: " + dtf.format(attrs.creationTime().toInstant().atZone(ZoneId.systemDefault())));
            System.out.println("- Последнее изменение: " + dtf.format(attrs.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault())));
            System.out.println("- Доступен для чтения: " + Files.isReadable(aboutMePath));
            System.out.println("- Доступен для записи: " + Files.isWritable(aboutMePath));

            System.out.println("\nСодержимое файла:");
            Files.lines(aboutMePath, StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом 'about_me.txt': " + e.getMessage());
        }
    }

    private static void runTask2(Scanner scanner) {
        Path tempsPath = Paths.get("temperatures.txt");
        List<String> toWrite = new ArrayList<>();

        System.out.println("Введите " + TEMPERATURE_VALUES_COUNT + " вещественных значений температуры воздуха (через Enter):");
        int entered = 0;
        while (entered < TEMPERATURE_VALUES_COUNT) {
            System.out.print((entered + 1) + ") ");
            String token = scanner.nextLine().trim();
            if (token.isEmpty()) {
                continue;
            }
            try {
                double value = Double.parseDouble(token.replace(',', '.'));
                toWrite.add(Double.toString(value));
                entered++;
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный формат. Повторите ввод числа.");
            }
        }

        try {
            Files.write(tempsPath, toWrite, StandardCharsets.UTF_8);

            double sum = 0.0;
            int count = 0;
            try (BufferedReader reader = Files.newBufferedReader(tempsPath, StandardCharsets.UTF_8)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) {
                        continue;
                    }
                    sum += Double.parseDouble(line);
                    count++;
                }
            }

            if (count > 0) {
                double avg = sum / count;
                System.out.printf(Locale.US, "Средняя температура: %.2f\n", avg);
            } else {
                System.out.println("Файл пустой, невозможно вычислить среднюю температуру.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи/чтении файла 'temperatures.txt': " + e.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println("Ошибка формата данных в файле 'temperatures.txt'.");
        }
    }

    private static void runTask3() {
        Path namesPath = Paths.get("names.txt");

        // Создадим файл с несколькими именами, если его нет
        if (!Files.exists(namesPath)) {
            List<String> defaultNames = List.of("Анна", "Борис", "Виктор", "Галина");
            try {
                Files.write(namesPath, defaultNames, StandardCharsets.UTF_8);
                System.out.println("Создан файл с именами: " + namesPath.toAbsolutePath());
            } catch (IOException e) {
                System.out.println("Не удалось создать файл 'names.txt': " + e.getMessage());
                return;
            }
        }

        // Проверка наличия
        if (Files.exists(namesPath)) {
            System.out.println("Файл существует: " + namesPath.toAbsolutePath());
        } else {
            System.out.println("Файл не найден: " + namesPath.toAbsolutePath());
        }

        // Попытка чтения с обработкой исключений
        try (BufferedReader reader = Files.newBufferedReader(namesPath, StandardCharsets.UTF_8)) {
            System.out.println("Содержимое файла 'names.txt':");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("Файл 'names.txt' не найден: " + fnf.getMessage());
        } catch (IOException ioe) {
            System.out.println("Ошибка чтения файла 'names.txt': " + ioe.getMessage());
        }
    }
}