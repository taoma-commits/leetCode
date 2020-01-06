/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
Memory Usage: 38.1 MB, less than 95.52% of Java online submissions for Two Sum II - Input array is sorted.
Note: double pointers to reduce the space complexity (comparing with hash table solution)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int [] result = new int[2];
        while (i < j) {
            int current = numbers[i] + numbers[j];
            if (current == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
            if (current < target) i++;
            if (current > target) j--;
        }
        return null;
    }
}
