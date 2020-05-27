class UglyNums {
  public static int[] nums = new int[1690];
  public UglyNums() {
    nums[0] = 1;
    int i2 = 0, i3 = 0, i5 = 0;
    for (int i = 1; i < 1690; i++) {
      nums[i] = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
      if (nums[i] == nums[i2] * 2) i2++;
      if (nums[i] == nums[i3] * 3) i3++;
      if (nums[i] == nums[i5] * 5) i5++;
    }
  }
}

class Solution {
  public static UglyNums uglyNums = new UglyNums();
  public int nthUglyNumber(int n) {
    return uglyNums.nums[n - 1];
  }
}

/**
 * performance: 1 ms < 100%, 37 MB < 8%
 * time complexity: O(1)
 * space complexity: O(1)
 * notes: static variable or method! Static binding happens in compile time.
 */

 class UglyNums {
   public int[] nums = new int[1690];

   public UglyNums() {
     PriorityQueue<Long> pq = new PriorityQueue<>();
     Set<Long> seen = new HashSet<>();
     int[] primes = new int[]{2, 3, 5};
     pq.add(1L);
     seen.add(1L);
     long currNum, newNum;
     for (int i = 0; i < 1690; i++) {
       currNum = pq.poll();
       nums[i] = (int) currNum;
       for (int p : primes) {
         newNum = currNum * p;
         if (!seen.contains(newNum)) {
           pq.add(newNum);
           seen.add(newNum);
         }
       }
     }
   }
 }

 class Solution {
   public static UglyNums uglyNums = new UglyNums();
   public int nthUglyNumber(int n) {
     return uglyNums.nums[n - 1];
   }
 }
 /**
  * performance: 4 ms < 62%
  * time complexity: O(1)
  * space complexity: O(1)
  * notes: priority queue;
  * set uglyNums as static variable!!
  */
