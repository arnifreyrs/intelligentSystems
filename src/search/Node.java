package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int nodeValue = 0;
	public int path = 0;


	public Node(Node parent, Action action, State state, int nodeValue){
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.nodeValue = nodeValue;
		if(parent == null){
			path = 0;
		} else {
			path = parent.path + action.cost();
		}
	}

}
