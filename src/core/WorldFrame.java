package core;

import core.World;
import location.GridLocation2D;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import actor.Actor;

/**
 * Created by Aryan on 2/20/2017.
 */
public class WorldFrame extends JFrame{
    private JPanel pnlClient;
    private JButton btnPause;
    private JButton btnIncrement;
    private JButton btnPlay;
    private JButton btnFastForward;
    private JPanel pnlWorld;
    private JList lstLog;
    private JButton btnBegin;

    // TODO: instance vars for a game
    private World world;
    public WorldFrame() {


        btnIncrement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Make one turn go forward
            }
        });

        btnBegin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
//        System.err.println("Warning, the world isn't set!");
        this.pnlClient.setVisible(true);
        this.setVisible(true);
        this.setVisible(true);
    }

    public WorldFrame(World world) {
        this();
        this.world = world;
        this.setVisible(true);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void incrementTurn() {
        if (this.world == null) {
            System.out.println("The world has not been set!");
        }
        this.world.turn();
    }

    public void updateDisplay() {
        Map<Actor, GridLocation2D> actorsToLocs = world.getDisplayInfoByMember();
    }


}
