package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class huawei {

    static class Node {
        boolean match = false;
        boolean matchAll = false;
        Node[] children = new Node[10];
    }

    static void add(Node root, String number) {
        Node node = root;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '*') {
                node.matchAll = true;
                return;
            }
            int idx = number.charAt(i) - '0';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        node.match = true;
    }

    static boolean find(Node root, String number) {
        Node node = root;
        for (int i = 0; i < number.length(); i++) {
            if (node.matchAll) {
                return true;
            }
            int idx = number.charAt(i) - '0';

            if (node.children[idx] == null) {
                return false;
            }

            node = node.children[idx];
        }

        return node.match;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();

        Node root = new Node();
        Map<String, int[]> m = new HashMap<>();
        int i = 0;
        while (in.hasNextLine()) {
            String[] words = in.nextLine().split(" ");
            String op = words[0];
            String number = words[1];
            if (op.equals("C")) {
                if (!m.containsKey(number)) {
                    int[] value = new int[3];
                    value[0] = i;
                    m.put(number, value);
                }
                int[] value = m.get(number);
                boolean connect = find(root, number);
                if (connect) {
                    value[1]++;
                } else {
                    value[2]++;
                }
            } else {
                if (number.charAt(number.length() - 1) != '*' && !m.containsKey(number)) {

                    int[] value = new int[3];
                    value[0] = i;
                    m.put(number, value);
                }
                add(root, number);
            }
            i++;
        }

        List<Map.Entry<String, int[]>> ans = m.entrySet().stream()
                .sorted((Comparator.comparingInt(o -> o.getValue()[0]))).collect(Collectors.toList());

        for (Map.Entry<String, int[]> a : ans) {
            System.out.println(a.getKey() + " " + a.getValue()[1] + " " + a.getValue()[2]);
        }
    }
}
