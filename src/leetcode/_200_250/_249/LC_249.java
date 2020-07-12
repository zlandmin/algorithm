package leetcode._200_250._249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Shifted Strings
 */
public class LC_249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String base = getBase(str);
            map.putIfAbsent(base, new ArrayList<>());
            map.get(base).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    private String getBase(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int diff = arr[0] - 'a';
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (arr[i] - diff);
            if (arr[i] < 'a') {
                arr[i] += 26;
            }
        }

        return new String(arr);
    }
}
