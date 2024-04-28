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
    
    private int count = 0;
    
    public int averageOfSubtree(TreeNode root) {
        order(root);
        return count;
    }
    
    Pair<Integer, Integer> order(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        
        Pair<Integer, Integer> left = order(root.left);
        Pair<Integer, Integer> right = order(root.right);
        
        int nodeSum = left.getKey() + right.getKey() + root.val;
        int nodeCount = left.getValue() + right.getValue() + 1;
        
        if (nodeSum / nodeCount == root.val) {
            count++;
        }
        return new Pair(nodeSum, nodeCount);
    }
}