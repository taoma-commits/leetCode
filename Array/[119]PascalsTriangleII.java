/*
Runtime: 1 ms, faster than 89.70% of Java online submissions for Pascal's Triangle II.
Memory Usage: 37.1 MB, less than 6.17% of Java online submissions for Pascal's Triangle II.
*/

// notes: O(rowIndex) space complexity 


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
