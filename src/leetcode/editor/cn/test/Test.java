package leetcode.editor.cn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while(in.hasNextLine()){
            lines.add(in.nextLine());
        }

        for (String line : lines) {
            String[] words = line.split(" ");
            int a = Integer.parseInt(words[0]);
            int b = Integer.parseInt(words[1]);
            System.out.println(a + b);
        }
    }

}
