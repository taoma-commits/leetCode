class Solution {
    public int stepID(char step) {
        switch (step) { // note2
            case ' ': return 0;
            case '+': ;
            case '-': return 1;
            case '.': return 3;
            case 'e': ;
            case 'E': return 4;
            default:
                if (step - '0' >= 0 && step - '0' < 10) {
                    return 2;
                }
        }
        return 5;
    }
    public boolean isNumber(String s) {
        int state = 0;
        int step = 0;
        int[][] table = new int[][]{
            {0, 1, 2, 3, -1, -1},
            {-1, -1, 2, 3, -1, -1},
            {8, -1, 2, 4, 5, -1},
            {-1, -1, 4, -1, -1, -1},
            {8, -1, 4, -1, 5, -1},
            {-1, 6, 7, -1, -1, -1},
            {-1, -1, 7, -1, -1, -1},
            {8, -1, 7, -1, -1, -1},
            {8, -1, -1, -1, -1, -1}
        };
        int[] finalStates = new int[]{0, 0, 1, 0, 1, 0, 0, 1, 1};
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            step = stepID(arr[i]);
            state = table[state][step];
            if (state < 0) {
                return false;
            }
        }
        return finalStates[state] == 1;
    }
}


/**
 * performance: 3 ms < 71%, 39 MB < 50%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: table-driven approach; switch statement
 */
