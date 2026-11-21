class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        for (int i = 0 ; i < m - 2; i++) {
            for (int j =  0; j < n - 2; j++) {
                int temp = grid[i + 1][j + 1];
                temp += grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                temp += grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                answer = Math.max(answer, temp);
            }
        }
        return answer;
    }
}