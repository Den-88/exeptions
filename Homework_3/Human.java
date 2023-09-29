package Homework_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

enum Sex {
    m, f
}

public class Human {
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate date;
    private int phone;
    private Sex sex;

    public Human(String[] parseInput) {
        if (parseInput.length != 6) {
            System.err.println("Неправильное количество элементов во входных данных");
            if (parseInput.length < 6) {
                throw new InvalidInputNumberElementsException(
                        "Invalid number of elements in the input data. Fewer than required.");
            }
            throw new InvalidInputNumberElementsException(
                    "Invalid number of elements in the input data. More than required.");
        }
        try {
            this.surname = parseInput[0];
            this.name = parseInput[1];
            this.patronymic = parseInput[2];
            this.date = parseDate(parseInput[3]);
            this.phone = parsePhone(parseInput[4]);
            this.sex = parseSex(parseInput[5]);
        } catch (DateTimeParseException e) {
            System.err.println("Неправильный формат даты.");
            throw e;
        } catch (InvalidInputNumberPhoneException e) {
            System.err.println("Неверное количество символов в номере телефона.");
            throw new NumberFormatException(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат номера телефона.");
            throw e;
        } catch (InvalidSexException e) {
            System.err.println("Неверно указан пол.");
            throw new RuntimeException(e.getMessage());
        }

    }

    private LocalDate parseDate(String dateString) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }

    private int parsePhone(String phoneString) throws InvalidInputNumberPhoneException, NumberFormatException {
        if (phoneString.length() != 7) {
            throw new InvalidInputNumberPhoneException();
        }
        int phone = Integer.parseInt(phoneString);
        return phone;
    }

    private Sex parseSex(String sexString) throws InvalidSexException {
        if (sexString.equals("m")) {
            return Sex.m;
        } else if (sexString.equals("f")) {
            return Sex.f;
        } else {
            throw new InvalidSexException();
        }
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("<%s><%s><%s><%s><%s><%s>", this.surname, this.name, this.patronymic,
                this.date.format(formatter),
                this.phone, this.sex);
    }
}
