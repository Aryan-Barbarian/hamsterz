import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Aryan on 2/20/2017.
 */
public class WorldFrame {
    private JPanel pnlClient;
    private JButton btnPause;
    private JButton btnIncrement;
    private JButton btnPlay;
    private JButton btnFastForward;
    private JPanel pnlWorld;
    private JList lstLog;
    private JButton btnBegin;

    // TODO: instance vars for a game
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
    }


}
