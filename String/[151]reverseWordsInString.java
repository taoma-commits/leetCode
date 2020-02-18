class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                if (sb.length() > 0) { // note 3
                    sb.append(" ");
                }
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}

/**
* performance: 2 ms < 100%, 45 MB < 5%;
* notes: 1. StringBuilder
* 2. s.split(); two successive splitters create an empty string!
* 3. cases where string begins and ends with spaces!
* 4. space: O(n), can do in-place without StringBuilder.  
*/
