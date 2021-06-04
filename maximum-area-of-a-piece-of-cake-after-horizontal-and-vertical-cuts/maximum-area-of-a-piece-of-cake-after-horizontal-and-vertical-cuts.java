class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final int M = (int) Math.pow(10, 9) + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = getMax(horizontalCuts, h);
        int maxV = getMax(verticalCuts, w);
        return (int) ((long) maxH * maxV % M);
    }

    private int getMax(int[] arr, int len) {
        int max = Math.max(arr[0], len - arr[arr.length - 1]);
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        return max;
    }
}