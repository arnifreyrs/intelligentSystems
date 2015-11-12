package search;

public class AStarFunction implements NodeFunction {

    private final NodeFunction heuristicFunction;

    public AStarFunction(NodeFunction heuristicFunction) {
        this.heuristicFunction = heuristicFunction;
    }

    @Override
    public int f(Node n) {
//        f(n) = g(n) + h(n)
        return n.path + heuristicFunction.f(n);
    }
}
