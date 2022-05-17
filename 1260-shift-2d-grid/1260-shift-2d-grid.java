class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        k = (k % (r * c));
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i < r; i++) {
            result.add(new ArrayList<>());
        }
        int d = r * c;
        int start = d - k;
        int x = 0;
        
        for (int i = start; i < start + d; i++) {
            int row = (i /c) % r;
            int col = i % c;
            result.get(x / c).add(grid[row][col]);
            x++;
        }
        return result;
    }
}