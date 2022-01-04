class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int answer = 0;
        int l = 0;
        int r = len - 1;
        int leftMax = -1;
        int rightMax = -1;
        while ( l <= r ) {
            if (height[l] <= height[r]) {
                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    answer += leftMax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    answer += rightMax - height[r];
                }
                r--;
            }
        }
        return answer;
    }
}