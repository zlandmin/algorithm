package leetcode._151_199._157;

/**
 * 157. Read N Characters Given Read4
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Example 1:
 *
 * Input: buf = "abc", n = 4
 * Output: "abc"
 * Explanation: The actual number of characters read is 3, which is "abc".
 *
 * Example 2:
 *
 * Input: buf = "abcde", n = 5
 * Output: "abcde"
 *
 * Note:
 * The read function will only be called once for each test case.
 *
 */
public class LC_157 {
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int index = 0;
        while (true) {
            int count = read4(temp);
            count = Math.min(count, n - index);
            for (int i = 0; i < count; i++) {
                buf[index++] = temp[i];
            }
            if (index == n || count < 4) {
                return index;
            }
        }
    }

    private int read4(char[] buffer) {
        //this is a fake method to make Eclipse happy
        return 0;
    }
}
