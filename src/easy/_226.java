package easy;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/invert-binary-tree/
public class _226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }

    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            TreeNode tempLeft = curr.left;
            curr.left = curr.right;
            curr.right = tempLeft;

            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode tempLeft = curr.left;
            curr.left = curr.right;
            curr.right = tempLeft;


            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return root;
    }
}
