class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        int majority = 0;
        for (int key : map.keySet()) {
            int temp = map.get(key);
            if (temp >= count) {
                majority = key;
                count = temp;
            }
        }
        return majority;
    }
}