class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (ableSplit(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean ableSplit(int[] nums, int amount, int m) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num <= amount) {
                sum += num;
                continue;
            }
            if (++count > m) {
                return false;
            }
            sum = num;
        }
        return true;
    }
}