class Solution {
    private int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s3.length() == 0) {
            return true;
        }
        dp = new int[s1.length()][s2.length()];
        return isInterleaving(0, s1, 0, s2, 0, s3);
    }

    private boolean isInterleaving(int i1, String s1, int i2, String s2, int i3, String s3) {
        if (i1 >= s1.length() || i2 >= s2.length()) {
            return s3.substring(i3).equals(i1 >= s1.length() ? s2.substring(i2) : s1.substring(i1));
        }
        if (dp[i1][i2] > 0) {
            return false;
        }

        char c1 = s1.charAt(i1);
        char c2 = s2.charAt(i2);
        char c3 = s3.charAt(i3++);
        if (c1 == c3 && isInterleaving(i1 + 1, s1, i2, s2, i3, s3)) {
            return true;
        }
        if (c2 == c3 && isInterleaving(i1, s1, i2 + 1, s2, i3, s3)) {
            return true;
        }
        dp[i1][i2]++;
        return false;
    }
}