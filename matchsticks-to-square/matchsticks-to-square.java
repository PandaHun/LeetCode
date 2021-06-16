class Solution {
    int edge;
    boolean[] used;

    public boolean makesquare(int[] matchsticks) {
        int totalLength = 0;
        for (int stick : matchsticks) {
            totalLength += stick;
        }
        if (totalLength == 0 || totalLength % 4 != 0) {
            return false;
        }
        edge = totalLength / 4;
        Arrays.sort(matchsticks);
        used = new boolean[matchsticks.length];
        return solve(matchsticks, 0, 0, matchsticks.length - 1);
    }

    boolean solve(int[] nums, int count, int target, int start) {
        if (target == 0) {
            if (++count == 4) {
                return true;
            }
            return solve(nums, count, edge, nums.length - 1);
        }
        for (int i = start; i >= 0; i--) {
            if (!used[i] && target >= nums[i]) {
                if (i + 1 < nums.length && !used[i + 1] && nums[i + 1] == nums[i]) {
                    continue;
                }
                used[i] = true;
                if (solve(nums, count, target - nums[i], i - 1)) {
                    return true;
                }
                used[i] = false;

                if (nums[i] == target || target == edge) {
                    return false;
                }
            }
        }
        return false;
    }
}