class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (ratings[n - i - 1] > ratings[n - i] && arr[n - i - 1] <= arr[n - i]) { // note 2
                arr[n - i - 1] = arr[n - i] + 1;
            }
        }
        return Arrays.stream(arr).sum();
    }
}

/**
* performance: 8ms < 24%, 50 MB < 5%.
* notes: 1. two-pass greedy: left to right + right to left
        2. condition arr[n - i - 1] <= arr[n - i]
        3. time complexity = O(n), space complexity = O(n).
*/

// best solution: one-pass greedy, space complexity = O(1).  
