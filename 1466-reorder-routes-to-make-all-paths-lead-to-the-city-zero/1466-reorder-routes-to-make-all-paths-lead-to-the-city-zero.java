class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] c : connections) {
            list.get(c[0]).add(c[1]);
            list.get(c[1]).add(-c[0]);
        }
        
        return solve(list, new boolean[n], 0);
    }   
    
    public int solve(List<List<Integer>> list, boolean[] used, int from) {
        int answer = 0;
        used[from] = true;
        for (Integer to : list.get(from)) {
            if (!used[Math.abs(to)]) {
                answer += solve(list, used, Math.abs(to));
                answer += (to > 0 ? 1 : 0);
            }
        }
        return answer;
    }
}