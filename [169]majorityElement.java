/*
Runtime: 2 ms, faster than 61.19% of Java online submissions for Majority Element.
Memory Usage: 42.8 MB, less than 47.06% of Java online submissions for Majority Element.
Note: Boyer-Moore voting algorithm OR bit manipulation
*/

class Solution {
    public int majorityElement(int[] nums) {
        Integer current = null;
        int score = 0;
        for (int num : nums) {
            if (score == 0) current = num;
            score += (num == current)? 1 : -1;
        }
        return current;
    }
}
