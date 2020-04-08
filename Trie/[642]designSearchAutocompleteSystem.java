class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String str = null;
    int count = 0;

    public static class Order implements Comparator<TrieNode> {
        public int compare(TrieNode v, TrieNode w) {
            if (v.count < w.count) return -1;
            if (v.count > w.count) return +1;
            return w.str.compareTo(v.str);
        }
    }
}

class AutocompleteSystem {
    private TrieNode root = new TrieNode();
    private TrieNode currentNode = root;
    StringBuilder sb = new StringBuilder();
    PriorityQueue<TrieNode> pq = new PriorityQueue(4, new TrieNode.Order());

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < times.length; i++) {
            String s = sentences[i];
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.str = s;
            node.count = times[i];
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            currentNode.str = sb.toString();
            currentNode.count += 1;
            sb = new StringBuilder();
            currentNode = root;
            return res;
        }
        sb.append(c);
        if (!currentNode.children.containsKey(c)) {
            currentNode.children.put(c, new TrieNode());
        }
        currentNode = currentNode.children.get(c);
        findSentences(currentNode);
        while (pq.peek() != null) {
            res.add(0, pq.poll().str);
        }
        return res;
    }

    private void findSentences (TrieNode node) {
        if (node != null) {
            if (node.str != null) {
                pq.offer(node);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
            for (TrieNode child : node.children.values()) {
                findSentences(child);
            }
        }
    }
}



/**
 * performance: 219 ms < 60%, 48 MB < 100%;
 * notes: 1. priority queue (min heap) or sort.
 *        2. need to make new TrieNode for a character if it
 *           not in the keys of children.
 *        3. implement comparator. 
 */
