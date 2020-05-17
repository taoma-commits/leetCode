class Solution {
  public boolean canAttendMeetings(int[][] intervals) {
    Comparator<int[]> comparator = new Comparator<>() {
      public int compare(int[] i1, int[] i2) {
        return i1[0] - i2[0];
      }
    };
    Arrays.sort(intervals, comparator);
    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }
    return true;
  }
}
/**
 * performance: 6 ms < 93%
 * time complexity: O(n*log(n))
 * space complexity: O(1)
 * notes: implementation of a new Comparator.
 */
