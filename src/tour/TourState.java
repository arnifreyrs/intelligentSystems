package tour;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class TourState implements State {
	protected final Set<City> visitedCities;
	protected final City currentCity;
	
	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}

	public int hashCode(){
        int prime = 31;
        int result = currentCity.getName().hashCode();
        for (City city : visitedCities) {
            result = prime * result + city.getName().hashCode();
        }

        return result;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        TourState other = (TourState) obj;
        if(!currentCity.getName().equals(other.currentCity.getName())){
            return false;
        }

        for (City city : visitedCities) {
            boolean otherVisitedCitiesContainsCity = false;
            for (City otherVisitedCity : other.visitedCities) {
                if(otherVisitedCity.getName().equals(city.getName())){
                    otherVisitedCitiesContainsCity = true;
                    break;
                }
            }

            if(!otherVisitedCitiesContainsCity){
                return false;
            }
        }

        return true;
    }
}
