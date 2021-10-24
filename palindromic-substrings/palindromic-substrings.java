class Solution {
    
    private static int length;
    
    public int countSubstrings(String s) {
        int answer = 0;
        length = s.length();
        for (int i = 0; i < length; i++) {
            answer += solve(s, i, i) + solve(s, i, i + 1);
        }
        return answer;
    }
    
    private int solve(String s, int left, int right) {
        int count = 0;
        while (0 <= left && right < length && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}