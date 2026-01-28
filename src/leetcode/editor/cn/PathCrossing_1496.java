//给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。 
//
// 你从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。 
//
// 如果路径在任何位置上与自身相交，也就是走到之前已经走过的位置，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：path = "NES"
//输出：false 
//解释：该路径没有在任何位置相交。 
//
// 示例 2： 
//
// 
//
// 
//输入：path = "NESWW"
//输出：true
//解释：该路径经过原点两次。 
//
// 
//
// 提示： 
//
// 
// 1 <= path.length <= 10⁴ 
// path[i] 为 'N'、'S'、'E' 或 'W' 
// 
//
// Related Topics 哈希表 字符串 👍 65 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class PathCrossing_1496 {
	public static void main(String[] args) {
		Solution solution = new PathCrossing_1496().new Solution();
		solution.isPathCrossing("SS");
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		private class Point {
			int x;
			int y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			public Point next(char c) {
				switch (c) {
					case 'N':
						return new Point(x, y + 1);
					case 'S':
						return new Point(x, y - 1);
					case 'E':
						return new Point(x + 1, y);
					case 'W':
						return new Point(x - 1, y);
					default:
						return null;
				}
			}

			@Override
			public boolean equals(Object o) {
				if (o == null || getClass() != o.getClass()) return false;
				Point point = (Point) o;
				return x == point.x && y == point.y;
			}

			@Override
			public int hashCode() {
				return Objects.hash(x, y);
			}
		}

		public boolean isPathCrossing(String path) {
			Point p = new Point(0, 0);
			Set<Point> m = new HashSet<>();
			m.add(p);

			for (char c : path.toCharArray()) {
				Point next = p.next(c);
				if (m.contains(next)) {
					return true;
				}
				m.add(next);
				p = next;
			}
			return false;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}