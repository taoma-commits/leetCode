/*
Runtime: 21 ms, faster than 98.93% of Java online submissions for 3Sum.
Memory Usage: 45.6 MB, less than 96.11% of Java online submissions for 3Sum.
*/

//tag: array, two pointers.

/*idea: begins with the 3rd term, iterate through array. For ith term,
* use twoSum method to find all triples with last term the value of ith term
* and update the global variable ans. 
* Cares are taken to avoid duplicates.
*/

class Solution {
    // return the global variable ans
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < 0) continue; // an optimization
            // guarantees nums[i] is the LAST among duplicates
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;
            twoSum(nums, i - 1, - nums[i]);
        }
        return ans;
    }

    // assume nums is sorted and end < nums.length
    private void twoSum(int[] nums, int end, int sum) {
        int j = end;
        for (int i = 0; i < end; i++) {
            // guarantees nums[i] is always the FIRST among duplicates
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            // for fixed i, reduce j by one if nums[i] + nums[j] > sum
            while (j > i && nums[j] + nums[i] > sum) j--;
            if (i >= j) continue; // because i is the FIRST among duplicates, i >= j rules out nums[i]
            if (nums[i] + nums[j] == sum) {
                List<Integer> triple = new ArrayList<>();
                triple.add(nums[i]);
                triple.add(nums[j]);
                triple.add(- sum);
                ans.add(triple);
            }
        }
    }
}
