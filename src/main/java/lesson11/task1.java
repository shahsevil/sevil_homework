package lesson11;

import java.util.HashMap;

public class task1 {
    public static void main(String[] args) {
        String origin = "hello world";
        System.out.println(origin);
        HashMap<Character, Integer> map = new HashMap<>();
        origin.chars().mapToObj(n -> (char)n)
                .forEach(c -> {
                    if (!map.containsKey(c)) {
                        map.put(c, 1);
                    } else {
                        int count = map.get(c);
                        map.put(c, count + 1);
                    }
                });
        map.forEach((c, n) -> System.out.printf("%c:%d\n", c, n));
    }
}
