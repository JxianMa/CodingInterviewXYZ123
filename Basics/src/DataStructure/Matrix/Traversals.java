package DataStructure.Matrix;

// [0,1,2,3,4,5
//  6,7,8,9,8,7
//  2,3,4,5,0,1
//  3,5,7,9,1,4
//  2,4,6,8,6,2]
//A matrix can present a status pattern with M*N items involved.
//        Usually there can be problems in the following variations:
//        1. Giving certain matrix pattern with limited matrix size,then ask state transition after few steps - DFS or BFS
//        2. Giving a really big matrix,then ask to traverse thru the matrix to find some elements or count --- DFS or BFS
//        3. Giving a limited sized matrix, try to find the shortest distance between two elements ------------ BFS
//        4. Finding connected components in a matrix --------------------------------------------------------- DFS

import java.util.*;

public class Traversals {
    // BFS and DFS always starts from one element, trying to traverse the whole matrix
    // Sequential traversal always traverse thru every element in the matrix

    // Here we assume the traversal directions are top-right-down-left
    private int[][] directions = {
            {-1, 0}, // top
            {0, 1}, // right
            {1, 0}, // down
            {0, -1} // left
    };

    public int[] bfs(int[][] matrix, int startX, int startY) {
        // input validation
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        // initialization
        int n = matrix.length, m = matrix[0].length;
        int[] ret = new int[n * m];
        int retIdx = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int curLvlSize = q.size();
            for (int i = 0; i < curLvlSize; i++) {
                int[] curNode = q.poll();
                int curX = curNode[0], curY = curNode[1];
                ret[retIdx++] = matrix[curX][curY];
                for (int[] dire : directions) {
                    int nextX = dire[0] + curX, nextY = dire[1] + curY;
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return ret;
    }

    public void dfs(int[][] matrix, int startX, int startY, boolean[][] visited, List<Integer> ret) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        visited[startX][startY] = true;
        ret.add(matrix[startX][startY]);

        for (int[] dire : directions) {
            int nextX = startX + dire[0], nextY = startY + dire[1];
            if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && !visited[nextX][nextY]) {
                dfs(matrix, nextX, nextY, visited, ret);
            }
        }

        // if dfs in other directions will test the same path with different values, we need to set visited[startX][startY] = false
        // after all directions dfs, otherwise same paths won't get revisited again even if there's possibly new values
    }

    public static void main(String[] args) {
        System.out.println("Matrix DFS and BFS Traversal Test Client is Running...");
        int[][] test1 = {
                {0, 1, 2, 3, 4, 5},
                {6, 7, 8, 9, 8, 7},
                {2, 3, 4, 5, 0, 1},
                {3, 5, 7, 9, 1, 4},
                {2, 4, 6, 8, 6, 2}
        };
        System.out.println("Input matrix1 is:  ");
        for (int[] row : test1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        Traversals matrixTraversals = new Traversals();
        int[] bfsRet1 = matrixTraversals.bfs(test1, 0, 0);
        System.out.println("BFS result1 is: " + Arrays.toString(bfsRet1));

        List<Integer> dfsRet1 = new ArrayList<>();
        matrixTraversals.dfs(test1, 0, 0, new boolean[test1.length][test1[0].length], dfsRet1);
        System.out.println("DFS result1 is: " + Arrays.toString(dfsRet1.toArray(new Integer[dfsRet1.size()])));


        int[][] test2 = {
                {0},
                {1},
                {2},
                {3}
        };
        System.out.println("Input matrix2 is:  ");
        for (int[] row : test2) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        int[] bfsRet2 = matrixTraversals.bfs(test2, 0, 0);
        System.out.println("BFS result2 is: " + Arrays.toString(bfsRet2));

        List<Integer> dfsRet2 = new ArrayList<>();
        matrixTraversals.dfs(test2, 0, 0, new boolean[test2.length][test2[0].length], dfsRet2);
        System.out.println("DFS result2 is: " + Arrays.toString(dfsRet2.toArray(new Integer[dfsRet2.size()])));


        int[][] test3 = {
                {0, 1, 2, 3, 4, 5},
        };
        System.out.println("Input matrix3 is:  ");
        for (int[] row : test3) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        int[] bfsRet3 = matrixTraversals.bfs(test3, 0, 0);
        System.out.println("BFS result3 is: " + Arrays.toString(bfsRet3));

        List<Integer> dfsRet3 = new ArrayList<>();
        matrixTraversals.dfs(test3, 0, 0, new boolean[test3.length][test3[0].length], dfsRet3);
        System.out.println("DFS result3 is: " + Arrays.toString(dfsRet3.toArray(new Integer[dfsRet3.size()])));
    }
}
