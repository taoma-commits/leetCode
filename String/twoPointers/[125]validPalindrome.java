class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(arr[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(arr[right])) {
                right--;
            }
            if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}

/**
 * performance: 3 ms < 94%, 39.2 MB < 10 %
 * notes: digits are considered as letters.
 */

 class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}

/**
 * performance: 5 ms < 70%, 40 MB < 6%
 */
