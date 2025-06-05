package leetcode.editor.cn.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Xbwl {

    public static void main(String[] args) {
        Xbwl xbwl = new Xbwl();
        System.out.println(xbwl.test("We Attack at Dawn"));
    }

    private String test(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            char lowerCase = toLowerCase(c);
            if (lowerCase == ' ') {
                continue;
            }
            m.put(lowerCase, m.getOrDefault(lowerCase, 0) + 1);
        }

        List<Character> chars = m.entrySet().stream().sorted((o1, o2) -> {
            int compare = o2.getValue().compareTo(o1.getValue());
            if (compare != 0) {
                return compare;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        }).map(Map.Entry::getKey).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    private char toLowerCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        }
        if (c >= 'A' && c <= 'Z') {
            return (char) ('a' + (c - 'A'));
        }
        return ' ';
    }
}
