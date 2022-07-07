

//在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词
//根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。 
//
// 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继
//承词有许多可以形成它的词根，则用最短的词根替换它。 
//
// 你需要输出替换之后的句子。 
//
// 
//
// 示例 1： 
//
// 
//输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by 
//the battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 2： 
//
// 
//输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写字母组成。 
// 1 <= sentence.length <= 10^6 
// sentence 仅由小写字母和空格组成。 
// sentence 中单词的总量在范围 [1, 1000] 内。 
// sentence 中每个单词的长度在范围 [1, 1000] 内。 
// sentence 中单词之间由一个空格隔开。 
// sentence 没有前导或尾随空格。 
// 
//
// 
// Related Topics 字典树 数组 哈希表 字符串 👍 203 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReplaceWords_Six48 {
    public static void main(String[] args) {
        Solution solution = new ReplaceWords_Six48().new Solution();
        solution.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private class DictTree {
            char val;
            int index = -1;
            DictTree[] children = new DictTree[26];

            public DictTree(char val) {
                this.val = val;
            }

            public void add(String word, int index) {
                DictTree cur = this;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.children[c - 'a'] == null) {
                        cur.children[c - 'a'] = new DictTree(c);
                    }
                    cur = cur.children[c - 'a'];
                }
                cur.index = index;
            }

            public int find(String s) {
                DictTree cur = this;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (cur.index != -1) {
                        return cur.index;
                    }
                    if (cur.children[c - 'a'] == null) {
                        return -1;
                    }
                    cur = cur.children[c - 'a'];
                }
                return -1;
            }
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            DictTree root = new DictTree('0');
            for (int i = 0; i < dictionary.size(); i++) {
                root.add(dictionary.get(i), i);
            }

            String[] sen = sentence.split(" ");
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < sen.length; i++) {
                int index = root.find(sen[i]);
                if (index != -1) {
                    ans.append(dictionary.get(index));
                } else {
                    ans.append(sen[i]);
                }
                if (i < sen.length - 1) {
                    ans.append(" ");
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}