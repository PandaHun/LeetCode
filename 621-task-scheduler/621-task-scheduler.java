class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max = 0;
        int answer = 0;
        for (char c : tasks) {
            freq[c - 'A']++;
            max = Math.max(max, freq[c - 'A']);
        }
        
        for (int f : freq) {
            if (max == f) {
                answer++;
            }
        }
        return Math.max((max - 1) * (n + 1) + answer, tasks.length);
    }
}