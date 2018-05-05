/**
 * @author Douglas, Landvik, douglas.landvik@gmail.com
 * @version 1
 * 
 */


package game1;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The computer game.
 */
public class Game extends Model {

    public static void main(String[] args) {
        new Game();
       }
    
    
    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    private GameOverView gameOverView;
    private static SoundClip gameOverSound;
    
    private EngineerView engineerView;
    
    /** the current level **/
    private int level;
    
    private Controller controller;
    private Tracker tracker;

    
    private  final JFrame frame;
    
    private SoundClip gameMusic;
    private static SoundClip gameMusic2;
    

    
    
   

    /** Initialise a new Game. */
    public Game() {
        
        
        //Initiliaze level
        level = 1;
        // make the world
        world = new Level1();
        world.populate(this);
        view = new MyView(world, 500, 500, world.getPlayer());
        gameOverView = new GameOverView(world, 500,500, this);
        engineerView = new EngineerView(world,1000,500);
        engineerView.setZoom(5);
        view.setZoom(15);
        frame = new JFrame("Multi-level game");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
       
        
        //Add the menu 
        frame.add(world.addMenu(), BorderLayout.NORTH);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
         // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        
        
        tracker = new Tracker(view, world.getPlayer());
        world.addStepListener(tracker);
        
      
       // JFrame debugView = new DebugViewer(world, 500, 500);
       
        try {
            gameMusic = new SoundClip("data/sounds/okGameBackground.wav");
         
// Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
               gameMusic.setVolume(0.2d);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }  

        // start!
        world.start();
        }
        
        //game over sound
   static {
        try {
           gameOverSound = new SoundClip("data/sounds/newGO.wav");

         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         } 
 }
        
               //level2
    static {
        try {
           gameMusic2 = new SoundClip("data/sounds/level2.wav");
        
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         } 
 }


    
    
    public World getWorld (){
    return world;
    }
    
    
    
    
    public Controller getController() {
        return controller;
    }

    public Tracker getTracker() {
        return tracker;
    }
    
    public void stopBackgroundMusic(){
        gameMusic.stop();
    }
    
        /** @return the player of the game */
        public Mario getPlayer() {
            return world.getPlayer();
        }
        /** Is the current level of the game finished?
         *
         * @return true if isCompleted is true in the current world
         */
        public boolean isCurrentLevelCompleted() {
            return world.isCompleted();
        }
        
        
        public void goNextLevel() {
           
            world.stop();
            if (level == 2) {
             System.out.println("You made it");
            } else {
                level++;
                world = new Level2();
                world.populate(this);
                frame.add(world.addMenu(), BorderLayout.NORTH);
                view.setBackgroundImage(new ImageIcon("data/game-background2.jpg"));
                controller.setBody(world.getPlayer());
                tracker.setBody(world.getPlayer());
                view.setPlayer(world.getPlayer());
                view.setWorld(world);
                view.setZoom(15);
                world.addStepListener(tracker);
                world.start();
                gameMusic2.loop();
             
            }
        }
        
        public void restart(){
          frame.getContentPane().removeAll();
         
           
          if (world instanceof Level1){
              world = new Level1();
              view.setBackgroundImage(new ImageIcon("data/game-background.jpg"));
          }
           if (world instanceof Level2){
              world = new Level2();
              view.setBackgroundImage(new ImageIcon("data/game-background2.jpg"));
          }

                frame.requestFocus();
                world.populate(this);
                controller.setBody(world.getPlayer());
                tracker.setBody(world.getPlayer());
                view.setPlayer(world.getPlayer());
                view.addMouseListener(new GiveFocus(frame));
                view.setWorld(world);
                view.setZoom(15);
                frame.getContentPane().add(view);
                world.addStepListener(tracker);
                gameMusic.loop();
                world.start();
                frame.add(world.addMenu(), BorderLayout.NORTH);
                frame.getContentPane().repaint();

           }


     
        
        
        //game Over
        public void gameOver(){
         
               world.stop();
              
              frame.getContentPane().removeAll();
              frame.getContentPane().repaint();
              frame.getContentPane().add(gameOverView);
              world = new Level1();
            
             gameMusic.pause();
             gameOverSound.play(); 
               
    }
    
}
