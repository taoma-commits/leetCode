/*
Runtime: 24 ms, faster than 98.30% of Java online submissions for 3Sum.
Memory Usage: 45.6 MB, less than 96.11% of Java online submissions for 3Sum.
*/

//tag: array, two pointers.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length - 1; i++) {
            if (nums[i] >= 0 && nums[i] != nums[i + 1]) {
                int curr = nums[i];
                List<List<Integer>> list = twoSum(Arrays.copyOfRange(nums, 0, i), -curr);
                for (List<Integer> l : list) l.add(curr);
                ans.addAll(list);
                }
            }
        int last = nums[nums.length - 1];
        if (last >= 0) {
            List<List<Integer>> list = twoSum(Arrays.copyOfRange(nums, 0, nums.length - 1), -last);
            for (List<Integer> l : list) l.add(last);
            ans.addAll(list);
            }
        return ans;
        }

    private List<List<Integer>> twoSum(int[] nums, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = nums.length - 1;
        int l = nums[0] - 1, r = nums[nums.length - 1] + 1;
        while (i < j) {
            if (nums[i] == l && nums[j] == r && l + r == sum) {
                i++;
                j--;
            }
            else {
                l = nums[i];
                r = nums[j];
                if (l + r <= sum) i++;
                if (l + r >= sum) j--;
                if (l + r == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(l);
                    list.add(r);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
