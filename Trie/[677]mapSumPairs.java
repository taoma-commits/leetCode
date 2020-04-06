class MapSum {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        int val = 0;
    }
    /** Initialize your data structure here. */
    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
        node.val = val;
    }

    private int sum(TrieNode node) {
        int sum = node.val;
        for (char c : node.children.keySet()) {
            sum += sum(node.children.get(c));
        }
        return sum;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        int sum = 0;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return 0;
            } else {
                node = node.children.get(c);
            }
        }
        sum += sum(node);
        return sum;
    }
}

/**
 * performance: 17 ms < 51%, 39 MB < 8%
 * time complexity: O(k) every insert, O(p + m) every sum where
 * k = key.length, p = prefix.length;
 * space complexity: O(t) where t = total number of nodes 
 */
