class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        back(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    public void back(List<List<Integer>> list, List<Integer> temp, int[] nums, int k, int s) {
        if (k < 0)  {
            return;
        } else if(k == 0) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = s; i < nums.length; i++) {
                temp.add(nums[i]);
                back(list, temp, nums, k - nums[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}