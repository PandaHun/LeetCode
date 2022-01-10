class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int now = prices[0];
        for (int i = 1;  i < prices.length; i++) {
            if (prices[i] > now) {
                answer = Math.max(answer, prices[i] - now);
            } else {
                now = prices[i];
            }
        }
        return answer;
    }
}