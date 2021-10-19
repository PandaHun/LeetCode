/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static int n;
    private static int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return n;
    }
    
    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        count--;
        if (count == 0) {
            n = root.val;
            return;
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }
}