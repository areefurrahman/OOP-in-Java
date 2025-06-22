import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class flowLayoutPractice extends JFrame{

    flowLayoutPractice(){

    JPanel panel = new JPanel();
    // panel.setBounds(0,0,600,100);
    panel.setPreferredSize(new Dimension(600,100));;
    panel.setBackground(Color.white);

    JPanel panel2 = new JPanel();
    // panel.setBounds(0,0,600,100);
    panel2.setPreferredSize(new Dimension(600,100));;
    panel2.setBackground(Color.white);

    JPanel panel3 = new JPanel();
    // panel.setBounds(0,0,600,100);
    panel3.setPreferredSize(new Dimension(600,100));;
    panel3.setBackground(Color.white);

    JPanel containerPanel = new JPanel();
    containerPanel.setBounds(40,0,500,500);
    containerPanel.setLayout(new FlowLayout());
    containerPanel.add(panel);
    containerPanel.add(panel2);
    containerPanel.add(panel3);


        
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(700, 300, 600, 540);
    this.setLayout(null);
    this.getContentPane().setBackground(Color.black);
    // this.setResizable(false);
    this.add(containerPanel);
    
    this.setVisible(true);
    }
    
    public static void main(String[] args) {
        
         new flowLayoutPractice();
    }
}