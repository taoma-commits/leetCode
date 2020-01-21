/*
Runtime: 12 ms, faster than 19.10% of Java online submissions for Path Sum III.
Memory Usage: 46.4 MB, less than 6.82% of Java online submissions for Path Sum III.
*/

/*
* time complexity: O(n^2)
*/

class Solution {
    private int path(TreeNode node, int sum) {
        int count = 0;
        if (node != null) {
            sum -= node.val;
            if (sum == 0) count++;
            count += path(node.left, sum);
            count += path(node.right, sum);
        }
        return count;
    }
    public int pathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        if (root != null) stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            count += path(node, sum);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return count;
    }
}

/*
Runtime: 4 ms, faster than 75.26% of Java online submissions for Path Sum III.
Memory Usage: 45.1 MB, less than 9.09% of Java online submissions for Path Sum III.
*/

/*
* time complexity: O(n)
* update hashMap value: map.put(key, map.getOrDefault(key, 0) + 1)
* like in problem 560, simplify code by adding (0, 1) pair to hashMap 
* in DFS, erase change made to hashMap at a node before go to the upper level.
*/

class Solution {
    private int pathSum(TreeNode node, int sum, int cum, HashMap<Integer, Integer> map) {
        if (node == null) return 0;
        int count = 0;
        cum += node.val;
        if (map.containsKey(cum - sum)) count += map.get(cum - sum);
        map.put(cum, map.getOrDefault(cum, 0) + 1);
        count += pathSum(node.left, sum, cum, map) + pathSum(node.right, sum, cum, map);
        map.put(cum, map.get(cum) - 1);
        return count;
    }

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSum(root, sum, 0, map);
    }
}
