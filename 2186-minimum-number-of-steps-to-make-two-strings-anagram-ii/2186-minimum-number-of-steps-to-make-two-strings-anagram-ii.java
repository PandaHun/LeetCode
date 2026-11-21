class Solution {
    public int minSteps(String s, String t) {
        int[] sCounter = new int[26];
        int[] tCounter = new int[26];
        int answer = 0;
        for (char c : s.toCharArray()) {
            sCounter[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tCounter[c - 'a']++;
        }
        for (int i = 0 ; i < 26; i++ ) {
            answer += Math.abs(sCounter[i] - tCounter[i]);
        }
        return answer;
    }
}