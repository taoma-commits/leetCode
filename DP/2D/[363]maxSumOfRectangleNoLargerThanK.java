class Solution {
  int m;
  public int maxSumSubmatrix(int[][] matrix, int k) {
    m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int[] rowSums = new int[m];
      for (int j = i; j < n; j++) {
        for (int r = 0; r < m; r++) {
          rowSums[r] += matrix[r][j];
        }
        max = Math.max(max, helper(rowSums, k));
        if (max == k) return k;
      }
    }
    return max;
  }

  private int helper(int[] rowSums, int k) {
    int prefixSum = 0;
    int prefixMax = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      if (prefixSum >= 0) {
        prefixSum += rowSums[i];
      } else {
        prefixSum = rowSums[i];
      }
      prefixMax = Math.max(prefixSum, prefixMax);
      
    }
    if (prefixMax <= k) return prefixMax;

    int max = Integer.MIN_VALUE;
    for (int l = 0; l < m; l++) {
      int sum = 0;
      for (int r = l; r < m; r++) {
        sum += rowSums[r];
        if (sum == k) return k;
        if (sum > max && sum < k) {
          max = sum;
        }
      }
    }
    return max;
  }
}

/**
 * performance: 6 ms < 99%, 40 MB < 100%
 * time complexity: O(n^2*m^2)
 * space complexity: O(m)
 * notes: brute force. 
 */
 
class Solution {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int[] rowSums = new int[m];
      for (int j = i; j < n; j++) {
        TreeSet<Integer> set = new TreeSet<>();
        int prefixSum = 0;
        set.add(0);
        for (int r = 0; r < m; r++) {
          rowSums[r] += matrix[r][j];
          prefixSum += rowSums[r];
          Integer complement = set.ceiling(prefixSum - k);
          if (complement != null) {
            if (prefixSum - complement == k) return k;
            max = Math.max(max, (prefixSum - complement));
          }
          set.add(prefixSum);
        }
      }
    }
    return max;
  }
}

/**
 * performance: 183 ms < 57%, 40 MB < 100%
 * time complexity: O(n^2 * m * log(m))
 * space complexity: O(m)
 * notes: binary search by TreeSet. 
 */
