/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1.model;

import game1.Game;
import game1.model.Mario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author douglaslandvik
 */
public class Menu extends JPanel {
     //add a panel at the top with scores and lives
    private Mario player;
    private Game game;
    private Timer timer;

    
    Menu(Game game, Mario player){
        this.player = player;
        this.game = game;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box box = Box.createHorizontalBox();
        box.add(new ScoreLabel(game, player, player.getScore()));
        box.add(Box.createHorizontalGlue());
        box.setOpaque(true);
      box.add(new LifeBar(game));
        box.add(new LifeLabel(game, player, player.getLife()));
        
        this.add(box);
        this.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
       
        
    }
        private class ScoreLabel extends JLabel implements ChangeListener {

    private Mario mario;
    private String string;
    private Game game;
    

    
     ScoreLabel(Game game, Mario mario, String string){
     super(string);
     this.mario = mario;
     game.addChangeListener(this);
     }
    @Override
    public void stateChanged(ChangeEvent e) {
       super.setText(mario.getScore());
       
    }

    }
       private  class LifeLabel extends JLabel implements ChangeListener {
    private Mario mario;
    private String string;
    private Game game;
    

    
     LifeLabel(Game game, Mario mario, String string){
     super(string);
     this.mario = mario;
     game.addChangeListener(this);
     }
    @Override
    public void stateChanged(ChangeEvent e) {
       super.setText(mario.getLife());
       
    }
}
         
private class LifeBar extends JProgressBar implements ChangeListener{

    private JProgressBar lifeBar;
    
         LifeBar(Game game) {
           super();
           this.setStringPainted(true);
        
           game.addChangeListener(this);
           this.setMaximum(player.getLifeCount());
           this.setForeground(Color.red);
           this.setBackground(Color.red);

        }
 
      

        @Override
        public void stateChanged(ChangeEvent e) {
 this.setValue(player.getLifeCount());
        }


    }
    
}
    

