class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String convert = String.valueOf(arr);
            map.putIfAbsent(convert, new ArrayList<>());
            map.get(convert).add(str);
        }
        return new ArrayList<>(map.values());
    }
}