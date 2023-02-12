//你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。 
//
// 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。 
//
// 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。 
//
// 
// 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//输出：["/a","/c/d","/c/f"]
//解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
// 
//
// 示例 2： 
//
// 
//输入：folder = ["/a","/a/b/c","/a/b/d"]
//输出：["/a"]
//解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
// 
//
// 示例 3： 
//
// 
//输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
//输出: ["/a/b/c","/a/b/ca","/a/b/d"] 
//
// 
//
// 提示： 
//
// 
// 1 <= folder.length <= 4 * 10⁴ 
// 2 <= folder[i].length <= 100 
// folder[i] 只包含小写字母和 '/' 
// folder[i] 总是以字符 '/' 起始 
// 每个文件夹名都是 唯一 的 
// 
// Related Topics 字典树 数组 字符串 👍 101 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFoldersFromTheFilesystem_One233 {
    public static void main(String[] args) {
        Solution solution = new RemoveSubFoldersFromTheFilesystem_One233().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class TrieNode {
            Map<String, TrieNode> children = new HashMap<>();
            int fid = -1;
        }

        private void add(TrieNode root, String[] words, int fid) {
            TrieNode node = root;
            for (String word : words) {
                if (!node.children.containsKey(word)) {
                    node.children.put(word, new TrieNode());
                }
                node = node.children.get(word);
            }
            node.fid = fid;
        }

        public List<String> removeSubfolders(String[] folder) {
            TrieNode root = new TrieNode();
            for (int i = 0; i < folder.length; i++) {
                add(root, folder[i].split("/"), i);
            }
            List<Integer> ans = new ArrayList<>();
            dfs(root, ans);
            List<String> ansans = new ArrayList<>();
            for (int i : ans) {
                ansans.add(folder[i]);
            }

            return ansans;
        }

        private void dfs(TrieNode node, List<Integer> ans) {
            if (node == null) {
                return;
            }
            if (node.fid != -1) {
                ans.add(node.fid);
                return;
            }
            for (TrieNode child : node.children.values()) {
                dfs(child, ans);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}