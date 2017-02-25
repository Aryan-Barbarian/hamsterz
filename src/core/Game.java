package core;

import actor.Hamster;
import location.Grid;
import location.GridLocation2D;

import java.util.Scanner;

/**
 * Created by aryan on 6/17/2016.
 */
public class Game {

    public static final int WIN_WIDTH = 20, WIN_HEIGHT = 20;
    VisualClient displayer; // TODO: figure out the organization of Game, World, VisualClient and who contains whom.
    World world;

    public void start() {

        Grid<GridLocation2D> grid = new Grid<GridLocation2D>();
        world = new World(grid);

        Hamster zg1 = new Hamster(world, grid);
        Hamster zg2 = new Hamster(world, grid);
        Hamster zg3 = new Hamster(world, grid);
        // TODO: Fix this nonesense with the different locations
        GridLocation2D loc1 = GridLocation2D.getLocation(5, 5);
        GridLocation2D loc2 = GridLocation2D.getLocation(3, 5);
        GridLocation2D loc3 = GridLocation2D.getLocation(3, 7);

        world.addMember(zg1, loc1, true); // TODO: shouldn't have to deal with canMove
        world.addMember(zg2, loc1, true);
        world.addMember(zg3, loc1, true);

//        displayer = new Displayer(world, WIN_WIDTH, WIN_HEIGHT);
        displayer = new VisualClient(world);
        System.out.println("Let's goooo");
        run();
    }

    public void turn() {
        world.turn();
    }

    public void run() {
        Scanner reader = new Scanner(System.in);
        boolean shouldRun = true;
        while (shouldRun) {
            System.out.println("How many turns to run? (-1 for exit)");
            int numTurns = reader.nextInt();
            if (numTurns < 0) {
                shouldRun = false;
            }
            while (numTurns > 0) {
                numTurns--;
                world.turn();
//                displayer.updateDisplay();
            }
        }
        System.out.println("Exiting nicely!");
    }

}
