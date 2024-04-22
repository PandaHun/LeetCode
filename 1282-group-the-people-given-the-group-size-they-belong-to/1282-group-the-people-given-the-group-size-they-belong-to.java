class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> answer = new ArrayList<>();
        
        Map<Integer, List<Integer>> group = new HashMap<>();
        for (int i = 0 ; i < groupSizes.length; i++) {
            if (!group.containsKey(groupSizes[i])) {
                group.put(groupSizes[i], new ArrayList<>());
            }
            
            List<Integer> temp = group.get(groupSizes[i]);
            temp.add(i);
            
            if (temp.size() == groupSizes[i]) {
                answer.add(temp);
                group.remove(groupSizes[i]);
            }
        }
        return answer;
    }
}