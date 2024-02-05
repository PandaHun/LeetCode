class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[nums.length * 2];
        int len = nums.length;
        for (int i = 0 ; i < len; i ++) {
            answer[i] = answer[i + len] = nums[i];
        }
        return answer;
    }
}