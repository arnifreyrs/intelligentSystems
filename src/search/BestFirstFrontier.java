package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {

    private final PriorityQueue<Node> queue;
    private final NodeFunction nodeFunction;
    private int max = 0;

    public BestFirstFrontier(NodeFunction nodeFunction) {
        this.queue = new PriorityQueue<Node>(128, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.nodeValue - o2.nodeValue;
            }
        });
        this.nodeFunction = nodeFunction;
    }

    @Override
    public void add(Node node) {
        node.nodeValue = nodeFunction.f(node);
        queue.add(node);
        if(max < queue.size()) {
            max = queue.size();
        }
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
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
