package Homework_3;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void writeFile(Human human) {
        try (FileWriter fileWriter = new FileWriter(human.getSurname() + ".txt", true)) {
            fileWriter.write(human.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи файла.");
            throw new RuntimeException(e.getMessage());
        }
    }
}
