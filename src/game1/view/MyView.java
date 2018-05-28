/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1.view;

import game1.model.Mario;
import city.cs.engine.UserView;
import city.cs.engine.World;
import static java.awt.Color.blue;
import static java.awt.Color.white;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author douglaslandvik
 */
public class MyView extends UserView {
    private Image background;
    private Mario player;

    public MyView(World world, int width, int height, Mario player) {
        super(world, width, height);
        background = new ImageIcon("data/game-background.jpg").getImage();
        this.player = player;
    }
    
    public void setPlayer(Mario player){
        this.player = player;
    }
    
    
    public void setBackgroundImage(ImageIcon background){
        this.background = background.getImage();
    
    }
     
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
      
        
        
    }
    
    
    
}