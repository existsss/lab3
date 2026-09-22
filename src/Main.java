import java.io.*;
import java.util.*;

class Main {
    private static final String FILE_PATH = "C:\\Users\\Саша\\IdeaProjects\\Poiskdvuh\\1111.txt";

    public static void main(String[] args) {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            ArrayList<Integer> numbers = new ArrayList<>();

            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
            scanner.close();

            int min37 = Integer.MAX_VALUE;

            int max73 = Integer.MIN_VALUE;

            for (int number : numbers) {
                if (number % 37 == 0 && number < min37) {
                    min37 = number;
                }

                if (number % 73 == 0 && number > max73) {
                    max73 = number;
                }
            }

            int left = Math.min(min37, max73);
            int right = Math.max(min37, max73);

            int count = 0;
            int minSum = Integer.MAX_VALUE;

            for (int i = 0; i < numbers.size() - 1; i++) {
                int a = numbers.get(i);
                int b = numbers.get(i + 1);

                boolean firstInside = a > left && a < right;
                boolean secondInside = b > left && b < right;

                if (firstInside != secondInside) {
                    count++;

                    int sum = a + b;

                    if (sum < minSum) {
                        minSum = sum;
                    }
                }
            }

            System.out.println("Минимальное кратное 37: " + min37);
            System.out.println("Максимальное кратное 73: " + max73);
            System.out.println("Количество пар: " + count);
            System.out.println("Минимальная сумма: " + minSum);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}