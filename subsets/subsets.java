class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(), nums, 0);
        return answer;
    }
    
    private void dfs(List<Integer> list, int[] nums, int n) {
        if (n == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[n]);
        dfs(list, nums, n + 1);
        list.remove(list.size() - 1);
        dfs(list, nums, n + 1);
    }
}