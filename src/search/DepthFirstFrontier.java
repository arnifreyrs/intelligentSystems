package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {

//  Stack is needed for a depth first search frontier
    private Stack<Node> stack = new Stack<Node>();
    private int max = 0;

    @Override
    public void add(Node node) {
        stack.push(node);
        if(max < stack.size()) {
            max = stack.size();
        }
    }

    @Override
    public void clear() {
        while(!stack.empty()){
            stack.pop();
        }
    }

    @Override
    public boolean isEmpty() {
        return stack.empty();
    }

    @Override
    public Node remove() {
        return stack.pop();
    }

    @Override
    public int max() {
        return max;
    }

    @Override
    public boolean contains(Node node) {
        for (Node otherNode : stack) {
            if(node.state.equals(otherNode.state)){
                return true;
            }
        }

        return false;
    }
}
