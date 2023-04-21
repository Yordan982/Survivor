package ElfWords;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElfWords {
    public static void main(String[] args) {

        // TODO: OOP working code of the same type

        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine().replace(" ", "").toLowerCase();
        String secondWord = scanner.nextLine().replace(" ", "").toLowerCase();

        char[] firstArray = firstWord.toCharArray();
        char[] secondArray = secondWord.toCharArray();

        List<Character> uniqueChars = new ArrayList<>();

        for (char currentFirst : firstArray) {
            for (char currentSecond : secondArray) {
                if (currentFirst == currentSecond) {
                    if (!uniqueChars.contains(currentFirst)) {
                        uniqueChars.add(currentFirst);
                    }
                }
            }
        }

        int totalCharsCount = firstArray.length + secondArray.length;
        int remainingCount = uniqueChars.size() * 2;
        int removedChars = totalCharsCount - remainingCount;

        System.out.println(removedChars);
    }
}