import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Trebuchet {
    public static void main(String[] args) {
        File file = new File("data/input.txt");
        try {
            Scanner scanner = new Scanner(file);
            int sumPartOne = 0;
            int sumPartTwo = 0;
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                sumPartOne += calculateNumber(line, false);
                sumPartTwo += calculateNumber(line, true);
            }
            System.out.println(sumPartOne);
            System.out.println(sumPartTwo);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static int calculateNumber(String line, boolean isPartTwo) {
        char[] chars = line.toCharArray();
        String[] numbersAsText = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int firstNumber = -1;
        int lastNumber = -1;
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if (Character.isDigit(character)) {
                if (firstNumber == -1) {
                    firstNumber = Integer.parseInt(String.valueOf(character));
                }
                lastNumber = Integer.parseInt(String.valueOf(character));
            }
            if (isPartTwo) {
                for (int j = 0; j < numbersAsText.length; j++) {
                    String numAsText = numbersAsText[j];
                    if (line.substring(i).startsWith(numAsText)) {
                        if (firstNumber == -1) {
                            firstNumber = j + 1; //change to 1-indexing
                        }
                        lastNumber = j + 1;
                    }
                }
            }
        }
        return Integer.parseInt(String.valueOf(firstNumber).concat(String.valueOf(lastNumber)));
    }
}