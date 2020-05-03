class Solution {
  public String res;
  boolean[] seen;
  int N;
  int count;
  public String getPermutation(int n, int k) {
    N = n;
    seen = new boolean[n];
    count = k;
    backtrack(0, new StringBuilder());
    return res;
  }
  private void backtrack(int i, StringBuilder sb) {
    if (count == 0) return;
    if (i == N) {
      count--;
      if (count == 0) res = sb.toString();
      return;
    }
    for (int j = 0; j < N; j++) {
      if (seen[j]) continue;
      sb.append(j + 1);
      seen[j] = true;
      backtrack(i + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
      seen[j] = false;
    }
  }
}

/**
 * performance: 796 ms < 13%, 37 MB < 10%
 * time complexity: O(n * n!) every call of backtrack scans through seen.
 * space complexity: O(n)
 */


 class Solution {
   public String getPermutation(int n, int k) {
     StringBuilder sb = new StringBuilder();
     List<Integer> nums = new ArrayList<>();
     int[] factorial = new int[n + 1];
     factorial[0] = 1;
     for (int i = 1; i < n + 1; i++) {
       factorial[i] = factorial[i - 1] * i;
       nums.add(i);
     }
     for (int i = n - 1; i > -1; i--) {
       int idx = (k - 1) / factorial[i];
       k -= idx * factorial[i];
       sb.append(nums.get(idx));
       nums.remove(idx);
     }
     return sb.toString();
   }
 }

 /**
  * performance: 2 ms < 84%, 37 MB < 10%
  * time complexity: O(n^2)
  * space complexity: O(n)
  */
