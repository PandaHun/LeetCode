class Solution {
    public String removeDuplicates(String s, int k) {
        int i = 0;
        int len = s.length();
        int[] count = new int[len];
        char[] stack = s.toCharArray();
        for (int j = 0; j < len; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) {
                i -= k;
            }
        }
        return new String(stack, 0, i);
    }
}