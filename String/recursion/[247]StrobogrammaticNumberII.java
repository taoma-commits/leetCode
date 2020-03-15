class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, true);
    }

    public List<String> helper(int n, boolean top) {
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        List<String> res = new ArrayList<>();
        for (String s : helper(n - 2, false)) {
            if (!top) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}

/**
* performance: 22 ms < 53%, 48 MB < 100%
*/
