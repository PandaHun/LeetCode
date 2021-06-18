class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return solve(nums, right) - solve(nums, left - 1);
    }

    int solve(int[] nums, int bound) {
        int ret = 0;
        int count = 0;
        for (int num : nums) {
            if (num <= bound) {
                count += 1;
                ret += count;
            } else {
                count = 0;
            }
        }
        return ret;
    }
}