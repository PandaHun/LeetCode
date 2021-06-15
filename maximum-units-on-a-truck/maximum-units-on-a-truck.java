class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> -a[1]));
        int ret = 0;
        for (int[] box : boxTypes) {
            if (box[0] <= truckSize) {
                ret += box[0] * box[1];
                truckSize -= box[0];
            } else {
                ret += truckSize * box[1];
                break;
            }
        }
        return ret;
    }
}