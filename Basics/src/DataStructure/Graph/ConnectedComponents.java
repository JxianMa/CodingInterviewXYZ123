package DataStructure.Graph;

public class ConnectedComponents {

    private int[] id;
    private int count;

    private int countOfComponents(int[][] graph, int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] graph, int s, boolean[] visited) {
        visited[s] = true;
        id[s] = count;
        for (int child : graph[s]) {
            if (!visited[child]) dfs(graph, child, visited);
        }
    }

    private boolean hasOnlyOneComponent(int[][] graph, int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count == 1;
    }
}
