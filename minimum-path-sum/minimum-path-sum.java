class Solution {
    public int minPathSum(int[][] grid) {
        for (int r = 1 ; r < grid.length; r++) {
            grid[r][0] += grid[r - 1][0];
        }
        for (int c = 1; c < grid[0].length; c++) {
            grid[0][c] += grid[0][c - 1];
        }
        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++) {
                grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}