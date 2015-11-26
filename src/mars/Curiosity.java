package mars;

import search.*;

public class Curiosity {

    public static void main(String[] args){
        Planet mars = new Planet(4,4,20);
        GoalTest goalTest = new MarsGoalTest();

        NodeFunction aStarFunction = new AStarFunction(new PlanetExplorationHeuristic());

        Frontier bestFirstFrontier = new BestFirstFrontier(aStarFunction);
        generateSearch(mars, "A* graph search", bestFirstFrontier, new GraphSearch(bestFirstFrontier), goalTest);
    }

    /**
     * Utility function for generating searches, finding solutions and printing them
     * @param initialConfiguration Initial state of the Romanian Tour
     * @param title String for printing the title
     * @param frontier Breadth first or depth first search frontier
     * @param search Tree search or Graph search
     * @param goalTest am I at the goal?
     */
    private static void generateSearch(Planet initialConfiguration, String title, Frontier frontier, Search search, GoalTest goalTest) {
        System.out.println("------------------" + title + "----------------------");
        System.out.println();

        Node solution = search.findSolution(new Node(null, null, initialConfiguration, 0), goalTest);
        new PlanetPrinting().printSolution(solution);

        Planet solutionPlanet = (Planet) solution.state;

        System.out.println("Total visited squares: " + solutionPlanet.getVisitedCoordinates().size());
        System.out.println("Total number of nodes: " + search.numberOfNodes());
        System.out.println("Maximum number of nodes on the frontier: " + frontier.max());
        System.out.println();
    }
}
