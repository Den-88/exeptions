// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению 
// приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

package Homework_2;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println("Вы ввели: " + getFloatInput());
    }

    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float input;

        try {
            System.out.print("Введите дробное число: ");
            input = Float.parseFloat(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите дробное число.");
            return getFloatInput();
        }
        return input;
    }
}
