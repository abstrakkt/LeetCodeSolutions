package easy;

import util.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class _104 {
    int maxCount = 1;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        depth(root, 1);
        return maxCount;
    }

    void depth(TreeNode node, int count) {
        if (node == null)
            return;
        depth(node.left, count + 1);
        depth(node.right, count + 1);
        maxCount = Math.max(maxCount, count);
    }
}
