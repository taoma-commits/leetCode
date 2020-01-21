/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Mode in Binary Search Tree.
Memory Usage: 46.2 MB, less than 7.14% of Java online submissions for Find Mode in Binary Search Tree.
*/


class Solution {
    List<Integer> list = new ArrayList<> ();
    TreeNode preNode = null;
    int max = 0, count = 0;
    // max is the current number of occurance of the current mode(s) in the list
    // count records the number of occurance of the current node.val
    // the helper method updates the three global variables

    public int[] findMode(TreeNode root) {
        helper(root);
        int[] res = new int[list.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
        // the findMode method converts ArrayList obtained from helper to array and then return the array.
    }

    private void helper (TreeNode root) {
        if (root == null) return;
        helper(root.left);
        // now the prenode is set to the bottom right node of the root's left subtree.
        // whose value is the right next value of the current node.val to the left among all values in the BST.
        if (preNode != null && root.val == preNode.val) count++;
        else count = 1;

        if (count > max) {
            list.clear();
            list.add(root.val);
            max = count;
        } else if (max == count) list.add(root.val);

        preNode = root; // set prenode to the root before traverse the right subtree.
        helper(root.right);
    }
}
