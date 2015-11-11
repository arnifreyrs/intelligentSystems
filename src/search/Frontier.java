package search;

public interface Frontier {

    /**
     * Add a node to the frontier
     * @param node to be added
     */
    void add(Node node);

    /**
     * clear the frontier by removing all nodes from it
     */
    void clear();

    /**
     * check if the frontier is empty
     * @return boolean
     */
    boolean isEmpty();

    /**
     * remove a node from the frontier and return it
     * @return node from the frontier
     */
    Node remove();

    /**
     * returns the maximum number of nodes stored on the frontier since the frontier was created
     * @return max number of nodes
     */
    int max();

    /**
     * Checks if a node is already on the frontier by comparing the state of the parameter node to the state of all nodes on the frontier
     * @param node to be checked
     * @return true or false
     */
    boolean contains(Node node);
}
