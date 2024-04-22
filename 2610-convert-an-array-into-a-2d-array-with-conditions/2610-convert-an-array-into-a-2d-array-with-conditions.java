class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length + 1];
        
        List<List<Integer>> answer = new ArrayList<>();
        
        for (int c : nums) {
            if (freq[c] >= answer.size()) {
                answer.add(new ArrayList<>());
            }
            
            answer.get(freq[c]).add(c);
            freq[c]++;
        }
        return answer;
    }
}