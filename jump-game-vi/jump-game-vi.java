class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (q.size() > 0 && q.peekFirst() < i - k) {
                q.removeFirst();
            }
            dp[i] = nums[i] + (q.size() > 0 ? dp[q.peekFirst()] : 0);
            while (q.size() > 0 && dp[q.peekLast()] <= dp[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        return dp[len - 1];
    }
}