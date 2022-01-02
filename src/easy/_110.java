package easy;

import util.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/
//solutions: https://leetcode.com/problems/balanced-binary-tree/discuss/816479/Java-or-Easy
public class _110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(count(root.left) - count(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int count(TreeNode node) {
        if (node ==null){
            return 0;
        }
        return Math.max(count(node.left), count(node.right)) + 1;
    }
}
