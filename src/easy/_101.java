package easy;

import util.TreeNode;

//https://leetcode.com/problems/symmetric-tree/
public class _101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }

        return check(left.right, right.left) && check(left.left, right.right);
    }
}
