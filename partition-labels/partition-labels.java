class Solution {
    public List<Integer> partitionLabels(String s) {
        if ( s == null || s.isEmpty()) {
            return null;
        }
        int[] lastIndex = new int[26];
        int sLength = s.length();
        for (int i = 0 ; i < sLength; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0 ; i < sLength; i++) {
            right = Math.max(right, lastIndex[s.charAt(i) - 'a']);
            
            if( i == right) {
                answer.add(right - left + 1);
                left = i + 1;
                right = i + 1;
            }
        }
        return answer;
    }
}