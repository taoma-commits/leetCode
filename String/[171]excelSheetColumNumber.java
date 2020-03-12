class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] - 'A' + 1) * Math.pow(26, arr.length - i - 1);
        }
        return (int) sum;
    }
}

/**
* performance: 1 ms < 100%, 38 MB < 5%
*/
