import java.awt.event.MouseListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {

    Component c;
    Timer t;

    private JLabel label = new JLabel("0 - 0");

    public Frame(){
       
        
        setTitle("Tetris Game");
        setLocation(300,100);
        setSize(900,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = new Component(this);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,255,0));
        

        MListener m_l = new MListener();
        panel.addMouseListener(m_l);

        
        



        t_listener t_l = new t_listener();
        t = new Timer(1, t_l);
       
        

        panel.add(label);
        panel.add(c);

        add(panel);





        setVisible(true);
    }

    public JLabel getLabel(){
        return label;
    }

    public Timer getTimer(){
        return t;
    }

    class t_listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            
            c.move_ball();
            

        }
    }

    class MListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            t.start();
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

    }


    public static void main(String[] args) {
        JFrame frame = new Frame();
    }


    

    
}
