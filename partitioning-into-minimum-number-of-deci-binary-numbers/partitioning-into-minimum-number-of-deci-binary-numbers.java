class Solution {
    public int minPartitions(String n) {
        int answer = 0;
        int len = n.length();
        for (int i = 0 ; i < len; i++) {
            answer = Math.max(answer, n.charAt(i) - 48);
        }
        return answer;
    }
}