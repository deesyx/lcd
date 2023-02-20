package leetcode.editor.cn;

import java.util.Scanner;

public class Huawei2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dest = parseIP(in.nextLine());

        in.nextLine();

        int maxM = -1;
        String ans = null;
        while (in.hasNextLine()) {
            String cur = in.nextLine();
            String[] s = cur.split("/");
            int ip = parseIP(s[0]);
            int mask = Integer.parseInt(s[1]);

            if (match(dest, ip, mask)) {
                if (mask > maxM) {
                    ans = cur;
                    maxM = mask;
                }
            }
        }

        if (maxM == -1) {
            System.out.println("empty");
        } else {
            System.out.println(ans);
        }

    }

    private static int parseIP(String ip) {
        String[] words = ip.split("\\.");
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            int cur = Integer.parseInt(words[i]) << (8 * (3 - i));
            ans |= cur;
        }
        return ans;
    }

    private static boolean match(int ip1, int ip2, int m) {
        if (m == 0 && ip2 == 0) {
            return true;
        }
        int ans = ip1 ^ ip2;
        for (int i = 31; i >= 0 && m > 0; i--) {
            int cursor = 1 << i;
            if ((cursor & ans) != 0) {
                return false;
            }
            m--;
        }
        return true;
    }
}
