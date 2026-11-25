class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(changed);
        for (int i : changed) {
            map.merge(i, 1, Integer::sum);
        }

        int idx = 0;
        int[] answer = new int[changed.length / 2];
        for (int n : changed) {
            if (map.get(n) <= 0) {
                continue;
            }
            if (map.getOrDefault(n * 2, 0) <= 0) {
                return new int[0];
            }
            answer[idx++] = n;
            map.merge(n, -1, Integer::sum);
            map.merge(n * 2, -1, Integer::sum);
        }
        return answer;
    }
}