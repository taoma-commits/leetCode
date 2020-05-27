/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    int idx = 0;
    int len = 0;
    char[] buf4 = new char[4];
    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n) {
            if (idx == len) {
                idx = 0; // note
                len = read4(buf4);
                if (len == 0) {
                    break;
                }
            }
            while (count < n && idx < len) {
                buf[count++] = buf4[idx++];
            }
        }
        return count;
    }
}

/**
 * performance: 1 ms < 100%, 38 MB < 10%
 * notes: must set idx to 0 before possible break. Because
 *        the read method will be called multiple times in
 *        one instance of Solution class.
 */
