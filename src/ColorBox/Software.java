package ColorBox;

import java.util.Scanner;

public class Software {
    Scanner scanner = new Scanner(System.in);

    public Software() {
    }

    public void startGame() {
        String input = scanner.nextLine();
        Box box = new Box();

        while (!input.equals("End")) {
            String[] currentBall = input.split(":\\s+");
            String color = currentBall[0];
            int count = Integer.parseInt(currentBall[1]);
            box.addColor(color, count);
            input = scanner.nextLine();
        }
        box.findSmallest();
    }
}