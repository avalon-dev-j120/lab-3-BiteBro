
package ui;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Window extends JFrame implements ChangeListener{
    public static Window win = null;
    private static ColorBox colBox = null;
    private static RightPanel rPanel = null;
    private static int colRed = 125;
    private static int colGreen = 125;
    private static int colBlue = 125;
    
    private Window(){
        win = this;
        setTitle("ColorChange");
        this.setMinimumSize(new Dimension(600, 300));
        this.setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color col = new Color(colRed,colGreen,colBlue);
       
        colBox = new ColorBox();
        colBox.setBackground(col);
        
        rPanel = new RightPanel();
        
        add(colBox);
        add(rPanel);
        
        setVisible(true);
    }
    
    public static Window getInstance(){
        if(win != null){ 
            return win;            
        }else return new Window();
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
       JSlider sld = (JSlider) ce.getSource();
       String sldName = sld.getName();
       switch(sldName){
           case "Red": colRed = sld.getValue();
           break;
           case "Green": colGreen = sld.getValue();
           break;
           case "Blue": colBlue = sld.getValue();
           break;
           default: System.out.println("ghghhjkj");
       }
      Color col = new Color(colRed,colGreen,colBlue);
     colBox.setBackground(col);
    }
}
