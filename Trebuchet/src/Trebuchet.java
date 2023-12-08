import java.io.File;
import java.util.Scanner;


public class Trebuchet {
    public static void main(String[] args) {
        File file = new File("data/input.txt");
        try {
            Scanner scanner = new Scanner(file);
            int sum = 0;
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                sum += calculateNumber(line);
            }
            System.out.println(sum);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static int calculateNumber(String line) {
        char[] chars = line.toCharArray();
        int firstNumber = -1;
        int lastNumber = -1;
        for (char character : chars) {
            if (!Character.isDigit(character)) {
                continue;
            }
            if (firstNumber == -1) {
                firstNumber = Integer.parseInt(String.valueOf(character));
            }
            lastNumber = Integer.parseInt(String.valueOf(character));
        }
        return Integer.parseInt(String.valueOf(firstNumber).concat(String.valueOf(lastNumber)));
    }
}