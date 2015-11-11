package search;

public class IterativeDeepeningTreeSearch implements Search {

    private final DepthFirstFrontier frontier;
    private int len = 0;
    private int depth = 0;

    public IterativeDeepeningTreeSearch() {
        frontier = new DepthFirstFrontier();
    }

    @Override
    public Node findSolution(Node rootNode, GoalTest goalTest) {
//        frontier.add(rootNode);
//        len++;
//        while(!frontier.isEmpty()){
//            Node node = frontier.remove();
//            if(goalTest.isGoal(node.state)){
//                return node;
//            }
////            Expand this node and add resulting nodes to the frontier
//            for (Action action : node.state.getApplicableActions()) {
//                len++;
//                depth++;
//                State newState = node.state.getActionResult(action);
//                frontier.add(new Node(node, action, newState, depth));
//            }
//        }

        return null;
    }

    private Node checkSolution(int depth){
        return null;
    }

    @Override
    public int numberOfNodes() {
        return len;
    }
}
