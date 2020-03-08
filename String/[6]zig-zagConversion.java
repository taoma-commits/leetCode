class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        int n = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < s.length(); j += n) {
                sb.append(s.charAt(i + j));
                int idx = 2 * numRows + j - i - 2;
                if (i != 0 && i != numRows - 1 && idx < s.length()) {
                    sb.append(s.charAt(idx));
                }
            }
        }
        return sb.toString();
    }
}


/**
* performance: 3 ms < 99%, 41.5 MB < 6%
* notes: iterate through rows instead of characters of s.
*/



class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());

        int n = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int row = i % n;
            if (row + 1 > numRows) {
                row = n - row;
            }
            rows.get(row).append(s.charAt(i));
        }
        StringBuilder output = new StringBuilder();
        for (StringBuilder row : rows) {
            output.append(row);
        }
        return output.toString();
    }
}

/**
* performance: 8 ms < 73%, 41 MB < 7%
* notes:
*/
