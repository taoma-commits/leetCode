class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int votes_1 = 0, votes_2 = 0;
    int cand_1 = 0, cand_2 = 1;
    // set two candidates to different values: nums = [0,0]
    for (int num : nums) {
      // check whether equal to avoid cand_1 = cand_2
      if (num == cand_1) {
        votes_1++;
      } else if (num == cand_2) {
        votes_2++;
      } else if (votes_1 == 0) {
        cand_1 = num;
        votes_1++;
      } else if (votes_2 == 0) {
        cand_2 = num;
        votes_2++;
      } else {
        votes_1--;
        votes_2--;
      }
    }
    int count_1 = 0, count_2 = 0;
    for (int num : nums) {
      if (num == cand_1) {
        count_1++;
      } else if (num == cand_2) {
        count_2++;
      }
    }
    List<Integer> res = new ArrayList<>();
    if (count_1 > nums.length / 3) {
      res.add(cand_1);
    }
    if (count_2 > nums.length / 3) {
      res.add(cand_2);
    }
    return res;
  }
}

/**
 * performance: 2 ms < 100%, 43 MB < 7%
 * time complexity: ~3n, O(n)
 * space complexity: O(1)
 * notes: Moore's voting algorithm 
 */
