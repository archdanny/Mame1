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
    private JLabel Klabel;
    private JButton startB;
    private JButton restartB;
    public Level level;
//    public Task task;
    private Timer timer;
 
   

    public SpelStat() {
        setSize(400, 50);
        setLayout(null);
        ResetListnenr a = new ResetListnenr();
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
        Klabel = new JLabel("Bazooka : 0");
        add(Klabel);
        Klabel.setBounds(350, 10, 100, 30);
        
    }

    public class ResetListnenr implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            startB.setEnabled(false);
            level.starten();
            
        }
    }
    
    public void stappenTeller(int stappen)
    {
        String stapjes = Integer.toString(stappen);
         label.setText(stapjes);
         repaint();
    }
    
    public void aantalKogels(int kogels)
    {
        Klabel.setText("Bazooka : " + Integer.toString(kogels));
    }
    

    public class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            startB.setEnabled(true);
            level.herstarten();
//            timer.cancel();
            label.setText("0");
            Klabel.setText("Bazooka : 0");
            requestFocus();
            

        }
    }

}
