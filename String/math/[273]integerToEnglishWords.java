class Solution {
    private final String[] belowTwenty = {
        "", "One ", "Two ", "Three ", "Four ", "Five ",
        "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
        "Eleven ", "Twelve ", "Thirteen ", "Fourteen ",
        "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
        "Nineteen "
        };
    private final String[] belowHundred = {
        "", "", "Twenty ",
         "Thirty ", "Forty ", "Fifty ", "Sixty ",
         "Seventy ", "Eighty ", "Ninety "
         };
    private final String[] scales = {
        "", "Thousand ", "Million ", "Billion "
        };

    public String helper(int num) {
        int a = num / 100;
        int b = num % 100;
        int c = num % 10;
        StringBuilder sb = new StringBuilder();
        if (a > 0) {
            sb.append(belowTwenty[a]);
            sb.append("Hundred ");
        }
        if (b > 19) {
            sb.append(belowHundred[b / 10]);
            sb.append(belowTwenty[c]);
        } else {
            sb.append(belowTwenty[b]);
        }
        return sb.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero"; // corner case!
        }
        String ans = "";
        int scale = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int r = num % 1000;
            num /= 1000;
            sb.append(helper(r));
            if (r > 0) {
                sb.append(scales[scale]); // another corner case!
            }
            scale++;
            ans = sb.toString() + ans;
            sb = new StringBuilder();
        }
        return ans.substring(0, ans.length() - 1); // prune extra space char
    }
}

/**
* performance: 3 ms < 68%, 38 MB < 5%
*/
