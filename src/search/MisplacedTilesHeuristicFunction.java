package search;

import npuzzle.Tiles;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
    @Override
    public int f(Node n) {

        Tiles tiles = (Tiles) n.state;
        int heuristic = 0;
        int N = tiles.getWidth();
//        Find all tiles that are misplaced by comparing them to the expected value
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int expectedResult = i * N + j + 1;
                int tileValue = tiles.getTile(i,j);
                if(tileValue != 0 && tileValue != expectedResult){
                    heuristic += 1;
                }
            }
        }
        return heuristic;
    }
}
