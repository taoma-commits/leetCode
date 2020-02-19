class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            while (l < r && vowels.indexOf(arr[l]) == -1) { // note 1
                l++;
            }
            while (l < r && vowels.indexOf(arr[r]) == -1) {
                r--;
            }
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
        return new String(arr);
    }
}

/**
* performance: 4 ms < 83%, 46 MB < 5%
* notes: 1. trick to search whether a char is in a string by string.indexOf()
        2. always turn string to array of chars if want to modify string.
* tag: two pointers
*/
