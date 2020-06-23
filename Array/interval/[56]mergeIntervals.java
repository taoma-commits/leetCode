class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) return intervals;
    Comparator<int[]> comparator = new Comparator<>() {
      public int compare(int[] i1, int[] i2) {
        return i1[0] - i2[0];
      }
    };
    Arrays.sort(intervals, comparator);
    List<Integer> L = new ArrayList<>();
    List<Integer> R = new ArrayList<>();
    int left = intervals[0][0];
    int right = intervals[0][1];
    for (int i = 0; i < intervals.length + 1; i++) {
      if (i == intervals.length || intervals[i][0] > right) {
        L.add(left);
        R.add(right);
        if (i < intervals.length) {
          left = intervals[i][0];
          right = intervals[i][1];
        }
      } else {
        right = Math.max(right, intervals[i][1]);
      }
    }
    int[][] res = new int[L.size()][2];
    for (int i = 0; i < L.size(); i++) {
      res[i][0] = L.get(i);
      res[i][1] = R.get(i);
    }
    return res;
  }
}
/**
 * performance: 8 ms < 64%
 * time complexity: O(n*log(n))
 * space complexity: O(n)
 */
