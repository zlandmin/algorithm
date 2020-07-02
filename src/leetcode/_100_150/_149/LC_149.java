package leetcode._100_150._149;

import java.util.HashMap;
import java.util.Map;

/*
149. Max Points on a Line
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
 */
public class LC_149 {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int verticle = 0;
            int same = 0;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    same++;
                    continue;
                }
                if (dx == 0) {
                    verticle++;
                    continue;
                }
                int a = dy / getGCD(dy, dx);
                int b = dx / getGCD(dy, dx);
                String key = String.valueOf(a) + "-" + String.valueOf(b);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            max = Math.max(max, same + 1);
            max = Math.max(max, verticle + same + 1);
            for (int value : map.values()) {
                max = Math.max(max, value + same + 1);
            }
        }
        return max;
    }

    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}
