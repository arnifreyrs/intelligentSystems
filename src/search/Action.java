package search;

public interface Action {

    public int cost(Node from, Action action, Node to);
}
