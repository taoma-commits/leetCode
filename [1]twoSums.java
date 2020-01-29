/*
Runtime: 2 ms, faster than 98.76% of Java online submissions for Two Sum.
Memory Usage: 37.2 MB, less than 98.95% of Java online submissions for Two Sum.
*/

// tag: hashtable 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> st = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (st.containsKey(nums[i])) {
                result[0] = st.get(nums[i]);
                result[1] = i;
                return result;
            }
            st.put(target - nums[i], i);
        }
        return null;
    }
}
