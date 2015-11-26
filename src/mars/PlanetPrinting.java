package mars;

import javafx.util.Pair;
import search.Action;
import search.Printing;
import search.State;

public class PlanetPrinting extends Printing {
    public void print(Action action) {
        System.out.print("move ");
        System.out.print(((RoverMovement) action).name());
    }
    public void print(State state) {
        Planet planet=(Planet) state;
        int height = planet.height();
        int width = planet.width();
        System.out.println();
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if(planet.visitedCoordinates.contains(new Pair<Integer, Integer>(row, column))){
                    printChar('O', 1);
                } else if(planet.isAccessible(row, column)){
                    printChar(' ', 1);
                } else {
                    printChar('X', 1);
                }
            }
            System.out.println();
        }
    }
    protected static void printChar(char c, int number) {
        for (int index = 0; index < number; index++)
            System.out.print(c);
    }
}
