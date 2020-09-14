package battleship;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Winner extends JFrame {

    JPanel panelTop;
    JPanel panelCenter;
    JLabel labelMessage;
    JButton buttonOk;
    JFrame thisFrame;

    public Winner(String name) {
        this.setSize(250, 100);
        this.setTitle("Message");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame = this;

        panelTop = new JPanel();
        panelCenter = new JPanel();

        labelMessage = new JLabel(name + " is the winner!");
        buttonOk = new JButton("OK");

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);

        panelTop.add(labelMessage);
        panelCenter.add(buttonOk);

        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
