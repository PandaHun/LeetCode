class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > answer) {
                answer = nums[i + 1] - nums[i];
            }
        }
        return answer;
    }
}