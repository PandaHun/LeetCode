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
    int answer;
	
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> count = new HashMap();
        count.put(0, 1);
        solve(root, 0, targetSum, count);  
        return answer;
    }
    
    void solve(TreeNode root, int currSum, int target, Map<Integer, Integer> count) {
        if(root == null) {
            return;
        }
        int sum = currSum + root.val;
        
        if(count.containsKey(sum - target)) {
            answer += count.get(sum - target);
        }
        
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        solve(root.left, currSum + root.val, target, count);
        solve(root.right, currSum + root.val, target, count);
        count.put(sum, count.get(sum) - 1);
    }
}