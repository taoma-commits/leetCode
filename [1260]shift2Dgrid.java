/*
Runtime: 14 ms, faster than 16.25% of Java online submissions for Shift 2D Grid.
Memory Usage: 59.8 MB, less than 100.00% of Java online submissions for Shift 2D Grid.
*/

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> shiftedGrid = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) row.add(0);
            shiftedGrid.add(row);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                shiftedGrid.get((i + (j + k) / n) % m).set((j + k) % n, grid[i][j]);
            }
        }
        return shiftedGrid;
    }
}

/*
Runtime: 7 ms, faster than 35.52% of Java online submissions for Shift 2D Grid.
Memory Usage: 48.2 MB, less than 100.00% of Java online submissions for Shift 2D Grid.
*/

// inspired by [189] rotate array: translate an array by three rotations.

class Solution {
    private void reverse(int[] array, int front, int end) {
        while (front < end) {
            int temp = array[front];
            array[front++] = array[end];
            array[end--] = temp;
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[] array = new int[m * n];
        List<List<Integer>> shiftedGrid = new ArrayList<>();
        k %= m * n;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
                array[i * n + j] = grid[i][j];
            }
            shiftedGrid.add(row);
        }
        reverse(array, 0, m * n - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, m * n - 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                shiftedGrid.get(i).set(j, array[i * n + j]);
            }
        }
        return shiftedGrid;
    }
}
