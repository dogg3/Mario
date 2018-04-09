package game1;

import city.cs.engine.*;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    
    /** the current level **/
    private int level;
    
    private Controller controller;
    private Tracker tracker;
    

    /** Initialise a new Game. */
    public Game() {
        
        //Initiliaze level
        level = 1;
        // make the world
        world = new Level1();
        world.populate(this);
        view = new MyView(world, 500, 500, world.getPlayer());

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);
         // display the view in a frame
        final JFrame frame = new JFrame("Multi-level game");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
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

        // start!
        world.start();
        }
        /** The player in the current level. */
        public Mario getPlayer() {
            return world.getPlayer();
        }
        /** Is the current level of the game finished? */
        public boolean isCurrentLevelCompleted() {
            return world.isCompleted();
        }
        public void goNextLevel() {
            world.stop();
            if (level == 2) {
                System.exit(0);
            } else {
                level++;
                world = new Level2();
                world.populate(this);
                view.setBackgroundImage(new ImageIcon("data/game-background2.jpg"));
                controller.setBody(world.getPlayer());
                tracker.setBody(world.getPlayer());
                view.setPlayer(world.getPlayer());
                view.setWorld(world);
                world.addStepListener(tracker);
                world.start();
            }
        }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
       }
}
