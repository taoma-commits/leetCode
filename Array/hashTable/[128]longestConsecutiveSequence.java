class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int len = 1;
                while (set.contains(num + 1)) {
                    len++;
                    num += 1;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }
}

/**
* performance:
* tag: hash set.
* notes:
        1. optimize brutal force
        2. time complexity = O(n):
* companies: Facebook, Amazon, Microsoft, Google        
*/
