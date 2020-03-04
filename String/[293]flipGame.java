class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> output = new ArrayList<>();
        if (s == null || s.length() < 2) {
            return output;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) // note 2 == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.replace(i, i + 2, "--"); // note 1
                output.add(sb.toString());
            }
        }
        return output;
    }
}

/**
* performance: 1 ms < 68%, 39 MB < 6%
* notes: 1. string builder replace method
        2. string to string builder
*/

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> output = new ArrayList<>();
        for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0;) {
            output.add(s.substring(0, i) + "--" + s.substring(i + 2));
        }
        return output;
    }
}

/**
* shorter code, worse performance.
*/
