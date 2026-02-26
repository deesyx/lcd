//给定一个字符串数组 words 和一个字符串 chars。 
//
// 如果字符串可以由 chars 中的字符组成（每个字符在 每个 words 中只能使用一次），则认为它是好的。 
//
// 返回 words 中所有好的字符串的长度之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["cat","bt","hat","tree"], chars = "atach"
//输出：6
//解释： 
//可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
// 
//
// 示例 2： 
//
// 
//输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//输出：10
//解释：
//可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length, chars.length <= 100 
// words[i] 和 chars 中都仅包含小写英文字母 
// 
//
// Related Topics 数组 哈希表 字符串 计数 👍 198 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters_1160 {
	public static void main(String[] args) {
		Solution solution = new FindWordsThatCanBeFormedByCharacters_1160().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int countCharacters(String[] words, String chars) {
			int[] m = new int[26];
			for (char c : chars.toCharArray()) {
				m[c - 'a']++;
			}

			int ans = 0;
			for (String word : words) {
				int[] tmp = Arrays.copyOf(m, 26);
				boolean flag = true;
				for (char c : word.toCharArray()) {
					if (tmp[c - 'a'] == 0) {
						flag = false;
						break;
					}
					tmp[c - 'a']--;
				}
				if (flag) {
					ans += word.length();
				}
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}