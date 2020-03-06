class Solution {
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }

    public boolean canWin(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                boolean canOppWin = canWin(arr);
                arr[i] = '+';
                arr[i + 1] = '+'; // note 1
                if (!canOppWin) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
* performance: 23 ms < 44%, 37.5 MB < 63%
* note: 1. must recover array before any possible return!!!
        2. array iteration is faster than string iteration?
* time complexity: see [294]timeComplexity.md
*/
