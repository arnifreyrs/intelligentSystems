package mars;

import javafx.util.Pair;
import search.Action;
import search.State;

import java.util.*;

public class Planet implements State {

    private final int[][] accessible = new int[][] {
        {1,1,1,1,0,1,1,1},
        {1,1,0,0,0,0,0,1},
        {1,0,1,0,1,0,1,1},
        {0,0,1,1,1,0,0,0},
        {1,0,0,1,0,1,0,1},
        {1,1,0,0,0,1,0,1},
        {1,1,1,0,0,0,0,1},
        {1,1,1,1,0,1,1,1},
     };

    protected final int initialRow;
    protected final int initialColumn;
    protected final Set<Pair<Integer, Integer>> visitedCoordinates;
    protected final int batteryLife;

    public Planet(int initialRow, int initialColumn, int batteryLife) {
        this.initialRow = initialRow;
        this.initialColumn = initialColumn;
        this.batteryLife = batteryLife;

        visitedCoordinates = new LinkedHashSet<Pair<Integer, Integer>>();
        visitedCoordinates.add(new Pair<Integer, Integer>(initialRow, initialColumn));
    }

    public Planet(Set<Pair<Integer, Integer>> visitedCoordinates, int initialRow, int initialColumn, int batteryLife) {
        this.visitedCoordinates = visitedCoordinates;
        this.initialRow = initialRow;
        this.initialColumn = initialColumn;
        this.batteryLife = batteryLife;
    }

    public boolean isAccessible(int x, int y) {
        int offx = x+0; int offy = y+0;
        if (offx>=0 && offy>=0 && offx<accessible.length && offy<accessible[0].length) return (accessible[offx][offy]==0);
        else return false;
    }
    
    public int height() {return accessible.length;}
    public int width() {return accessible[0].length;}
    public int getBatteryLife() {return batteryLife;}
    public Set<Pair<Integer, Integer>> getVisitedCoordinates() {
        return visitedCoordinates;
    }

    @Override
    public Set<RoverMovement> getApplicableActions() {
        Set<RoverMovement> actions = new LinkedHashSet<RoverMovement>();
        for (RoverMovement movement : RoverMovement.values()) {
            int newRow = initialRow + movement.roverRow;
            int newColumn = initialColumn + movement.roverColumn;
            if(isAccessible(newRow, newColumn)){
                actions.add(movement);
            }
        }
        return actions;
    }

    @Override
    public State getActionResult(Action action) {
        RoverMovement movement=(RoverMovement)action;
        int newRow = initialRow + movement.roverRow;
        int newColumn = initialColumn + movement.roverColumn;
        Set<Pair<Integer,Integer>> newVisitedCoordinates = new LinkedHashSet<Pair<Integer, Integer>>(visitedCoordinates);
        newVisitedCoordinates.add(new Pair<Integer, Integer>(newRow, newColumn));
        return new Planet(newVisitedCoordinates, newRow, newColumn, batteryLife - 1);
    }

    public int hashCode(){
        int prime = 31;
        int result = initialColumn + prime * initialRow;
        for (Pair<Integer, Integer> visitedCoordinate : visitedCoordinates) {
            result = result*prime + visitedCoordinate.hashCode();
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
        final Planet other = (Planet) obj;
        if(other.initialColumn != initialColumn){
            return false;
        }
        if(other.initialRow != initialRow){
            return false;
        }

        if(visitedCoordinates.hashCode() != other.visitedCoordinates.hashCode()){
            return false;
        }

        if(other.width() != width() || other.height() != height()){
            return false;
        }

        for(int i = 0; i < width(); i ++){
            for(int j = 0; j < height(); j ++){
                if(this.isAccessible(i,j) != other.isAccessible(i,j)){
                    return false;
                }
            }
        }

        return true;
    }
}
