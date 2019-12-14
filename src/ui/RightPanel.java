
package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

class RightPanel extends JPanel{
    public RightPanel(){

        JPanel redPanel = new JPanel();
        redPanel.setLayout(new BorderLayout());

        JLabel lr = new JLabel();
        JSlider sliderRed = new JSlider(0,255,125);
        lr.setText("  RED     ");

        sliderRed.setName("Red");
        sliderRed.setMajorTickSpacing(25);
        sliderRed.setPaintTicks(true);
        sliderRed.setPaintLabels(true);
        sliderRed.addChangeListener(Window.win);

        JPanel greenPanel = new JPanel();
        greenPanel.setLayout(new BorderLayout());
        JLabel lg = new JLabel();
        lg.setText("  GREEN");
        JSlider sliderGreen = new JSlider(0,255,125);

        sliderGreen.setName("Green");
        sliderGreen.setMajorTickSpacing(25);
        sliderGreen.setPaintTicks(true);
        sliderGreen.setPaintLabels(true);
        sliderGreen.addChangeListener(Window.win);

        JPanel bluePanel = new JPanel();
        bluePanel.setLayout(new BorderLayout());
        JLabel lb = new JLabel();
        lb.setText("  BLUE  ");
        JSlider sliderBlue = new JSlider(0,255,125);

        sliderBlue.setName("Blue");
        sliderBlue.setMajorTickSpacing(25);
        sliderBlue.setPaintTicks(true);
        sliderBlue.setPaintLabels(true);
        sliderBlue.addChangeListener(Window.win);
        
        setLayout(new GridLayout(3,1));

        redPanel.add(lr, BorderLayout.WEST);
        redPanel.add(sliderRed, BorderLayout.CENTER);

        greenPanel.add(lg, BorderLayout.WEST);
        greenPanel.add(sliderGreen, BorderLayout.CENTER );

        bluePanel.add(lb, BorderLayout.WEST);
        bluePanel.add(sliderBlue, BorderLayout.CENTER);

        add(redPanel);
        add(greenPanel);
        add(bluePanel);

//        add(lr);
//        add(sliderRed);
//        add(lg);
//        add(sliderGreen);
//        add(lb);
//        add(sliderBlue);
        
       
   
    }
    
}
