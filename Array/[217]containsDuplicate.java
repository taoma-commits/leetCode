/*
Runtime: 9 ms, faster than 57.96% of Java online submissions for Contains Duplicate.
Memory Usage: 44.8 MB, less than 36.21% of Java online submissions for Contains Duplicate.
@hashSet
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
