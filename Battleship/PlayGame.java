package battleship;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class PlayGame extends JFrame {

    JPanel panelPlayer;
    JPanel panelComputer;
    JPanel panelPLabel;
    JPanel panelCLabel;
    PanelBoard player;
    PanelComputer computer;
    GridLayout gridLayout;
    JLabel playerName;
    JLabel computerLabel;
    private int[][] computerShips;
    private Random a;
    private Random b;
    private Random c;
    private Random d;
    private Random e;
    private Random k;
    private Random l;
    private Random m;
    private Random n;
    private Random o;
    private int randomShip5sX;
    private int randomShip5sY;
    private int randomShip4sX;
    private int randomShip4sY;
    private int randomShip3saX;
    private int randomShip3saY;
    private int randomShip3sbX;
    private int randomShip3sbY;
    private int randomShip2sX;
    private int randomShip2sY;
    private Random rotateShip5;
    private Random rotateShip4;
    private Random rotateShip3a;
    private Random rotateShip3b;
    private Random rotateShip2;
    private Random randomSeed;
    private int seed;
    private int rotS5;
    private int rotS4;
    private int rotS3a;
    private int rotS3b;
    private int rotS2;

    public PlayGame(String name, PanelBoard board) {
        this.setSize(800, 550);
        this.setTitle("Battleship - Play game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        computerShips = new int[10][10];

        panelPlayer = new JPanel(null);
        panelComputer = new JPanel(null);
        panelPLabel = new JPanel();
        panelCLabel = new JPanel();

        randomSeed = new Random();
        seed = randomSeed.nextInt(4);

        a = new Random();
        b = new Random();
        c = new Random();
        d = new Random();
        e = new Random();

        k = new Random();
        l = new Random();
        m = new Random();
        n = new Random();
        o = new Random();

        rotateShip5 = new Random();
        rotateShip4 = new Random();
        rotateShip3a = new Random();
        rotateShip3b = new Random();
        rotateShip2 = new Random();

        randomShip5sX = a.nextInt(5);
        randomShip5sY = b.nextInt(5);
        randomShip3sbX = e.nextInt(5);
        randomShip3sbY = k.nextInt(5);
        randomShip2sX = n.nextInt(5);
        randomShip2sY = o.nextInt(5);

        rotS5 = rotateShip5.nextInt(2);
        rotS4 = rotateShip4.nextInt(2);
        rotS3a = rotateShip3a.nextInt(2);
        rotS3b = rotateShip3b.nextInt(2);
        rotS2 = rotateShip2.nextInt(2);

        gridLayout = new GridLayout();
        this.setLayout(gridLayout);

        playerName = new JLabel(name + " board");
        player = board;
        computerLabel = new JLabel("Computer's board");
        computer = new PanelComputer(10, 10, Color.cyan, Color.black, board, name);

        panelPLabel.setSize(150, 50);
        panelPLabel.setLocation(120, 80);
        player.setSize(350, 350);
        player.setLocation(20, 100);

        panelCLabel.setSize(150, 50);
        panelCLabel.setLocation(120, 80);
        computer.setSize(350, 350);
        computer.setLocation(20, 100);

        panelPlayer.add(player);
        panelPlayer.add(panelPLabel);
        panelPLabel.add(playerName);

        panelComputer.add(computer);
        panelComputer.add(panelCLabel);
        panelCLabel.add(computerLabel);

        this.add(panelPlayer);
        this.add(panelComputer);

        switch (seed) {
            case 0:
                if (rotS5 == 0) {
                    for (int i = randomShip5sX; i < (randomShip5sX + 1); i++) {
                        for (int j = 0; j < 5; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    for (int j = randomShip5sY; j < (randomShip5sY + 1); j++) {
                        for (int i = 0; i < 5; i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS4 == 0) {
                    do {
                        randomShip4sX = c.nextInt(5);
                        randomShip4sY = d.nextInt(5);
                    } while (randomShip4sY + 4 >= 5);
                    for (int i = randomShip4sX; i < (randomShip4sX + 1); i++) {
                        for (int j = (randomShip4sY + 5); j < (randomShip4sY + 9); j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip4sX = c.nextInt(5);
                        randomShip4sY = d.nextInt(5);
                    } while ((randomShip4sX + 4) >= 5);
                    for (int j = (randomShip4sY + 5); j < (randomShip4sY + 6); j++) {
                        for (int i = randomShip4sX; i < (randomShip4sX + 4); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS3a == 0) {
                    do {
                        randomShip3saX = l.nextInt(5);
                        randomShip3saY = m.nextInt(5);
                    } while (randomShip3saY + 3 >= 5);
                    for (int i = (randomShip3saX + 5); i < (randomShip3saX + 6); i++) {
                        for (int j = randomShip3saY; j < (randomShip3saY + 3); j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip3saX = l.nextInt(5);
                        randomShip3saY = m.nextInt(5);
                    } while ((randomShip3saX + 3) >= 5);
                    for (int j = randomShip3saY; j < (randomShip3saY + 1); j++) {
                        for (int i = (randomShip3saX + 5); i < (randomShip3saX + 8); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS3b == 0) {
                    randomShip3sbY = 0;
                    for (int i = (randomShip3sbX + 5); i < (randomShip3sbX + 6); i++) {
                        for (int j = (randomShip3sbY + 5); j < 8; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip3sbX = e.nextInt(5);
                    } while ((randomShip3sbX + 3) >= 5);
                    do {
                        randomShip3sbY = k.nextInt(5);
                    } while (randomShip3sbY >= 3);
                    for (int j = (randomShip3sbY + 5); j < (randomShip3sbY + 6); j++) {
                        for (int i = (randomShip3sbX + 5); i < (randomShip3sbX + 8); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS2 == 0) {
                    randomShip2sY = 0;
                    for (int i = (randomShip2sX + 5); i < (randomShip2sX + 6); i++) {
                        for (int j = (randomShip2sY + 8); j < 10; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip2sX = n.nextInt(5);
                    } while ((randomShip2sX + 3) >= 5);
                    do {
                        randomShip2sY = o.nextInt(5);
                    } while (randomShip2sY >= 2);
                    for (int j = (randomShip2sY + 8); j < (randomShip2sY + 9); j++) {
                        for (int i = (randomShip2sX + 5); i < (randomShip2sX + 7); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                break;
            case 1:
                if (rotS5 == 0) {
                    for (int i = randomShip5sX; i < (randomShip5sX + 1); i++) {
                        for (int j = 5; j < 10; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    for (int j = (randomShip5sY + 5); j < (randomShip5sY + 6); j++) {
                        for (int i = 0; i < 5; i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS4 == 0) {
                    do {
                        randomShip4sX = c.nextInt(5);
                        randomShip4sY = d.nextInt(5);
                    } while (randomShip4sY + 4 >= 5);
                    for (int i = randomShip4sX; i < (randomShip4sX + 1); i++) {
                        for (int j = randomShip4sY; j < (randomShip4sY + 4); j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip4sX = c.nextInt(5);
                        randomShip4sY = d.nextInt(5);
                    } while ((randomShip4sX + 4) >= 5);
                    for (int j = randomShip4sY; j < (randomShip4sY + 1); j++) {
                        for (int i = randomShip4sX; i < (randomShip4sX + 4); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS3a == 0) {
                    do {
                        randomShip3saX = l.nextInt(5);
                        randomShip3saY = m.nextInt(5);
                    } while (randomShip3saY + 3 >= 5);
                    for (int i = (randomShip3saX + 5); i < (randomShip3saX + 6); i++) {
                        for (int j = (randomShip3saY + 5); j < (randomShip3saY + 8); j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip3saX = l.nextInt(5);
                        randomShip3saY = m.nextInt(5);
                    } while ((randomShip3saX + 3) >= 5);
                    for (int j = (randomShip3saY + 5); j < (randomShip3saY + 6); j++) {
                        for (int i = (randomShip3saX + 5); i < (randomShip3saX + 8); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS3b == 0) {
                    randomShip3sbY = 0;
                    for (int i = (randomShip3sbX + 5); i < (randomShip3sbX + 6); i++) {
                        for (int j = randomShip3sbY; j < 3; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip3sbX = e.nextInt(5);
                    } while ((randomShip3sbX + 3) >= 5);
                    do {
                        randomShip3sbY = k.nextInt(5);
                    } while (randomShip3sbY >= 3);
                    for (int j = randomShip3sbY; j < (randomShip3sbY + 1); j++) {
                        for (int i = (randomShip3sbX + 5); i < (randomShip3sbX + 8); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS2 == 0) {
                    randomShip2sY = 0;
                    for (int i = (randomShip2sX + 5); i < (randomShip2sX + 6); i++) {
                        for (int j = (randomShip2sY + 3); j < 5; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip2sX = n.nextInt(5);
                    } while ((randomShip2sX + 3) >= 5);
                    do {
                        randomShip2sY = o.nextInt(5);
                    } while (randomShip2sY >= 2);
                    for (int j = (randomShip2sY + 3); j < (randomShip2sY + 4); j++) {
                        for (int i = (randomShip2sX + 5); i < (randomShip2sX + 7); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                break;
            case 2:
                if (rotS5 == 0) {
                    for (int i = (randomShip5sX + 5); i < (randomShip5sX + 6); i++) {
                        for (int j = 0; j < 5; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    for (int j = randomShip5sY; j < (randomShip5sY + 1); j++) {
                        for (int i = 5; i < 10; i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS4 == 0) {
                    do {
                        randomShip4sX = c.nextInt(5);
                        randomShip4sY = d.nextInt(5);
                    } while (randomShip4sY + 4 >= 5);
                    for (int i = (randomShip4sX + 5); i < (randomShip4sX + 6); i++) {
                        for (int j = (randomShip4sY + 5); j < (randomShip4sY + 9); j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip4sX = c.nextInt(5);
                        randomShip4sY = d.nextInt(5);
                    } while ((randomShip4sX + 4) >= 5);
                    for (int j = (randomShip4sY + 5); j < (randomShip4sY + 6); j++) {
                        for (int i = (randomShip4sX + 5); i < (randomShip4sX + 9); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS3a == 0) {
                    do {
                        randomShip3saX = l.nextInt(5);
                        randomShip3saY = m.nextInt(5);
                    } while (randomShip3saY + 3 >= 5);
                    for (int i = randomShip3saX; i < (randomShip3saX + 1); i++) {
                        for (int j = randomShip3saY; j < (randomShip3saY + 3); j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip3saX = l.nextInt(5);
                        randomShip3saY = m.nextInt(5);
                    } while ((randomShip3saX + 3) >= 5);
                    for (int j = randomShip3saY; j < (randomShip3saY + 1); j++) {
                        for (int i = randomShip3saX; i < (randomShip3saX + 3); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS3b == 0) {
                    randomShip3sbY = 0;
                    for (int i = randomShip3sbX; i < (randomShip3sbX + 1); i++) {
                        for (int j = (randomShip3sbY + 5); j < 8; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip3sbX = e.nextInt(5);
                    } while ((randomShip3sbX + 3) >= 5);
                    do {
                        randomShip3sbY = k.nextInt(5);
                    } while (randomShip3sbY >= 3);
                    for (int j = (randomShip3sbY + 5); j < (randomShip3sbY + 6); j++) {
                        for (int i = randomShip3sbX; i < (randomShip3sbX + 3); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS2 == 0) {
                    randomShip2sY = 0;
                    for (int i = randomShip2sX; i < (randomShip2sX + 1); i++) {
                        for (int j = (randomShip2sY + 8); j < 10; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip2sX = n.nextInt(5);
                    } while ((randomShip2sX + 3) >= 5);
                    do {
                        randomShip2sY = o.nextInt(5);
                    } while (randomShip2sY >= 2);
                    for (int j = (randomShip2sY + 8); j < (randomShip2sY + 9); j++) {
                        for (int i = randomShip2sX; i < (randomShip2sX + 2); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                break;
            case 3:
                if (rotS5 == 0) {
                    for (int i = (randomShip5sX + 5); i < (randomShip5sX + 6); i++) {
                        for (int j = 5; j < 10; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    for (int j = randomShip5sY + 5; j < (randomShip5sY + 6); j++) {
                        for (int i = 5; i < 10; i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS4 == 0) {
                    do {
                        randomShip4sX = c.nextInt(5);
                        randomShip4sY = d.nextInt(5);
                    } while (randomShip4sY + 4 >= 5);
                    for (int i = randomShip4sX; i < (randomShip4sX + 1); i++) {
                        for (int j = (randomShip4sY + 5); j < (randomShip4sY + 9); j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip4sX = c.nextInt(5);
                        randomShip4sY = d.nextInt(5);
                    } while ((randomShip4sX + 4) >= 5);
                    for (int j = (randomShip4sY + 5); j < (randomShip4sY + 6); j++) {
                        for (int i = randomShip4sX; i < (randomShip4sX + 4); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS3a == 0) {
                    do {
                        randomShip3saX = l.nextInt(5);
                        randomShip3saY = m.nextInt(5);
                    } while (randomShip3saY + 3 >= 5);
                    for (int i = (randomShip3saX + 5); i < (randomShip3saX + 6); i++) {
                        for (int j = randomShip3saY; j < (randomShip3saY + 3); j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip3saX = l.nextInt(5);
                        randomShip3saY = m.nextInt(5);
                    } while ((randomShip3saX + 3) >= 5);
                    for (int j = randomShip3saY; j < (randomShip3saY + 1); j++) {
                        for (int i = (randomShip3saX + 5); i < (randomShip3saX + 8); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS3b == 0) {
                    randomShip3sbY = 0;
                    for (int i = randomShip3sbX; i < (randomShip3sbX + 1); i++) {
                        for (int j = randomShip3sbY; j < 3; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip3sbX = e.nextInt(5);
                    } while ((randomShip3sbX + 3) >= 5);
                    do {
                        randomShip3sbY = k.nextInt(5);
                    } while (randomShip3sbY >= 3);
                    for (int j = randomShip3sbY; j < (randomShip3sbY + 1); j++) {
                        for (int i = randomShip3sbX; i < (randomShip3sbX + 3); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                if (rotS2 == 0) {
                    randomShip2sY = 0;
                    for (int i = randomShip2sX; i < (randomShip2sX + 1); i++) {
                        for (int j = (randomShip2sY + 3); j < 5; j++) {
                            computerShips[i][j] = 1;
                        }
                    }
                } else {
                    do {
                        randomShip2sX = n.nextInt(5);
                    } while ((randomShip2sX + 3) >= 5);
                    do {
                        randomShip2sY = o.nextInt(5);
                    } while (randomShip2sY >= 2);
                    for (int j = (randomShip2sY + 3); j < (randomShip2sY + 4); j++) {
                        for (int i = randomShip2sX; i < (randomShip2sX + 2); i++) {
                            computerShips[i][j] = 1;
                        }
                    }
                }
                break;
        }

        computer.setPlayerShips(board.getShipsCells());
        computer.setComputerShips(computerShips);
    }
}
