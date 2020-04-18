class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        int j = 0;
        while (j < nums.length && nums[j] == j + 1) j++;
        return j + 1;
    }
}

/**
 * performance: 0 ms < 100.00%, 37.4 MB < 6.85%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: bucket-sort-like algorithm
 */


class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        int i = 1;
        while (set.contains(i)) i++;
        return i;
    }
}

/**
 * performance: 2 ms < 12.32%, 39.2 MB < 6.85%.
 * notes: hash table
 * time complexity = O(n)
 * space complexity = O(n)
 */
