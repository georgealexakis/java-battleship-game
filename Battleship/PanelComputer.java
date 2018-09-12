package battleship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class PanelComputer extends JPanel {

    private int rows;
    private int cols;
    private Color backgroundColor;
    private Color lineColor;
    private JPanel[][] innerCells;
    private int[][] computerShips;
    private int[][] playerShips;
    private int[][] checkComputer;
    private int[][] checkPlayer;
    private int playerShipHits;
    private int computerShipHits;
    private String playerName;
    private Random randomNumberX;
    private Random randomNumberY;
    private PanelBoard playerBoard;
    private int k;
    private int l;
    private int stop;

    public PanelComputer(int rows, int cols, Color backgroundColor, Color lineColor, PanelBoard board, String name) {
        this.rows = rows;
        this.cols = cols;
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        randomNumberX = new Random();
        randomNumberY = new Random();

        this.k = 0;
        this.l = 0;
        this.stop = 0;
        this.playerName = name;
        this.computerShipHits = 0;
        this.playerShipHits = 0;

        playerBoard = board;
        checkComputer = new int[10][10];
        checkPlayer = new int[10][10];
        computerShips = new int[10][10];
        playerShips = new int[10][10];
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
                        if (checkPlayer[x][y] == 0 && stop == 0) {
                            shipPointPlayer(x, y);
                            shipPointComputer(randomNumberX, randomNumberY);
                            checkPlayer[x][y] = 1;
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

    public int[][] getComputerShips() {
        return computerShips;
    }

    public void setComputerShips(int[][] computerShips) {
        this.computerShips = computerShips;
    }

    public int[][] getPlayerShips() {
        return playerShips;
    }

    public void setPlayerShips(int[][] playerShips) {
        this.playerShips = playerShips;
    }

    public void shipPointPlayer(int x, int y) {
        if (computerShips[x][y] == 1) {
            innerCells[x][y].setBackground(Color.red);
            playerShipHits = playerShipHits + 1;
        } else {
            innerCells[x][y].setBackground(Color.white);
        }
        if (playerShipHits == 17) {
            stop = 1;
            Winner winner = new Winner(playerName);
            winner.setVisible(true);
        }
    }

    public void shipPointComputer(Random a, Random b) {
        do {
            k = a.nextInt(10);
            l = b.nextInt(10);
        } while (checkComputer[k][l] == 1);
        if (checkComputer[k][l] == 0) {
            if (playerShips[k][l] == 1) {
                playerBoard.innerCells[k][l].setBackground(Color.red);
                computerShipHits = computerShipHits + 1;
            } else {
                playerBoard.innerCells[k][l].setBackground(Color.white);
            }
            checkComputer[k][l] = 1;
        }
        if (computerShipHits == 17) {
            stop = 1;
            Winner winner = new Winner("Computer");
            winner.setVisible(true);
        }
    }
}
