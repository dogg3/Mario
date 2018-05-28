/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1.view;

import game1.model.GameLevel;
import city.cs.engine.UserView;
import game1.Game;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author douglaslandvik
 */
public class GameOverView extends UserView {
    private Image background;
    private JPanel container;
    private JButton button;
    private JOptionPane highScorePane;
    private Font font;
    private Box box;
    private JButton restart;
    private Game game;
    private MyView view;
    private GameLevel world;
    
       
    public GameOverView(GameLevel world, int width, int height, Game game) {
        super(world, width, height);
        this.game = game;
        this.world = world;
        background = new ImageIcon("data/gameOver.jpg").getImage();
        restart = new RestartBtn();
        restart.addActionListener(new TheHandler(this));
        this.add(restart);
        
        highScorePane = new JOptionPane();
        highScorePane.showInputDialog("High Score!\n put in your name");
        
       
    }
    
   

   class TheHandler implements ActionListener {
       private UserView view;
       TheHandler(UserView view){
       this.view = view;
       
       }
       
       public void actionPerformed(ActionEvent e){

            game.restart();

         
           
       }
    
    }
    
   class RestartBtn extends JButton {
       RestartBtn(){
           this.setText("RestartGame");
           
       }
   
    }
 
        

   
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
      

        
    }
    
  


   
}
