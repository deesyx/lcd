//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案
//。
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
//
// Related Topics 数组 哈希表 字符串 👍 398 👎 0


package leetcode.editor.cn;

import java.util.*;

public class FindCommonCharacters_1002 {
	public static void main(String[] args) {
		Solution solution = new FindCommonCharacters_1002().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<String> commonChars(String[] words) {
			int[] m = new int[26];
			for (char c : words[0].toCharArray()) {
				m[c - 'a']++;
			}
			for (int i = 1; i < words.length; i++) {
				int[] n = new int[26];
				for (char c : words[i].toCharArray()) {
					n[c - 'a']++;
				}
				for (int j = 0; j < 26; j++) {
					m[j] = Math.min(m[j], n[j]);
				}
			}
			List<String> ans = new ArrayList<>();
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < m[i]; j++) {
					ans.add(String.valueOf((char) (i + 'a')));
				}
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}