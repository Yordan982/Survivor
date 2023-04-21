package ColorBox;

import java.util.Collection;
import java.util.HashMap;

public class Box {
    private HashMap<String, Integer> colorBox;

    public Box() {
        colorBox = new HashMap<>();
    }

    public void addColor(String color, int count) {
        try {
            if (count < 0) {
                throw new IllegalArgumentException("The count must be a positive number.");
            } else if (colorBox.containsKey(color)) {
                count += colorBox.get(color);
            }
            colorBox.put(color, count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Collection<Integer> getValues() {
        return colorBox.values();
    }

    public void findSmallest() {
        int smallestValue = Integer.MAX_VALUE;
        int totalBalls = 0;

        for (int currentValue : getValues()) {
            if (currentValue < smallestValue) {
                smallestValue = currentValue;
            }
            totalBalls += currentValue;
        }

        int removedBalls = totalBalls - smallestValue;
        System.out.println(removedBalls);
    }
}