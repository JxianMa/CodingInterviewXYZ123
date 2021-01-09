package DataStructure.Graph;

// Usage of Topological Sort
// 1. Detect if there is a cycle in a directed graph
// 2. Find a full path that's in topological order from the graph
// Sample Problems: Course Schedule, Course Schedule II

// Data structures
// 1. Present a graph using adjacency list, with edges -> in order to calculate original indegrees
// 2. Maintain a data structure to track each node's number of indegrees
// 3. Use a queue to do a BFS like operation, instead of pushing all neighbor nodes, we only push neighbors with 0 indegree
// 4. Maintain a variable cnt to represent number of visited nodes

// Algorithm:
// 1. Push all 0 indegree nodes to queue first
// 2. Poping nodes out from the queue
// 3. Each time when we pop, we can increment cnt by 1, then check all poped node's neighbors
// 4. For each neighbor, decrease its indegree by 1, if the indegree drops down to 0, push that neighbor to queue
// 5. Repeat step 2 to step 4 until queue is empty

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// Result:
// 1. If cnt is less than number of nodes, then we have a cycle within the graph
// 2. We can print a list of nodes which follows topological sort order, this list is one of the list that follows topological order
public class TopologicalSort {

    // Example: Detect cycle in a directed graph
    // Edge has representations like [1,2] which means 1 -> 2
    private boolean hasCycle(int n, int[][] edges) {
        // input validation
        if (n <= 0) return false;

        // initializations
        int[] indegrees = new int[n];
        List<Integer>[] adjList = constructAdjList(n, edges, indegrees);
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curNode = q.poll();
            cnt++;
            for (int neighbor : adjList[curNode]) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return cnt == n;
    }

    private List<Integer>[] constructAdjList(int n, int[][] edges, int[] indegrees) {
        List<Integer>[] ret = new ArrayList[n];
        for (int i = 0; i < n; i++) ret[i] = new ArrayList<>();
        for (int[] e : edges) {
            int src = e[0], dest = e[1];
            indegrees[dest]++;
            ret[src].add(dest);
        }
        return ret;
    }
}
