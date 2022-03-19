class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int now = nums[i];
            int prevMax = max;
            max = Math.max(Math.max(max * now, min * now), now);
            min = Math.min(Math.min(prevMax * now, min * now), now);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
} 