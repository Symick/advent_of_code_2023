import java.util.Comparator;

public class CardComparator implements Comparator<Character> {


    @Override
    public int compare(Character o1, Character o2) {
        int value1 = ValueMapper.cardValues.get(o1);
        int value2 = ValueMapper.cardValues.get(o2);

        return Integer.compare(value1, value2);
    }
}
