package search;

import mars.Planet;

public class PlanetExplorationHeuristic implements NodeFunction {
    /**
     * Heuristic which is the difference of total accessible places and already visited places
     * @param n a Node object that has access to the planet state and already visited places
     * @return {Int} the difference of total accessible places and already visited places
     */
    @Override
    public int f(Node n) {
        Planet planet = (Planet) n.state;
        int accessiblePlaces = 0;
        int width = planet.width();
        int height = planet.height();
        for(int x = 0; x < width; x++){
            for(int y = 0; y< height; y++){
                if(planet.isAccessible(x,y)){
                    accessiblePlaces += 1;
                }
            }
        }


        return accessiblePlaces - planet.getVisitedCoordinates().size();
    }
}
