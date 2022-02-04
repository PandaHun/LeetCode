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
    int answer = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getHeight(root);
        return answer;
    }
    
    int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int L = getHeight(root.left);
        int R = getHeight(root.right);
        
        answer = Math.max(answer, L + R + 2);
        
        return 1 + Math.max(L, R);
    }
}