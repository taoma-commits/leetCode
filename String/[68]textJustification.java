class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int lastIdx = 0;
        int len = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= words.length; i++) {
            if (i == words.length || len + words[i].length() + i - lastIdx > maxWidth) {
                int spaces = maxWidth - len;
                int slots = i - lastIdx - 1;
                StringBuilder sb = new StringBuilder();
                if (slots == 0 || i == words.length) {
                    for (int j = lastIdx; j < i; j++) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            sb.append(' ');
                            spaces--;
                        }
                    }
                    appendSpaces(sb, spaces);
                } else {
                    int each = spaces / slots;
                    int left = spaces % slots;
                    for (int j = lastIdx; j < lastIdx + slots; j++) {
                        sb.append(words[j]);
                        int n = (j < left + lastIdx) ? each + 1 : each;
                        appendSpaces(sb, n);
                    }
                    sb.append(words[i - 1]);
                }
                res.add(sb.toString());
                lastIdx = i;
                len = 0;   
            }
            if (i < words.length) {
                len += words[i].length();
            }
        }
        return res;
    }

    private void appendSpaces(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
    }
}

/**
 * performance: 0 ms < 100%, 37 MB < 5%
 * notes: 
 */
