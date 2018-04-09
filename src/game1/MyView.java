/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

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
     
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
        g.setColor(white);
        g.fillRoundRect(15,9,90,30,5,5);
        
    }
    
    
    @Override
    protected void paintForeground(Graphics2D g){
        
        
        
        g.drawString( player.getScore() ,30, 30);
    
    }
}