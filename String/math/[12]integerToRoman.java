class Solution {
    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        int n = num;
        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < 13; i++) {
            int k = n / values[i];
            if (k != 0) {
                for (int j = 0; j < k; j++) {
                    sb.append(symbols[i]);
                }
            }
            n -= k * values[i];
        }
        return sb.toString();
    }
}

/**
* performance: 5 ms < 92%, 40 MB < 5%
* notes: symbols can not be stored in char[]
*/
