package Lesson_2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Запишите в файл следующие строки:
 *
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Полина=?
 * Константин=?
 * Иван=4
 *
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный
 * массив (либо HashMap,
 * если студенты с ним знакомы). В отдельном методе нужно будет пройти по
 * структуре данных,
 * если сохранено значение ?, заменить его на соответствующее число.Если на
 * каком-то месте
 * встречается символ, отличный от числа или ?, бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?.
 */
public class Task3 {
    private static final List<String> strings = List.of("Анна=4", "Елена=5", "Марина=6", "Полина=?", "Владимир=?",
            "Константин=?", "Иван=4");
    // для проверки, заменить какое-то из значений на null

    public static void main(String[] args) {
        writeToFile("task3.txt", strings);
        System.out.println(readFile("task3.txt"));
        rewrite("task3.txt");
    }

    private static void writeToFile(String path, List<String> strings) {
        // File file = new File(path);
        FileWriter file = null;
        try {
            file = new FileWriter(path);
            for (String string : strings) {
                file.write(string);
                file.write("\n");
            }
            file.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private static Map<String, Integer> readFile(String path) {
        BufferedReader file = null;
        Map<String, Integer> result = new HashMap<>();
        try {
            file = new BufferedReader(new FileReader(new File(path)));
            String line;
            while ((line = file.readLine()) != null) {
                String[] arr = line.split("=");
                String name = arr[0];
                String temp = arr[1];
                int number;
                if (temp.equals("?")) {
                    number = name.length();
                } else {
                    number = Integer.parseInt(temp);
                }
                result.put(name, number);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Недопустимое значение");
        }
        return result;
    }

    private static void rewrite(String path) {
        Map<String, Integer> result = readFile(path);
        List<String> newArr = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            newArr.add(entry.toString());
        }
        writeToFile(path, newArr);
    }
} 