class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[]{efficiency[i], speed[i]};
        }
        Arrays.sort(dp, (a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long total = 0;
        long best = 0;

        for (int[] d : dp) {
            int s = d[1];
            pq.add(s);
            if (pq.size() <= k) {
                total += s;
            } else {
                total += s - pq.poll();
            }
            best = Math.max(best, total * d[0]);
        }
        return (int) (best % 1000000007);
    }
}