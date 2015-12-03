package mars;

import search.Action;

public enum  RoverMovement implements Action {
    //Each action is a movement up, down, right or left, and costs 1
    UP(-1, 0) {
        @Override
        public int cost() {
            return 1;
        }
    }, LEFT(0, -1) {
        @Override
        public int cost() {
            return 1;
        }
    }, DOWN(1, 0) {
        @Override
        public int cost() {
            return 1;
        }
    }, RIGHT(0, 1) {
        @Override
        public int cost() {
            return 1;
        }
    };

    public final int roverRow,roverColumn;

    private RoverMovement(int roverRow, int roverColumn) {
        this.roverRow = roverRow;
        this.roverColumn = roverColumn;
    }
}
