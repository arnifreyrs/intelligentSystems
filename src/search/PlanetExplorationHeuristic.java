package search;

import mars.Planet;

public class PlanetExplorationHeuristic implements NodeFunction {
    @Override
    public int f(Node n) {
        Planet planet = (Planet) n.state;
           //TODO 'arni

        return planet.getVisitedCoordinates().size() - planet.getBatteryLife();
    }
}
