package mars;

import search.GoalTest;
import search.State;

public class MarsGoalTest implements GoalTest {
    @Override
    public boolean isGoal(State state) {
        Planet mars = (Planet) state;
        return mars.batteryLife == 0;
    }
}
