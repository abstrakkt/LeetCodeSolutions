package easy;

import util.TreeNode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class _108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(0, nums.length - 1, nums);
    }

    private TreeNode convert(int start, int end, int[] nums) {
        if (start > end){
            return  null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convert(start, mid - 1, nums);
        node.right = convert(mid + 1, end, nums);
        return node;
    }

}
