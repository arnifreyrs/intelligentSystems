package search;

public interface Search {

    /**
     * returns a node containing a solution or null if no solution can be found.
     * @param rootNode root of the search
     * @param goalTest test for the goal
     * @return solution node or null
     */
    Node findSolution(Node rootNode, GoalTest goalTest);

    /**
     * returns the number of nodes generated during the last search
     * @return number of nodes
     */
    int numberOfNodes();

}
