class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] convert = convertPattern(pattern);
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (Arrays.equals(convert, convertPattern(word))) {
                answer.add(word);
            }
        }
        return answer;
    }
    
    private int[] convertPattern(String pattern) {
        HashMap<Character, Integer> patternIdx = new HashMap<>();
        int idx = 0;
        int[] ret = new int[pattern.length()];
        for (int i = 0; i < ret.length; i++) {
            char c = pattern.charAt(i);
            if (!patternIdx.containsKey(c)) {
                patternIdx.put(c, idx);
                ret[i] = idx;
                idx += 1;
            } else {
                ret[i] = patternIdx.get(c);
            }
        }
        return ret;
    }
}