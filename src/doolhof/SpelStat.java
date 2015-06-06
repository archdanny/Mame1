/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class SpelStat extends JPanel {

    private JLabel label;
    private JLabel bazookaLabel;
    private JButton startB;
    private JButton restartB;
    private Level level;

    public SpelStat() {
        setSize(400, 50);
        setLayout(null);
        StartListnener a = new StartListnener();
        startB = new JButton("Start");
        startB.addActionListener(a);
        restartB = new JButton("Restart");
        ResetListener restet = new ResetListener();
        restartB.addActionListener(restet);
        add(restartB);
        restartB.setBounds(110, 10, 100, 30);
        add(startB);
        startB.setBounds(10, 10, 100, 30);
        label = new JLabel("0");
        add(label);
        label.setBounds(250, 10, 100, 30);
        bazookaLabel = new JLabel("Bazooka : 0");
        add(bazookaLabel);
        bazookaLabel.setBounds(350, 10, 100, 30);
    }

   
    
    public void setLevel(Level _level)
    {
        level = _level;
    }
    
    public void stappenTeller(int stappen)
    {
        String stapjes = Integer.toString(stappen);
        label.setText(stapjes);
    }
    
    public void aantalKogels(int kogels)
    {
        bazookaLabel.setText("Bazooka : " + Integer.toString(kogels));
    }
   
    public class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            startB.setEnabled(true);
            level.herstarten();
            label.setText("0");
            bazookaLabel.setText("Bazooka : 0");
            requestFocus();
        }
    }
    
     public class StartListnener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            startB.setEnabled(false);
            level.starten();
        }
    }

}
