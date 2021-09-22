class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    
    private static void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> answer) {
        if (answer.size() == nums.length) {
            res.add(new ArrayList<Integer>(answer));
            return;
        }
        for (int i = 0 ; i < nums.length ; i++) {
            if (!used[i]) {
                answer.add(nums[i]);
                used[i] = true;
                dfs(res, nums, used, answer);
                answer.remove(answer.size() - 1);
                used[i] = false;
            }
        }
    }
}