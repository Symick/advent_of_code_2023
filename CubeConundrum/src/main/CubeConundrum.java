package main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CubeConundrum {
    public static void main(String[] args) {
        File file = new File("data/input.txt");
        Map<String, Integer> possible = new HashMap<>() {{
            put("red", 12);
            put("blue", 14);
            put("green", 13);
        }};
        try {
            Scanner scanner = new Scanner(file);
            int sumPartOne = 0;
            int sumPartTwo = 0;
            int gameId = 0;
            while (scanner.hasNext()) {
                //get all information
                String input = scanner.nextLine();
                String game = input.split(":")[1];
                String[] hands = game.split(";");
                gameId++;

                boolean invalidGame = false;
                Map<String, Integer> minValues = new HashMap<>() {{
                    put("red", 0);
                    put("green", 0);
                    put("blue", 0);
                }};
                for (String hand : hands) {
                    String[] marbles = hand.split(",");
                    for (String marble : marbles) {
                        String[] marbleInfo = marble.trim().split(" ");
                        int amountOfMarbles = Integer.parseInt(marbleInfo[0]);
                        String marbleColor = marbleInfo[1];
                        if (possible.get(marbleColor) < amountOfMarbles) {
                            invalidGame = true;
                        }
                        if (minValues.get(marbleColor) < amountOfMarbles) {
                            minValues.put(marbleColor, amountOfMarbles);
                        }
                    }
                }
                sumPartTwo += minValues.values().stream().reduce((integer, integer2) -> integer * integer2).orElse(0);
                if (!invalidGame) {
                    sumPartOne += gameId;
                }
            }
            System.out.println(sumPartOne);
            System.out.println(sumPartTwo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

