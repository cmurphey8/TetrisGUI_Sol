/**************************************************************************************************
 *
 *  Class to draw the sidePane that houses the next block and the score
 *  CALLED BY: View.java
 *  
 *  TODO: 
 *  (1) choose a Layout Manager to nest (add) here in SidePane
 *  (2) choose GUI element to house text “SCORE:”
 *  (3) choose GUI element to display score
 * 
 **************************************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SidePane extends JPanel {

    public SidePane(Shape next, long score) {
        // SidePane layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // next block color grid
        Color[][] nextC = new Color[4][6];
        double[] x = next.getX();
        double[] y = next.getY();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                nextC[i][j] = Color.BLACK;
            }
        }
        for (int j = 0; j < 4; j++) {
            nextC[3 - (int) y[j]][(int) x[j]] = next.getC();
        }

        // next block grid init & add
        GridPane panel = new GridPane(nextC, 6, 4);
        add(panel);

        /* TODO: 
            (1) choose a Layout Manager to nest (add) here in SidePane
            (2) choose GUI element to house text “SCORE:”
            (3) choose GUI element to display score
        */

        // score panel init
        JPanel scorePanel = new JPanel();

        // score panel layout
        scorePanel.setLayout(new BorderLayout());
        scorePanel.setBackground(Color.BLACK);
        
        // label to display score var
        JLabel scoreDisp = new JLabel(String.valueOf(score));
        scoreDisp.setFont(new Font(scoreDisp.getFont().getName(), Font.PLAIN, 20));
        
        scoreDisp.setForeground(Color.CYAN);
        scoreDisp.setHorizontalAlignment(SwingConstants.CENTER);
        scoreDisp.setBorder(new LineBorder(Color.CYAN, 3, true));

        // add score var label to sub-panel scorePanel
        scorePanel.add(scoreDisp, BorderLayout.CENTER);

        // label to display score title
        JLabel textDisp = new JLabel("SCORE");
        textDisp.setFont(new Font(textDisp.getFont().getName(), Font.PLAIN, 20));
        textDisp.setForeground(Color.ORANGE);
        textDisp.setPreferredSize(new Dimension(10,100));
        textDisp.setVerticalAlignment(SwingConstants.CENTER);
        textDisp.setHorizontalAlignment(SwingConstants.CENTER);
        textDisp.setBorder(new LineBorder(Color.CYAN, 3, true));
        scorePanel.add(textDisp, BorderLayout.NORTH);
        
        // add score title label to sub-panel scorePanel
        add(scorePanel);
    }
}