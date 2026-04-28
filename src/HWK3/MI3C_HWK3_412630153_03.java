package HWK3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ColorSlider extends JFrame implements ActionListener, ChangeListener {
    JLabel l1 = new JLabel("R"), l2 = new JLabel("G"), l3 = new JLabel("B");
    JSlider s1 = new JSlider(0, 255, 100), s2 = new JSlider(0, 255, 100), s3 = new JSlider(0, 255, 100);
    JTextField tf1 = new JTextField(), tf2 = new JTextField(), tf3 = new JTextField();
    JPanel jp1 = new JPanel();
    ColorSlider(){
        Container cp = super.getContentPane();
        cp.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jp1.setBackground(new Color(100, 100, 100));
        tf1.setText(String.valueOf(s1.getValue()));
        tf2.setText(String.valueOf(s2.getValue()));
        tf3.setText(String.valueOf(s3.getValue()));
        JComponent[] cs = {l1, l2, l3, s1, s2, s3, tf1, tf2, tf3, jp1};
        JSlider[] sliders = {s1, s2, s3};
        JTextField[] jTextFields = {tf1, tf2, tf3};
        int[] x = {40, 40, 40, 60, 60, 60, 365, 365, 365, 440}, y = {25, 105, 185, 20, 100, 180, 30, 110, 190, 70}, width = {50, 50, 50, 300, 300, 300, 30, 30, 30, 100}, height = {30, 30, 30, 50, 50, 50, 30, 30, 30, 100};
        for (int i = 0 ; i < cs.length ; i++){
            cs[i].setBounds(x[i], y[i], width[i], height[i]);
            cp.add(cs[i]);
        }
        for(JTextField tf: jTextFields){
            tf.addActionListener(this);
        }
        for(JSlider s : sliders){
            s.setMajorTickSpacing(10);
            s.setPaintTicks(true);
            s.addChangeListener(this);
        }
    }
    public void actionPerformed(ActionEvent e){
        try {
            if(e.getSource() == tf1){
                int r = Integer.parseInt(tf1.getText());
                s1.setValue(r);
            }if(e.getSource() == tf2){
                int g = Integer.parseInt(tf2.getText());
                s2.setValue(g);
            }if(e.getSource() == tf3){
                int b = Integer.parseInt(tf3.getText());
                s3.setValue(b);
            }
        }catch (IllegalArgumentException ae){
            tf1.setText(String.valueOf(s1.getValue()));
            tf2.setText(String.valueOf(s2.getValue()));
            tf3.setText(String.valueOf(s3.getValue()));
        }

    }
    public void stateChanged(ChangeEvent e){
        int r = s1.getValue();
        int g = s2.getValue();
        int b = s3.getValue();
        jp1.setBackground(new Color(r, g, b));
        if(e.getSource() == s1){
            tf1.setText(String.valueOf(r));
        }if(e.getSource() == s2){
            tf2.setText(String.valueOf(g));
        }if(e.getSource() == s3){
            tf3.setText(String.valueOf(b));
        }
    }
}
public class MI3C_HWK3_412630153_03 {
    public static void main(String[] args){
        ColorSlider cs = new ColorSlider();
        cs.setSize(600,300);
        cs.setVisible(true);
    }
}
