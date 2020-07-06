package leetcode._151_199._163;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges
 *
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class LC_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long alower = (long)lower;
        long aupper = (long)upper;

        for (int num : nums) {
            if (alower == num) {
                alower++;
            } else if (alower < num) {
                if (alower + 1 == num) {
                    res.add(String.valueOf(alower));
                } else {
                    res.add(alower + "->" + (num - 1));
                }
                alower = (long)num + 1;
            }
        }

        if (alower == upper) {
            res.add(String.valueOf(upper));
        } else if (alower < upper){
            res.add(alower + "->" + upper);
        }

        return res;
    }
}
