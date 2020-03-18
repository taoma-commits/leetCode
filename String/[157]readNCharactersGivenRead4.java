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
    public int read(char[] buf, int n) {
        int count = 0;
        char[] buf4 = new char[4];
        while (true) {
            int k = read4(buf4);
            int i = 0;
            while (count < n && i < k) {
                buf[count++] = buf4[i++];
            }
            if (count == n || k < 4) {
                return count;
            }
        }
    }
}
