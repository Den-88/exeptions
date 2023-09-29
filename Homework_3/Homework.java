package Homework_3;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию, имя, отчество, дату рождения, номер телефона и пол через пробел: ");
        String input = scanner.nextLine();
        Human human = new Human(input.split(" "));
        Writer.writeFile(human);
    }
}
