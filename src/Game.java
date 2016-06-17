import location.Grid;
import location.GridLocation2D;

import java.util.Scanner;

/**
 * Created by aryan on 6/17/2016.
 */
public class Game {

    Displayer displayer;
    World world;

    public void start() {
        displayer = new Displayer();
        Grid<GridLocation2D> grid = new Grid<GridLocation2D>();
        world = new World(grid);

        ZombieGerbil zg1 = new ZombieGerbil(this, world, grid);
        ZombieGerbil zg2 = new ZombieGerbil(this, world, grid);
        ZombieGerbil zg3 = new ZombieGerbil(this, world, grid);
        GridLocation2D loc1 = GridLocation2D.getLocation(5, 5);
        GridLocation2D loc2 = GridLocation2D.getLocation(3, 5);
        GridLocation2D loc3 = GridLocation2D.getLocation(3, 7);

        world.addMember(zg1, loc1, true);
        world.addMember(zg2, loc1, true);
        world.addMember(zg3, loc1, true);

    }

    public void run() {
        Scanner reader = new Scanner(System.in);
        boolean shouldRun = true;
        while (shouldRun) {
            System.out.println("How many turns to run? (-1 for exit)");
            int numTurns = reader.nextInt();
            if (numTurns == -1) {
                shouldRun = false;
            }
            while (numTurns > 0) {
                numTurns--;
                updateGame();
                updateDisplay();
            }
        }
        System.out.println("Exiting nicely!");
    }

    public void stop() {

    }

    public void updateGame() {

    }

    public void updateDisplay() {

    }
}
