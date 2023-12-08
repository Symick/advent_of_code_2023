import java.io.File;
import java.util.*;

public class CamelCardGame {
    public static void main(String[] args) {
        long start = System.nanoTime();
        List<CamelCardHand> allHands = loadInput();
        allHands.sort(Comparator.comparing(CamelCardHand::getStrength)
                .thenComparing(CamelCardHand::getFirstCardValue)
                .thenComparing(CamelCardHand::getSecondCardValue)
                .thenComparing(CamelCardHand::getThirdCardValue)
                .thenComparing(CamelCardHand::getFourthCardValue)
                .thenComparing(CamelCardHand::getFifthCardValue));

        int result = 0;

        for (int i = 0; i < allHands.size(); i++) {
            result += allHands.get(i).calculateHandWinning(i+1);
        }
        System.out.println((System.nanoTime() - start) *1e-6 + "ms");
        System.out.println(result);
    }


    public static List<CamelCardHand> loadInput() {
        List<CamelCardHand> hands = new ArrayList<>();
        File file = new File("data/input.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                char[] hand = scanner.next().toCharArray();
                Character[] handWrapper = new Character[hand.length];

                for (int i = 0; i < hand.length; i++) {
                    handWrapper[i] = hand[i];
                }
                Arrays.sort(handWrapper, new CardComparator());
                int bid = scanner.nextInt();
                hands.add(new CamelCardHand(handWrapper, bid, hand));
            }
            return hands;
        } catch (Exception ex) {
            ex.printStackTrace();
            return hands;
        }
    }
}