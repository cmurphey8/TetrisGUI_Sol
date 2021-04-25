/**************************************************************************************************
 *
 *  JPanel extension Class with a GridBagLayout to house (gridY x gridX) Cell objects
 *  NOTE: Cells represent the bakcground (black) and tetroid (color[row][col]) blocks!
 *  CALLED BY: View.java & SidePane.java
 **************************************************************************************************/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GridPane extends JPanel {

    public GridPane(Color[][] color, int gridX, int gridY) {

        Border border = new LineBorder(Color.CYAN, 3, true);
        setBorder(border);
        setBackground(Color.DARK_GRAY);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < gridY; row++) {
            for (int col = 0; col < gridX; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                Color pass = (color[row][col] == null)? Color.BLACK : color[row][col];
                add(new Cell(pass), gbc);
            }
        }
    }
}