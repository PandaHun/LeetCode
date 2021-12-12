class Solution {
    public int numTrees(int n) {
        int[] trees = new int[n + 1];
        trees[0] = trees[1] = 1;
        for (int next = 2; next <= n; ++next) {
            for (int cur = 1; cur <= next; ++cur) {
                trees[next] += trees[cur - 1] * trees[next - cur];
            }
        }
        return trees[n];
    }
}