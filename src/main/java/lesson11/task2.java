package lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class task2{
    public static void main(String[] args) {
        String origin = "hello world";
        System.out.println(origin);
        HashMap<Character, List<Integer>> map = new HashMap<>();

        IntStream.range(0, origin.length()).forEach(i -> {
            char c = origin.charAt(i);
            List<Integer> positions = map.getOrDefault(c, new ArrayList<>());
            positions.add(i);
            map.put(c, positions);
        });

        map.forEach((c, n) ->
                System.out.printf("%c:%s\n", c, n));
    }

}
