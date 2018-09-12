package battleship;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ShipsPlacement extends JFrame {

    JPanel panelTop;
    JPanel panelCenter;
    JPanel panelBoard;
    JPanel panelShips;
    JPanel panelBr;
    JPanel panelBs;
    JLabel labelBattleship;
    JLabel labelBoard;
    JLabel labelShips;
    JButton rotateButton;
    JButton startButton;
    PanelBoard board;
    PanelShips ship5s;
    PanelShips ship4s;
    PanelShips ship3sa;
    PanelShips ship3sb;
    PanelShips ship2s;
    JFrame thisFrame;
    private String playerName;
    private int rotateSwitch;

    public ShipsPlacement(String x) {
        this.setSize(750, 550);
        this.setTitle("Battleship - Ships Placement");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame = this;
        this.playerName = x;

        if (playerName.equals("")) {
            playerName = "Player";
        }

        startButton = new JButton("Start game");
        startButton.setEnabled(false);

        ship5s = new PanelShips(1, 5, Color.gray, Color.black, 5);
        ship4s = new PanelShips(1, 5, Color.gray, Color.black, 4);
        ship3sa = new PanelShips(1, 5, Color.gray, Color.black, 3);
        ship3sb = new PanelShips(1, 5, Color.gray, Color.black, 3);
        ship2s = new PanelShips(1, 5, Color.gray, Color.black, 2);
        board = new PanelBoard(10, 10, Color.cyan, Color.black, ship5s, ship4s, ship3sa, ship3sb, ship2s, startButton);

        panelTop = new JPanel();
        panelCenter = new JPanel(null);

        panelBr = new JPanel();
        panelBs = new JPanel();
        panelBoard = new JPanel();
        panelShips = new JPanel();

        labelShips = new JLabel(" Your ships to be placed ");
        labelBoard = new JLabel(" Your Board ");
        labelBattleship = new JLabel("Please select ships from the left and place them in your board. Press \"Start game\" when you are ready!");
        rotateButton = new JButton("Rotate ship");

        panelTop.add(labelBattleship);
        panelBr.add(rotateButton);
        panelBs.add(startButton);
        panelBoard.add(labelBoard);
        panelShips.add(labelShips);

        panelBoard.setSize(400, 20);
        panelBoard.setLocation(330, 18);
        panelCenter.add(panelBoard);

        board.setSize(400, 400);
        board.setLocation(330, 40);
        panelCenter.add(board);

        panelShips.setSize(200, 20);
        panelShips.setLocation(30, 128);
        panelCenter.add(panelShips);

        ship5s.setSize(200, 40);
        ship5s.setLocation(30, 150);
        panelCenter.add(ship5s);

        ship4s.setSize(200, 40);
        ship4s.setLocation(30, 200);
        panelCenter.add(ship4s);

        ship3sa.setSize(200, 40);
        ship3sa.setLocation(30, 250);
        panelCenter.add(ship3sa);

        ship3sb.setSize(200, 40);
        ship3sb.setLocation(30, 300);
        panelCenter.add(ship3sb);

        ship2s.setSize(200, 40);
        ship2s.setLocation(30, 350);
        panelCenter.add(ship2s);

        panelBr.setSize(100, 40);
        panelBr.setLocation(10, 460);
        panelCenter.add(panelBr);

        panelBs.setSize(100, 40);
        panelBs.setLocation(630, 460);
        panelCenter.add(panelBs);

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayGame x = new PlayGame(playerName, board);
                x.setVisible(true);
                thisFrame.setVisible(false);
                board.setExitShipsPlcement(1);
            }
        });

        rotateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.setRotateMark(1);
                rotateSwitch++;
                if (rotateSwitch > 1) {
                    board.setRotateMark(0);
                    rotateSwitch = 0;
                }
            }
        });
    }
}
