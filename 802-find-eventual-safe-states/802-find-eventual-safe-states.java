class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> answer = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return null;
        }
        int n = graph.length;
        int[] visit = new int[n];
        for (int i = 0; i < n; i ++) {
            if (dfs(graph, i, visit)) {
                answer.add(i);
            }
        }
        return answer;
    }
    
    boolean dfs(int[][] graph, int start, int[] visit) {
        if (visit[start] != 0) {
            return visit[start] == 1;
        }
        visit[start] = 2;
        for (int node : graph[start]) {
            if (!dfs(graph, node, visit)) {
                return false;
            }
        }
        visit[start] = 1;
        return true;
    }
}