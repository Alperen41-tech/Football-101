import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Component
 */
public class Component extends JComponent {

    private int player_1_x = 0;
    private int player_1_y = 185;

    private int player_2_x = 875;
    private int player_2_y = 185;

    private int ball_x = 437;
    private int ball_y = 263;

    private int n = 0;
    private int k = 0;

    private int player_1_point = 0;
    private int player_2_point = 0;

    Frame f;

    public Component(Frame f) {
        setPreferredSize(new Dimension(900, 900));

        this.f = f;
        addKeyListener(new key_listener());
        setFocusable(true);
    }

    public int getPlayer_1_point() {
        return player_1_point;
    }

    public int getPlayer_2_point() {
        return player_2_point;
    }

    // @Override
    public void paintComponent(Graphics g) {


        g.setColor(new Color(0,0,0));
        g.fillRect(player_1_x, player_1_y, 25, 200);
        g.fillRect(player_2_x, player_2_y, 25, 200);

        g.fillOval(ball_x, ball_y, 25, 25);

        g.setColor(new Color(255,255,255));

        g.drawLine(450, 0, 450, 650); //438,0 -- 438,650
        g.drawOval(347, 178, 200, 200);

        g.setColor(new Color(0,0,0));



    }

    public void move_ball() {

        if (ball_x + 5 > player_2_x -30 && !(ball_x + 5 > player_2_x)) { // burda sağ taraftan oyuncuya çarptı

            if (ball_y > player_2_y - 12 && ball_y < player_2_y + 200 + 12) {
                n++;
            } else {

                if (ball_x + 5 > 875){
                    player_1_point++;

                    f.getLabel().setText("" + player_1_point + " - "+player_2_point);
                    setBeginning();
                    f.getTimer().stop();
                }
                

            }

        }

        else{

            if (ball_x + 5 > 875){
                player_1_point++;
                f.getLabel().setText("" + player_1_point + " - "+player_2_point);
                setBeginning();
                f.getTimer().stop();
            }

        }

        if ((ball_x - 5 < player_1_x+30)&& !(ball_x - 5 < player_1_x)) { // burda sol taraftan oyuncu attı

            if (ball_y > player_1_y - 30 && ball_y < player_1_y + 200 + 30) {
                n++;
            }

            else {

                if (ball_x - 5 < 0){
                    player_2_point++;
                    f.getLabel().setText("" + player_1_point + " - "+player_2_point);
                    setBeginning();
                    f.getTimer().stop();
                }

            }

        }

        else{

            if (ball_x - 5 < 0){
                player_2_point++;
                f.getLabel().setText("" + player_1_point + " - "+player_2_point);
                setBeginning();
                f.getTimer().stop();
            }

        }

        // y eksenlerinden çıkışı girişi kontrol

        if (ball_y - 5 < 0) {
            k++;
        }

        else if (ball_y + 5 > 550) {
            k++;

        }

        ball_x += Math.pow(-1, n) * 10;
        ball_y += Math.pow(-1, k) * 10;

        repaint();
    }

    public void move_player1_down(){
        player_1_y += 50;
        if (player_1_y >= 400){player_1_y = 400;}
        repaint();
    }

    public void move_player1_up(){
        player_1_y -= 50;
        if (player_1_y <=0){ player_1_y = 0;}
        repaint();
    }

    public void move_player1_right(){
        player_1_x += 50;
        if (player_1_x >= 425){player_1_x = 425;}
        repaint();
    }

    public void move_player1_left(){
        player_1_x -= 50;
        if (player_1_x <= 0){ player_1_x = 0;}
        repaint();
    }
    

    public void move_player2_down(){
        player_2_y += 50;
        if (player_2_y >= 400){player_2_y = 400;}
        repaint();
    }

    public void move_player2_up(){
        player_2_y -= 50;
        if (player_2_y <=0){ player_2_y = 0;}
        repaint();
    }

    public void move_player2_right(){
        player_2_x += 50;
        if (player_2_x >= 875){player_2_x = 875;}
        repaint();
    }

    public void move_player2_left(){
        player_2_x -= 50;
        if (player_2_x <= 450){player_2_x = 450;}
        repaint();
    }

    private void setBeginning() {


        int value = 0;

        if (player_1_point >= 10 || player_2_point >= 10){
            value = JOptionPane.showConfirmDialog(null, "The game is over. Scor is: " + player_1_point + " - " + player_2_point +"\nDo you want to play again? ");

            if (value == 0){
                player_1_point =  0;
                player_2_point = 0;
                f.getLabel().setText("" + player_1_point + " - "+player_2_point);
            }
            else{
                System.exit(-1);
            }
        }

        
        player_1_x = 0;
        player_2_x = 875;
        player_1_y = 185;
        player_2_y = 185;
        ball_x = 427;
        ball_y = 258;
        n = 0;
        k = 0;
        repaint();
            
        
        


        

    }

    class key_listener implements KeyListener{
        public void keyPressed(KeyEvent e){


            f.getTimer().start();
            
            String key = KeyStroke.getKeyStrokeForEvent(e).toString().replace("pressed ", ""); 

            if (key.equals("UP")){
                move_player2_up();
            }
            else if(key.equals("DOWN")){
                move_player2_down();
            }
            else if (key.equals("LEFT")){
                move_player2_left();
            }
            else if (key.equals("RIGHT")){
                move_player2_right();
            }

            else if (key.equals("W")){
                move_player1_up();
            }

            else if (key.equals("S")){
                move_player1_down();
            }
            else if (key.equals("A")){
                move_player1_left();
            }
            else if (key.equals("D")){
                move_player1_right();
            }

            

            

        }

        public void keyReleased(KeyEvent e){
            
        }
        public void keyTyped(KeyEvent e){
            
        }
    }

}