package RabbitCarrots;

import java.util.Scanner;

import static RabbitCarrots.ErrorMessages.CHARS_NUMBER_NOT_MATCHING_INPUT;
import static RabbitCarrots.ErrorMessages.INPUT_IS_NOT_A_NUMBER;

public class RabbitCarrots {
    public final static char CARROT = 'C';
    public final static char EMPTY_FIELD = '-';

    public static void main(String[] args) {

        int lineChars = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            int gardenSize = Integer.parseInt(scanner.nextLine());
            lineChars = gardenSize;

            char[][] garden = new char[gardenSize][gardenSize];

            for (int row = 0; row < gardenSize; row++) {
                String[] lineInput = scanner.nextLine().split(",\\s*");
                for (int col = 0; col < gardenSize; col++) {
                    char currentChar = lineInput[col].charAt(0);
                    if (lineInput[col].charAt(0) != CARROT && lineInput[col].charAt(0) != EMPTY_FIELD) {
                        currentChar = EMPTY_FIELD;
                    }
                    garden[row][col] = currentChar;
                }
            }
            System.out.println(countJumps(garden));
        } catch (IndexOutOfBoundsException exception) {
            System.out.printf((CHARS_NUMBER_NOT_MATCHING_INPUT) + "%n", lineChars);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(INPUT_IS_NOT_A_NUMBER);
        }
    }

    public static int countJumps(char[][] array) {
        int jumps = 0;
        boolean[][] visited = new boolean[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if ((array[row][col]) == CARROT && !visited[row][col]) {
                    checkIfVisited(array, visited, row, col);
                    jumps++;
                }
            }
        }
        return jumps;
    }

    public static void checkIfVisited(char[][] array, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= array.length || col < 0 || col >= array[row].length || array[row][col] == EMPTY_FIELD || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        checkIfVisited(array, visited, row - 1, col);
        checkIfVisited(array, visited, row + 1, col);
        checkIfVisited(array, visited, row, col - 1);
        checkIfVisited(array, visited, row, col + 1);
    }
}
