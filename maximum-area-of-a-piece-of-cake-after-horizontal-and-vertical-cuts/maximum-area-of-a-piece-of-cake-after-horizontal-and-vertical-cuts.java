class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = getMax(horizontalCuts, h);
        int maxV = getMax(verticalCuts, w);
        return (int) ((long) maxH * maxV % 1000000007);
    }

    private int getMax(int[] arr, int len) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        return Math.max(max, len - arr[arr.length - 1]);
    }
}