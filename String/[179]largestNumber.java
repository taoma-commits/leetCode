class Solution {
    public static class largestNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);  // note 1
        }
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]); // note 2
        }

        Arrays.sort(strs, new largestNumberComparator()); // note 3
        if (strs[0].equals("0")) { // note 4
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}

/**
* performance: 7 ms < 63%, 39 MB < 5%
* notes: 1. prove this order works
        2. convert int to string
        3. sort by the new comparator
        4. corner cases like "00"
* time complexity: O(nlog(n))
* space complexity: O(n)
* tag: sort 
*/
