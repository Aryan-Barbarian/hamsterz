package core;

import actor.ZombieHamster;
import location.Grid;
import location.GridLocation2D;

import java.util.Scanner;

/**
 * Created by aryan on 6/17/2016.
 */
public class Game {

    public static final int WIN_WIDTH = 20, WIN_HEIGHT = 20;
    VisualClient displayer;
    World world;

    public void start() {

        Grid<GridLocation2D> grid = new Grid<GridLocation2D>();
        world = new World(grid);

        ZombieHamster zg1 = new ZombieHamster(this, world, grid);
        ZombieHamster zg2 = new ZombieHamster(this, world, grid);
        ZombieHamster zg3 = new ZombieHamster(this, world, grid);
        GridLocation2D loc1 = GridLocation2D.getLocation(5, 5);
        GridLocation2D loc2 = GridLocation2D.getLocation(3, 5);
        GridLocation2D loc3 = GridLocation2D.getLocation(3, 7);

        world.addMember(zg1, loc1, true);
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
//            while (numTurns > 0) {
//                numTurns--;
//                world.turn();
//                displayer.updateDisplay();
//            }
        }
        System.out.println("Exiting nicely!");
    }

}
