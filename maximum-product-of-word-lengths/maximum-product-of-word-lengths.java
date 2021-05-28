class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        int len = words.length;
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (char ch : word.toCharArray()) values[i] |= 1 << (ch - 'a'); 
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((values[i] & values[j]) == 0) max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }
}