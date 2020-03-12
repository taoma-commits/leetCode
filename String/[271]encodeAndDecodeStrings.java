public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append('#'); // seperator 
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int end = i + 1;
            while (s.charAt(end) != '#') {
                end++;
            }
            int len = Integer.valueOf(s.substring(i, end)); // note 2
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(end + 1, end + len + 1));
            list.add(sb.toString());
            i = end + len + 1;
        }
        return list;
    }
}

/**
* performance: 7 ms < 68%, 42 MB < 6%
* notes: 1. the seperator '#' is necessary because
        the length could have more than one digit.
        2. convert string representation of an integer to integer.
*/
