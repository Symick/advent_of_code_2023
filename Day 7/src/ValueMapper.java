import java.util.HashMap;
import java.util.Map;

public class ValueMapper {
    public static Map<Character, Integer> cardValues = new HashMap<>() {{
        put('A', 14);
        put('K', 13);
        put('Q', 12);
        put('J', 11);
        put('T', 10);
        put('9', 9);
        put('8', 8);
        put('7', 7);
        put('6', 6);
        put('5', 5);
        put('4', 4);
        put('3', 3);
        put('2', 2);
    }};
}
