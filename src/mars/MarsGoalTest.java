package mars;

import search.GoalTest;
import search.State;

public class MarsGoalTest implements GoalTest {
    /**
     * The goal is reached if the batterylife is 0
     * @param state a planet where we have info on the battery life
     * @return true if battery life is 0
     */
    @Override
    public boolean isGoal(State state) {
        Planet mars = (Planet) state;
        return mars.batteryLife == 0;
    }
}
