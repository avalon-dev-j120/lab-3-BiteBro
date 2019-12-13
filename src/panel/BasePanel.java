package panel;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JFrame{
    public static BasePanel bPane = null;
    private JFrame fr = new JFrame("Calc");
    private ButtonPanel buttonPanel = new ButtonPanel();
    private JButton buttonRez = new JButton("=");
    protected static JTextField outTextField = new JTextField("");

    public BasePanel() {
        bPane = this;
        // set theme
        setTheme();

        fr.setIconImage(Toolkit.getDefaultToolkit().getImage("icon/calcul.png"));
        fr.setMinimumSize(new Dimension(280, 420));
        fr.setLayout(new BorderLayout());

        outTextField.setFont(new Font("0", Font.BOLD, 24));
        outTextField.setHorizontalAlignment ( JTextField.RIGHT );
        buttonRez.setPreferredSize(new Dimension(280, 60));
        buttonRez.addActionListener(new ButtonPanel.ButtonActionListener());

        fr.add(outTextField, BorderLayout.NORTH);
        fr.add(buttonPanel, BorderLayout.CENTER);
        fr.add(buttonRez, BorderLayout.SOUTH);

        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

    }
    private void setTheme(){
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }
    }
}
