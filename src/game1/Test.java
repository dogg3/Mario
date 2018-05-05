import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
  
public class Test extends JFrame {
   public Test() {
      super("JProgressBar Color Demonstration");
  
      // sets the color of the string painted inside the progressbar
      // selectionForeground is the color of the string that appears
      //    in the rectangle that shows the progress
      // selectionBackground is the color of the string that appears
      //    in the rectangle that shows the remaining area
      UIManager.put("ProgressBar.selectionForeground", Color.red);
      UIManager.put("ProgressBar.selectionBackground", Color.green);
  
      JProgressBar pb = new JProgressBar(0, 100);
      pb.setValue(50);
      pb.setStringPainted(true);
  
      // sets the foreground color, but only the
      // rectangle that shows the progress, not the text 
      pb.setForeground(Color.green);
  
      // sets the background color, the rectangle that 
      // shows the remaining area
      pb.setBackground(Color.red);
  
      // add the scroll pane to this window.
      getContentPane().add(pb);
  
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
  
   public static void main(String[] args) {
      Test main = new Test();
      main.pack();
      main.setVisible(true);
   }
}