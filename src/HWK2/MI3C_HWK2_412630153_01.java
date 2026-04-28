package HWK2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class CopyCutFrame extends JFrame implements ActionListener{
    JTextField tf1 = new JTextField("Helllo"), tf2 = new JTextField();
    JButton b1 = new JButton("CopyPaste");
    JButton b2 = new JButton("CutPaste");
    CopyCutFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = super.getContentPane();
        cp.setLayout(null);
        JComponent[] cs = {tf1, tf2, b1, b2};
        int[] x = {30, 30, 30, 120}, y = {30, 70, 110, 110}, width = {170, 170, 80, 80}, height = {30, 30, 30, 30};
        for (int i = 0 ; i < cs.length ; i++){
            cs[i].setBounds(x[i], y[i], width[i], height[i]);
            cp.add(cs[i]);
        }
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        String selected = tf1.getSelectedText();
        if (selected == null || selected.isEmpty()) {
            System.out.println("Text Field 1 is null / U didn't select anything ^_^");
            return;
        }
        if(e.getSource() == b1){
            tf2.setText(tf1.getSelectedText());
        }else if (e.getSource() == b2) {
            tf2.setText(tf1.getSelectedText());
            String s = tf1.getText().substring(0, tf1.getSelectionStart()) + tf1.getText().substring(tf1.getSelectionEnd());
            tf1.setText(s);
        }
    }
}
public class MI3C_HWK2_412630153_01 {
    public static void main(String[] args) {
        CopyCutFrame ccf = new CopyCutFrame();
        ccf.setSize(250,200);
        ccf.setVisible(true);
    }

}
