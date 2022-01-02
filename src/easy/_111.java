package easy;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
//sol : https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/1637291/BFS-and-DFS-approaches
public class _111 {

    public static void main(String[] args) {
        Optional op = Optional.of("Hello");
        String[] s = new String[10];
        Optional so = Optional.ofNullable(s[9]);
        System.out.println(so.isPresent());
        System.out.println(op.isPresent());

    }

    //dfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        if (root.left == null) return right;
        if (root.right == null) return left;
        return Math.min(left, right);
    }

    //bfs
    public int minDepthOpt(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return 0;
        int length = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueLen = queue.size();
            while (queueLen != 0) {
                TreeNode currNode = queue.poll();
                if (currNode.left == null && currNode.right == null) {
                    return length;
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                queueLen--;
            }
            length++;
        }
        return length;
    }
}
