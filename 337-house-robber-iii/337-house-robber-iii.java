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
    public int rob(TreeNode root) {
        int[] result = steal(root);
        return Math.max(result[0], result[1]);
    }
    
    public int[] steal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = steal(root.left);
        int[] right = steal(root.right);
        
        int[] answer = new int[2];
        answer[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        answer[1] = root.val + left[0] + right[0];
        
        return answer;
    }
}