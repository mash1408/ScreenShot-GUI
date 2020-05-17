/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenshotgui;

import java.awt.*; 
import java.awt.event.*; 
import java.awt.image.BufferedImage; 
import java.io.IOException; 
import java.io.File; 
import javax.imageio.ImageIO; 

class First extends Frame{

First(){
setSize(300,300);//frame size 300 width and 300 height

setLayout(null);//no layout manager

setVisible(true);//now frame will be visible, by default not visible


}
void shootPicture(){
    Button b=new Button("click me");
    b.setBounds(30,100,80,30);// setting button position
   add(b);//adding button into frame
    final TextField tf=new TextField();  
  tf.setBounds(50,50, 450,20); 
  add(tf);
    b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            try { 
            Thread.sleep(120); 
            Robot r = new Robot(); 
  
            // It saves screenshot to desired path 
            String path = System.getProperty("user.home")+"/Pictures/Shot.jpg"; 
  
            // Used to get ScreenSize and capture image 
            Rectangle capture =  
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
            BufferedImage Image = r.createScreenCapture(capture); 
            ImageIO.write(Image, "jpg", new File(path)); 
            System.out.println("Screenshot saved to location:"+path); 
            tf.setText("Screenshot saved to location:"+path);
        } 
        catch (AWTException | IOException | InterruptedException ex) { 
            System.out.println(ex); 
        } 
        }  
    });  
}

}

public class ScreenShotGUI {

    
    public static void main(String[] args) {
  final TextField tf=new TextField();  
    First frame = new First();
    frame.shootPicture();
    }
    
}
