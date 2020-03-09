class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        char[] prevArr = prev.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < prevArr.length; i++) {
            if (prevArr[i] == prevArr[i - 1]) {
                count++;
            } else {
                sb.append((char) ('0' + count)); // note 1
                sb.append(prevArr[i - 1]);
                count = 1;
            }
        }
        sb.append((char) ('0' + count));
        sb.append(prevArr[prevArr.length - 1]);
        return sb.toString();
    }
}

/**
* performance: 1 ms < 97%, 37 MB < 5%
* notes: 1. cast int to char 
*/
