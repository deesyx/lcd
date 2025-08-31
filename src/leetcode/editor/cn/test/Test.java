package leetcode.editor.cn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.toChinese(8520.2f));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num float浮点型 数字金额
     * @return string字符串
     */
    public String toChinese(float num) {
        // write code here
        String[] chineseNums = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] chineseUnits = {"", "", "拾", "佰", "仟", "万", "拾万", "佰万", "仟万", "亿", "拾亿", "佰亿"};
        String numStr = num + "";
        int pointIdx = numStr.indexOf(".");
        StringBuilder xiaoshuSb = new StringBuilder();
        if (pointIdx != -1) {
            String jiaoStr = numStr.substring(pointIdx + 1, pointIdx + 2);
            String fenStr = numStr.substring(pointIdx + 2);
            int jiao = Integer.parseInt(jiaoStr);
            int fen = 0;
            if (!fenStr.isEmpty()) {
                fen = Integer.parseInt(fenStr);
            }
            if (jiao != 0 || fen != 0) {
                if (jiao != 0) {
                    xiaoshuSb.append(chineseNums[jiao]).append("角");
                }
                if (fen != 0) {
                    xiaoshuSb.append(chineseNums[fen]).append("分");
                }
            }
        }

        String zhenStr;
        if (pointIdx != -1) {
            zhenStr = numStr.substring(0, pointIdx);
        } else {
            zhenStr = numStr;
        }

        int idx = 1;
        List<String> ans = new ArrayList<>();
        boolean hasStart = false;
        for (int i = zhenStr.length() - 1; i >= 0; i--) {
            int x = Integer.parseInt(zhenStr.substring(i, i + 1));
            if (x == 0 && !hasStart) {
                idx++;
                continue;
            }
            hasStart = true;
            String chineseNum = chineseNums[x];
            String chineseUnit = chineseUnits[idx];
            ans.add(chineseNum + chineseUnit);
            idx++;
        }

        StringBuilder zhenshuSb = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; i--) {
            zhenshuSb.append(ans.get(i));
        }
        return zhenshuSb + "元" + xiaoshuSb;
    }

}
