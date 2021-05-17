class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        int answer = -1;
        HashMap<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            int wordLen = word.length();
            int chainLength = 0;
            String prediction;
            for (int i = 0 ; i < wordLen; i++) {
                prediction = word.substring(0, i) + word.substring(i + 1);
                chainLength = Math.max(chainLength, dp.getOrDefault(prediction, 0) + 1);
            }
            dp.put(word, chainLength);
            answer = Math.max(answer, chainLength);
        }
        return answer;
    }
}