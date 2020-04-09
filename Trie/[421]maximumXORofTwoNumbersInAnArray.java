class Solution {
    public class Node {
        Map<Character, Node> children = new HashMap<>();

    }
    public int findMaximumXOR(int[] nums) {

        // find maximum in nums
        int maxNum = 0;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        int L = Integer.toBinaryString(maxNum).length();
        int bitmask = 1 << L; // bitmask needed in padding
        int maxXor = 0;
        Node root = new Node();
        for (int num : nums) {
            // padding zeros
            String str = Integer.toBinaryString(num | bitmask).substring(1);
            // node for trie insertion
            Node node = root;
            // node to find the num maximizes Xor
            Node nodeXor = root;
            // Xor result
            int currentXor = 0;

            for (char c : str.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Node());
                }
                node = node.children.get(c);

                char toggle = (c == '1')? '0' : '1';
                if (nodeXor.children.containsKey(toggle)) {
                    nodeXor = nodeXor.children.get(toggle);
                    currentXor = currentXor << 1 | 1; // pad 1 from the left
                } else {
                    nodeXor = nodeXor.children.get(c);
                    currentXor = currentXor << 1; // pad 0 from the left
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }
        return maxXor;
    }
}

/**
 * performance: 139 ms < 20%, 102 MB < 8%
 * notes: 1. bit manipulation: padding trick, bitmask.
 *        2. track two nodes samultaneously.
 */
