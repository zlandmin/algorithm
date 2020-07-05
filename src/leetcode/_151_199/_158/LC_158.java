package leetcode._151_199._158;

/**
 * 158. Read N Characters Given Read4 II - Call multiple times
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note:
 * The read function may be called multiple times.
 *
 * Example 1:
 * Given buf = "abc"
 * read("abc", 1) // returns "a"
 * read("abc", 2); // returns "bc"
 * read("abc", 1); // returns ""
 *
 * Example 2:
 * Given buf = "abc"
 * read("abc", 4) // returns "abc"
 * read("abc", 1); // returns ""
 */
public class LC_158 {
    private int ptr = 0;
    private int count = 0;
    private char[] temp = new char[4];

    public int read(char[] buf, int n) {
        int cur = 0;
        while (cur < n) {
            if (ptr == 0) {
                count = read4(temp);
            }
            if (count == 0) {
                break;
            }
            while (cur < n && ptr < count) {
                buf[cur++] = temp[ptr++];
            }
            if (ptr >= count) {
                ptr = 0;
            }
        }
        return cur;
    }

    //This is a fake method to make IDE happy.
    private int read4(char[] buff) {
        return 1;
    }
}
