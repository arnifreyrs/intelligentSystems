package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {

//    Queue is needed for a breadth first search frontier
    private Queue<Node> queue = new LinkedList<Node>();
    private int max = 0;

    @Override
    public void add(Node node) {
        queue.add(node);
        if(max < queue.size()) {
            max = queue.size();
        }
    }

    @Override
    public void clear() {
        while(!queue.isEmpty()) {
            queue.remove();
        }
    }

    @Override
    public boolean isEmpty() {
        return queue.peek() == null;
    }

    @Override
    public Node remove() {
        return queue.remove();
    }

    @Override
    public int max() {
        return max;
    }

    @Override
    public boolean contains(Node node) {
        for (Node nodeOnQueue : queue) {
            if(node.state.equals(nodeOnQueue.state)){
                return true;
            }

        }

        return false;
    }
}
