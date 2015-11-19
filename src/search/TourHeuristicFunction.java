package search;

import tour.Road;
import tour.TourState;

public class TourHeuristicFunction implements NodeFunction {
    public TourHeuristicFunction() {

    }

    @Override
    public int f(Node n) {
        TourState state = (TourState) n.state;
        for (Road road : state.getApplicableActions()) {

        }

        return 0;
    }
}
