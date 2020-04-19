class Solution {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int count = 0;
    int candidate = 0;
    for (int key : map.keySet()) {
      if (map.get(key) > count) {
        candidate = key;
        count = map.get(key);
      }
    }
    return candidate;
  }
}

/**
 * performance: 14 ms < 36%, 45 MB < 6%
 * time complexity: O(n)
 * space complexity: O(n)
 */

 class Solution {
   public int majorityElement(int[] nums) {
     Arrays.sort(nums);
     return nums[nums.length / 2];
   }
 }

/**
 * performance: 2 ms < 84%, 42 MB < 5%
 * time complexity: O(nlg(n))
 * space complexity: O(1)
 */



/**
 * performance: ?
 * time complexity:
 * space complexity:
 * notes: randimization
 */

/**
 * performance: ?
 * time complexity:
 * space complexity:
 * notes: divide and conquer
 */

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                candidate = num;
            }
            votes += candidate == num ? 1 : -1;
        }
    return candidate;
    }
}

/**
 * performance: 1 ms < 100%, 42 MB < 17%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: Moore voting algorithm
 */
