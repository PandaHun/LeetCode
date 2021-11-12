class Solution {
    public int findKthLargest(int[] nums, int k) {
        return sorting(nums, 0, nums.length - 1, k);
    }
    
    private int sorting(int[] nums, int left, int right, int k) {
        int pivot = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= nums[right]) {
                swap(nums, i, right);   
            }
        }
        swap(nums, pivot, right);
        int count = right - pivot + 1;
        if (count == k) {
            return nums[pivot];
        }
        if (count > k) {
            return sorting(nums, pivot + 1, right, k);
        }
        return sorting(nums, left, pivot - 1, k);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}