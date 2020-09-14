package battleship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelShips extends JPanel {

    private int rows;
    private int cols;
    private Color backgroundColor;
    private Color lineColor;
    private JPanel[][] innerCells;
    private int size;
    private int chooseSwitch;
    private int choose;
    public int placed;

    public PanelShips(int rows, int cols, Color backgroundColor, Color lineColor, int size) {
        this.rows = rows;
        this.cols = cols;
        this.size = size;
        this.chooseSwitch = 0;
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        this.choose = 0;
        this.placed = 0;

        innerCells = new JPanel[rows][cols];
        this.setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                innerCells[i][j] = new JPanel();
                innerCells[i][j].setLayout(new BorderLayout());
                innerCells[i][j].setBorder(BorderFactory.createLineBorder(lineColor));
                if (size > j && chooseSwitch == 0) {
                    innerCells[i][j].setBackground(backgroundColor);
                }
                innerCells[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        chooseShip();
                        chooseSwitch++;
                        if (chooseSwitch > 1) {
                            chooseSwitch = 0;
                            unchooseShip();
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                this.add(innerCells[i][j]);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public JPanel[][] getInnerCells() {
        return innerCells;
    }

    public void setInnerCells(JPanel[][] innerCells) {
        this.innerCells = innerCells;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public void setPlaced(int placed) {
        this.placed = placed;
    }

    public int getPlaced() {
        return placed;
    }

    public void chooseShip() {
        if (placed != 1) {
            choose = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < size; j++) {
                    innerCells[i][j].setBackground(Color.yellow);
                }
            }
        }
    }

    public void unchooseShip() {
        if (placed != 1) {
            choose = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < size; j++) {
                    innerCells[i][j].setBackground(Color.gray);
                }
            }
        }
    }

    public void shipPlaced() {
        placed = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                innerCells[i][j].setBackground(Color.white);
            }
        }
    }
}
