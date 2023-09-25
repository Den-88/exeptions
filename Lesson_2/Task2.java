package Lesson_2;
import java.util.Arrays;

/**
 * Обработайте возможные исключительные ситуации. "Битые" значения
 * в исходном массиве считайте нулями. Можно внести в код правки,
 * которые считаете необходимыми
 */
public class Task2 {
    public static void main(String[] args) {
        String[][] ints = new String[][] {
                { "1", "0", "1", "1", "1" },
                { "1", "0", "1", "1", "1" },
                { "1", "0", "1", "1", "1" },
                { "1", "0", "1", "1" },
                { "1", "0", "g", "1" },
                { "1", "0", "1", "1", "1", "1" }
        };
        // printMatrix(ints);
        // repairMatrix(ints);
        // System.out.println("------------");
        // printMatrix(ints);
        System.out.println(sum2d(ints));
    }

    private static int sum2d(String[][] arr) {
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        int val = Integer.parseInt(arr[i][j]);
                        sum += val;
                    } catch (NumberFormatException e) {
                        System.err.println("Данные не валидны!");
                        throw new RuntimeException();
                    }

                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            repairMatrix(arr);
            sum = sum2d(arr);
        } finally {
            System.out.println("000");
        }
        System.out.println("123");

        return sum;
    }

    private static void repairMatrix(String[][] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxLen < arr[i].length) {
                maxLen = arr[i].length;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length < maxLen) {
                String[] temp = new String[maxLen];
                System.arraycopy(arr[i], 0, temp, 0, arr[i].length);
                arr[i] = temp;
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == null) {
                        arr[i][j] = "0";
                    }
                }
            }
        }
    }

    private static void printMatrix(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}