package DataStructure.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Traversals {
    /*
     * Assume we are given a adjacency list array, n nodes(Assume adjacencyList is 0 indexed)
     * How to do dfs and bfs?
     * */
    private void dfs(int n, int[][] adjacencyList) {
        if (adjacencyList == null || adjacencyList.length == 0 || adjacencyList[0].length == 0) return;
        dfsHelper(adjacencyList, 0, new boolean[n]);
    }

    private void dfsHelper(int[][] graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int child : graph[v]) {
            if (!visited[v]) dfsHelper(graph, child, visited);
        }
    }

    private void bfs(int[][] adjacencyList, int n) {
        if (adjacencyList == null || adjacencyList.length == 0 || adjacencyList[0].length == 0) return;

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int curNode = q.poll();
            for (int child : adjacencyList[curNode]) {
                if (!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                }
            }
        }
    }
}
