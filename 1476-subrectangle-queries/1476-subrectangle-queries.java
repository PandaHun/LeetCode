class SubrectangleQueries {
    
    private int[][] square;

    public SubrectangleQueries(int[][] rectangle) {
        int row = rectangle.length;
        int col = rectangle[0].length;
        this.square = new int[row][col];
        for (int r = 0 ; r < row; r++) {
            for (int c = 0; c < col; c++) {
                this.square[r][c] = rectangle[r][c];
            }
        }
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                this.square[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return this.square[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */