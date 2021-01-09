package DataStructure.Graph;

public class Representations {
    /*
     * Assume we have a graph: 1 - 2 - 3 - 6 - 7
     *                                 |     /
     *                                 4 - 5
     *
     * 1 Indexed not 0 Indexed Sample -
     * Adjacency Matrix Representation:
     *   1 2 3 4 5 6 7
     * 1 F T F F F F F
     * 2 T F T F F F F
     * 3 F T F T F T F
     * 4 F F T F T F F
     * 5 F F F T F F T
     * 6 F F T F F F T
     * 7 F F F F T T F
     *
     * Arrays of Edges Representation:
     * [[1,2], [2,3], [3,6], [3,4], [4,5], [6,7], [5,7]]
     *
     * Array of Adjacency Lists:
     * [[2], [1,3], [2,6], [3,5], [4,7], [3,7], [6,5]]
     *
     * */
}
