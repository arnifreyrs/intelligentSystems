package npuzzle;

import search.Action;
import search.Node;

public enum Movement implements Action {
	UP(-1, 0) {
		@Override
		public int cost(Node from, Action action, Node to) {
			return 1;
		}
	}, LEFT(0, -1) {
		@Override
		public int cost(Node from, Action action, Node to) {
			return 1;
		}
	}, DOWN(1, 0) {
		@Override
		public int cost(Node from, Action action, Node to) {
			return 1;
		}
	}, RIGHT(0, 1) {
		@Override
		public int cost(Node from, Action action, Node to) {
			return 1;
		}
	};

	public final int deltaRow;
	public final int deltaColumn;
	
	private Movement(int deltaRow, int deltaColumn) {
		this.deltaRow = deltaRow;
		this.deltaColumn = deltaColumn;
	}
}
