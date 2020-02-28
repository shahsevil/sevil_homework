package lesson11;

import java.util.HashMap;

public class task4 {

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

        map.keySet().stream().sorted().forEach(key -> {
                    Integer value = map.get(key);
            map.forEach((mykey,myvalue)->System.out.printf("%c:%d\n",key,value));

                });
    }

}
