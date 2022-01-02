package easy;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
//iterative solution : https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/1634950/Preorder-Inorder-and-Postorder-Traversal
public class _94 {
    private void traversal(TreeNode node, List<Integer> res) {
        if (node == null){
            return;
        }
        traversal(node.left, res);
        res.add(node.val);
        traversal(node.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
}
