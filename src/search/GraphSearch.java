package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {

    private final Frontier frontier;
    private int len = 0;
    private final Set<State> exploredStates = new HashSet<State>();

    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    @Override
    public Node findSolution(Node rootNode, GoalTest goalTest) {
        frontier.add(rootNode);
        len++;
        while(!frontier.isEmpty()){
            Node node = frontier.remove();
            if(goalTest.isGoal(node.state)){
                return node;
            }
//            Keep track of explored states
            exploredStates.add(node.state);
            for (Action action : node.state.getApplicableActions()) {
                State newState = node.state.getActionResult(action);
                Node expandedNode = new Node(node, action, newState, node.nodeValue);

//              We want to add this node to the frontier if it is not already there and its state has yet been explored
                if(!frontier.contains(expandedNode) && !exploredStates.contains(newState)) {
                    len++;
                    frontier.add(expandedNode);
                }
            }
        }

        return null;
    }

    @Override
    public int numberOfNodes() {
        return len;
    }
}
