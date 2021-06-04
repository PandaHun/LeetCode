class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int beforeH = 0;
        int beforeV = 0;
        int maxH = 0;
        int maxV = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int now : horizontalCuts) {
            maxH = Math.max(maxH, now - beforeH);
            beforeH = now;
        }
        for (int now : verticalCuts) {
            maxV = Math.max(maxV, now - beforeV);
            beforeV = now;
        }
        maxH = Math.max(maxH, h - beforeH);
        maxV = Math.max(maxV, w - beforeV);
        return (int) ((long) maxH * maxV % 1000000007);
    }
}