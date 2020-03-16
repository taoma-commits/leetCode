class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int l = low.length();
        int r = high.length();
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (l < i && i < r) {
                count += helper(i, true).size();
            } else {
                for (String str : helper(i, true)) {
                    if (!(i == l && str.compareTo(low) < 0) && !(i == r && str.compareTo(high) > 0)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public List<String> helper(int n, boolean top) {
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        List<String> res = new ArrayList<>();
        for (String str : helper(n - 2, false)) {
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
            if (!top) {
                res.add("0" + str + "0");
            }
        }
        return res;
    }
}


/**
* performance: 37 ms < 80%, 55 MB < 58% 
*/
