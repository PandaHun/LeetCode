class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        Stack<Integer> large = new Stack<>();
        int answer = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (large.isEmpty() || h >= heights[large.peek()]) {
                large.push(i);
            } else {
                int top = large.pop();
                answer = Math.max(answer, heights[top] * (large.isEmpty() ? i : i - 1 - large.peek()));
                i--;
            }
        }
        return answer;
    }
}