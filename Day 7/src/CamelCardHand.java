public class CamelCardHand {
    private Character[] hand;
    private char[] unsortedHand;
    private int bid;
    private int strength;



    public CamelCardHand(Character[] hand, int bid, char[] unsorted) {
        this.hand = hand;
        this.bid = bid;
        this.unsortedHand = unsorted;

        validateHand(hand);
    }



    public int calculateHandWinning(int rank) {
        return bid * rank;
    }

    private void validateHand(Character[] hand) {
        if (handleFive(hand)) {
            return;
        }

        if (handleFour(hand)) {
            return;
        }

        if (handleFullHouse(hand)) {

            return;
        }
        if (handleThree(hand)) {
            return;
        }
        if (handleTwoPair(hand)) {
            return;
        }
        if (handleOnePair(hand)) {
            return;
        }

        this.strength = 1;
    }

    private boolean handleFive(Character[] hand) {
        if(hand[0] == hand[4]) {
            this.strength = 7;
            return true;
        }
        return false;
    }

    private boolean handleFour(Character[] hand) {
        if((hand[0] == hand[3])) {
            this.strength = 6;
            return true;
        }
        if ((hand[1] == hand[4])) {
            this.strength = 6;
            return true;
        }
        return false;
    }

    private boolean handleFullHouse(Character[] hand) {
        if (hand[0] == hand[1] && hand[2] == hand[4] || hand[0] == hand[2] && hand[3] == hand[4]) {
            this.strength = 5;
            return true;
        }
        return false;
    }
    private boolean handleThree(Character[] hand) {
        if ((hand[0] == hand[2]) || (hand[1] == hand[3]) || (hand[2] == hand[4])) {
            this.strength = 4;
            return true;
        }
        return false;
    }

    private boolean handleTwoPair(Character[] hand) {
        if (
                (hand[0] == hand[1] && hand[3] == hand[4])
                || (hand[0] == hand[1] && hand[2] == hand[3])
                || (hand[1] == hand[2] && hand[3] == hand[4])
        ) {
            this.strength = 3;
            return true;
        }
        return false;
    }

    private boolean handleOnePair(Character[] hand) {
        if ((hand[0] == hand[1]) || (hand[1] == hand[2]) || (hand[2] == hand[3]) || (hand[3] == hand[4])) {
            this.strength = 2;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : hand) {
            stringBuilder.append(character);
        }
        return String.format("%s %d", stringBuilder, bid);
    }

    public int getStrength() {
        return strength;
    }

    public int getFirstCardValue() {
        return ValueMapper.cardValues.get(unsortedHand[0]);
    }
    public int getSecondCardValue() {
        return ValueMapper.cardValues.get(unsortedHand[1]);
    }
    public int getThirdCardValue() {
        return ValueMapper.cardValues.get(unsortedHand[2]);
    }
    public int getFourthCardValue() {
        return ValueMapper.cardValues.get(unsortedHand[3]);
    }
    public int getFifthCardValue() {
        return ValueMapper.cardValues.get(unsortedHand[4]);
    }
}
