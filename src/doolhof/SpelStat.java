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
    Bazooka bazooka = new Bazooka();
   

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
        Klabel = new JLabel("Bazooka : " + Integer.toString(bazooka.kogels));
        add(Klabel);
        Klabel.setBounds(350, 10, 100, 30);
        
    }

    public class ResetListnenr implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            startB.setEnabled(false);
            level.starten();
//            
//            timer = new Timer();
//            timer.schedule(task, 1000, 1000);
            
        }
    }
    
    public void stappenTeller(int stappen)
    {
        String labelText = label.getText();
        int steps = Integer.parseInt(labelText);
        steps = steps + stappen;
        String stapjes = Integer.toString(steps);
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
            requestFocus();
            

        }
    }

//    public class Task extends TimerTask {
//
//       public int countdown = 59;
//
//        @Override
//        public void run() {
//            String tijd = Integer.toString(countdown);
//            label.setText(tijd);
//            if (countdown == 0) {
//                timer.cancel();
//                startB.setEnabled(false);
//            } else {
//                countdown -= 1;
//
//            }
//
//        }
//    }
}
