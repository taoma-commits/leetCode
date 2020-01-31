// tag : array, bucket sort
// notes: bucket-sort-like algorithm, in-place so constant memory complexity.

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for First Missing Positive.
Memory Usage: 37.4 MB, less than 6.85% of Java online submissions for First Missing Positive.
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
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

/*
Runtime: 2 ms, faster than 12.32% of Java online submissions for First Missing Positive.
Memory Usage: 39.2 MB, less than 6.85% of Java online submissions for First Missing Positive.
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
