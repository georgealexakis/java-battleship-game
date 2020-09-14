package battleship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelBoard extends JPanel {

    private int rows;
    private int cols;
    private Color backgroundColor;
    private Color lineColor;
    public JPanel[][] innerCells;
    private int[][] shipsCells;
    private int[][] shipsCodes;
    private int shipSize;
    private int rotateMark;
    private int shipCounter;
    private int shipSize5;
    private int shipSize4;
    private int shipSize3a;
    private int shipSize3b;
    private int shipSize2;
    private int sumShipsCounter;
    JButton startButton;
    PanelShips s5;
    PanelShips s4;
    PanelShips s3a;
    PanelShips s3b;
    PanelShips s2;
    private int correction;
    private int exitShipsPlcement;

    public PanelBoard(int rows, int cols, Color backgroundColor, Color lineColor, PanelShips ship5s, PanelShips ship4s, PanelShips ship3sa, PanelShips ship3sb, PanelShips ship2s, JButton button) {
        this.rows = rows;
        this.cols = cols;
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        this.rotateMark = 0;
        this.correction = 0;
        this.exitShipsPlcement = 0;

        this.shipSize = 0;
        this.shipCounter = 0;
        this.sumShipsCounter = 0;

        this.shipSize5 = 0;
        this.shipSize4 = 0;
        this.shipSize3a = 0;
        this.shipSize3b = 0;
        this.shipSize2 = 0;

        s5 = ship5s;
        s4 = ship4s;
        s3a = ship3sa;
        s3b = ship3sb;
        s2 = ship2s;
        startButton = button;

        shipsCodes = new int[rows][cols];
        shipsCells = new int[rows][cols];
        innerCells = new JPanel[rows][cols];

        this.setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                final int x = i;
                final int y = j;
                innerCells[i][j] = new JPanel();
                innerCells[i][j].setLayout(new BorderLayout());
                innerCells[i][j].setBorder(BorderFactory.createLineBorder(lineColor));
                innerCells[i][j].setBackground(backgroundColor);
                innerCells[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (s5.getChoose() == 1 && shipSize5 == 0) {
                            shipPlacement(x, y, 5);
                            s5.shipPlaced();
                            shipSize5 = 1;
                            sumShipsCounter = shipSize5 + shipSize4 + shipSize3a + shipSize3b + shipSize2;
                            if (sumShipsCounter == 5) {
                                startButton.setEnabled(true);
                            }
                        } else if (s4.getChoose() == 1 && shipSize4 == 0) {
                            shipPlacement(x, y, 4);
                            s4.shipPlaced();
                            shipSize4 = 1;
                            sumShipsCounter = shipSize5 + shipSize4 + shipSize3a + shipSize3b + shipSize2;
                            if (sumShipsCounter == 5) {
                                startButton.setEnabled(true);
                            }
                        } else if (s3a.getChoose() == 1 && shipSize3a == 0) {
                            shipPlacement(x, y, 6);
                            s3a.shipPlaced();
                            shipSize3a = 1;
                            sumShipsCounter = shipSize5 + shipSize4 + shipSize3a + shipSize3b + shipSize2;
                            if (sumShipsCounter == 5) {
                                startButton.setEnabled(true);
                            }
                        } else if (s3b.getChoose() == 1 && shipSize3b == 0) {
                            shipPlacement(x, y, 7);
                            s3b.shipPlaced();
                            shipSize3b = 1;
                            sumShipsCounter = shipSize5 + shipSize4 + shipSize3a + shipSize3b + shipSize2;
                            if (sumShipsCounter == 5) {
                                startButton.setEnabled(true);
                            }
                        } else if (s2.getChoose() == 1 && shipSize2 == 0) {
                            shipPlacement(x, y, 2);
                            s2.shipPlaced();
                            shipSize2 = 1;
                            sumShipsCounter = shipSize5 + shipSize4 + shipSize3a + shipSize3b + shipSize2;
                            if (sumShipsCounter == 5) {
                                startButton.setEnabled(true);
                            }
                        } else {
                            if (shipsCells[x][y] == 1 && exitShipsPlcement == 0) {
                                shipCorrection(shipsCodes[x][y]);
                                correction = 1;
                            }
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
                        if (s5.getChoose() == 1 && s5.getPlaced() == 0 && correction == 0) {
                            s4.unchooseShip();
                            s3a.unchooseShip();
                            s3b.unchooseShip();
                            s2.unchooseShip();
                            shipSize = 5;
                            shipFigure(x, y);
                        } else if (s4.getChoose() == 1 && s4.getPlaced() == 0 && correction == 0) {
                            s5.unchooseShip();
                            s3a.unchooseShip();
                            s3b.unchooseShip();
                            s2.unchooseShip();
                            shipSize = 4;
                            shipFigure(x, y);
                        } else if (s3a.getChoose() == 1 && s3a.getPlaced() == 0 && correction == 0) {
                            s5.unchooseShip();
                            s4.unchooseShip();
                            s3b.unchooseShip();
                            s2.unchooseShip();
                            shipSize = 3;
                            shipFigure(x, y);
                        } else if (s3b.getChoose() == 1 && s3b.getPlaced() == 0 && correction == 0) {
                            s5.unchooseShip();
                            s4.unchooseShip();
                            s3a.unchooseShip();
                            s2.unchooseShip();
                            shipSize = 3;
                            shipFigure(x, y);
                        } else if (s2.getChoose() == 1 && s2.getPlaced() == 0 && correction == 0) {
                            s5.unchooseShip();
                            s4.unchooseShip();
                            s3a.unchooseShip();
                            s3b.unchooseShip();
                            shipSize = 2;
                            shipFigure(x, y);
                        } else if (s5.getChoose() == 1 && s5.getPlaced() == 0 && correction == 1) {
                            clearBoard();
                            shipSize = 5;
                            shipFigure(x, y);
                        } else if (s4.getChoose() == 1 && s4.getPlaced() == 0 && correction == 1) {
                            clearBoard();
                            shipSize = 4;
                            shipFigure(x, y);
                        } else if (s3a.getChoose() == 1 && s3a.getPlaced() == 0 && correction == 1) {
                            clearBoard();
                            shipSize = 3;
                            shipFigure(x, y);
                        } else if (s3b.getChoose() == 1 && s3b.getPlaced() == 0 && correction == 1) {
                            clearBoard();
                            shipSize = 3;
                            shipFigure(x, y);
                        } else if (s2.getChoose() == 1 && s2.getPlaced() == 0 && correction == 1) {
                            clearBoard();
                            shipSize = 2;
                            shipFigure(x, y);
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        shipUnfigure(x, y);
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

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    public int getRotateMark() {
        return rotateMark;
    }

    public void setRotateMark(int rotateMark) {
        this.rotateMark = rotateMark;
    }

    public int[][] getShipsCells() {
        return shipsCells;
    }

    public void setShipsCells(int[][] shipsCells) {
        this.shipsCells = shipsCells;
    }

    public int getShipCounter() {
        return shipCounter;
    }

    public void setShipCounter(int shipCounter) {
        this.shipCounter = shipCounter;
    }

    public int getExitShipsPlcement() {
        return exitShipsPlcement;
    }

    public void setExitShipsPlcement(int exitShipsPlcement) {
        this.exitShipsPlcement = exitShipsPlcement;
    }

    public void shipPlacement(int x, int y, int code) {
        if (shipCounter < 17) {
            if (this.rotateMark == 0) {
                for (int i = x; i <= x; i++) {
                    for (int j = y; j < (shipSize + y) && j < 10; j++) {
                        shipCounter = shipCounter + 1;
                        shipsCells[i][j] = 1;
                        shipsCodes[i][j] = code;
                        innerCells[i][j].setBackground(Color.gray);
                    }
                }
            } else {
                for (int i = x; i < (shipSize + x) && i < 10; i++) {
                    for (int j = y; j <= y; j++) {
                        shipCounter = shipCounter + 1;
                        shipsCells[i][j] = 1;
                        shipsCodes[i][j] = code;
                        innerCells[i][j].setBackground(Color.gray);
                    }
                }
            }
        }
    }

    public void shipFigure(int x, int y) {
        if (shipCounter < 17) {
            if (this.rotateMark == 0) {
                for (int i = x; i <= x; i++) {
                    for (int j = y; j < (shipSize + y) && j < 10; j++) {
                        if (shipsCells[i][j] != 1) {
                            innerCells[i][j].setBackground(Color.green);
                        } else {
                            innerCells[i][j].setBackground(Color.red);
                        }
                    }
                }
            } else {
                for (int i = x; i < (shipSize + x) && i < 10; i++) {
                    for (int j = y; j <= y; j++) {
                        if (shipsCells[i][j] != 1) {
                            innerCells[i][j].setBackground(Color.green);
                        } else {
                            innerCells[i][j].setBackground(Color.red);
                        }
                    }
                }
            }
        }
    }

    public void shipUnfigure(int x, int y) {
        if (shipCounter < 17) {
            if (this.rotateMark == 0) {
                for (int i = x; i <= x; i++) {
                    for (int j = y; j < (shipSize + y) && j < 10; j++) {
                        if (shipsCells[i][j] != 1) {
                            innerCells[i][j].setBackground(Color.cyan);
                        } else {
                            innerCells[i][j].setBackground(Color.gray);
                        }
                    }
                }
            } else {
                for (int i = x; i < (shipSize + x) && i < 10; i++) {
                    for (int j = y; j <= y; j++) {
                        if (shipsCells[i][j] != 1) {
                            innerCells[i][j].setBackground(Color.cyan);
                        } else {
                            innerCells[i][j].setBackground(Color.gray);
                        }
                    }
                }
            }
        }
    }

    public void shipCorrection(int code) {
        switch (code) {
            case 5:
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (shipsCodes[i][j] == code) {
                            innerCells[i][j].setBackground(Color.yellow);
                            shipsCodes[i][j] = 0;
                            shipsCells[i][j] = 0;
                        }
                    }
                }
                shipCounter = shipCounter - 5;
                shipSize5 = 0;
                s5.setChoose(1);
                s5.setPlaced(0);
                break;
            case 4:
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (shipsCodes[i][j] == code) {
                            innerCells[i][j].setBackground(Color.yellow);
                            shipsCodes[i][j] = 0;
                            shipsCells[i][j] = 0;
                        }
                    }
                }
                shipCounter = shipCounter - 4;
                shipSize4 = 0;
                s4.setChoose(1);
                s4.setPlaced(0);
                break;
            case 6:
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (shipsCodes[i][j] == code) {
                            innerCells[i][j].setBackground(Color.yellow);
                            shipsCodes[i][j] = 0;
                            shipsCells[i][j] = 0;
                        }
                    }
                }
                shipCounter = shipCounter - 3;
                shipSize3a = 0;
                s3a.setChoose(1);
                s3a.setPlaced(0);
                break;
            case 7:
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (shipsCodes[i][j] == code) {
                            innerCells[i][j].setBackground(Color.yellow);
                            shipsCodes[i][j] = 0;
                            shipsCells[i][j] = 0;
                        }
                    }
                }
                shipCounter = shipCounter - 3;
                shipSize3b = 0;
                s3b.setChoose(1);
                s3b.setPlaced(0);
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (shipsCodes[i][j] == code) {
                            innerCells[i][j].setBackground(Color.yellow);
                            shipsCodes[i][j] = 0;
                            shipsCells[i][j] = 0;
                        }
                    }
                }
                shipCounter = shipCounter - 2;
                shipSize2 = 0;
                s2.setChoose(1);
                s2.setPlaced(0);
                break;
        }
    }

    public void clearBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (shipsCells[i][j] == 0) {
                    innerCells[i][j].setBackground(Color.cyan);
                }
            }
        }
    }
}
