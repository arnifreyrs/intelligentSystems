package search;

public class TreeSearch implements Search {

    private final Frontier frontier;
    private int len = 0;

    public TreeSearch(Frontier frontier) {
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
//            Expand this node and add resulting nodes to the frontier
            for (Action action : node.state.getApplicableActions()) {
                len++;
                State newState = node.state.getActionResult(action);
                frontier.add(new Node(node, action, newState, node.nodeValue));
            }

        }
        return null;
    }

    @Override
    public int numberOfNodes() {
        return len;
    }
}
