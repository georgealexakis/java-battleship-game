package battleship;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerDetails extends JFrame {

    JPanel panelTop;
    JPanel panelCenter;
    JPanel panelBottom;
    JLabel label;
    JTextField textField;
    JButton button;
    JFrame thisFrame;

    public PlayerDetails() {
        this.setSize(300, 125);
        this.setTitle("Battleship - Player's Details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame = this;

        panelTop = new JPanel();
        panelCenter = new JPanel();
        panelBottom = new JPanel();

        label = new JLabel("Please insert your name and press \"OK\"");
        textField = new JTextField(15);
        button = new JButton("OK");

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);

        panelTop.add(label);
        panelCenter.add(textField);
        panelBottom.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShipsPlacement x = new ShipsPlacement(textField.getText());
                x.setVisible(true);
                thisFrame.setVisible(false);
            }
        });
    }
}
