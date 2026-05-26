
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Leader
 */
public class MI3C_HWK10_412630153_03 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MI3C_HWK10_412630153_03.class.getName());
    DefaultListModel dlm = new DefaultListModel();
    public MI3C_HWK10_412630153_03() {
        initComponents();
        orderList.setModel(dlm);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuCbx = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hamburger", "Coke", "Fries", "Sundae", "Chicken Nuggets 6 pcs", "McFlurry" }));
        getContentPane().add(menuCbx, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setViewportView(orderList);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout());

        addBtn.setText("Add");
        addBtn.addActionListener(this::addBtnActionPerformed);
        jPanel1.add(addBtn);

        delBtn.setText("Del");
        delBtn.addActionListener(this::delBtnActionPerformed);
        jPanel1.add(delBtn);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        int idx = menuCbx.getSelectedIndex();
        String item = menuCbx.getModel().getElementAt(idx);
        boolean exists = false;
        int foundIdx = -1;
        for(int i = 0 ; i < dlm.getSize() ; i++){
            if(dlm.get(i).toString().startsWith(item)){
                exists = true;
                foundIdx = i;
                break;
            }
        }
        if(exists){
            String currentItem = dlm.get(foundIdx).toString();
            String[] ss = currentItem.split(" x");
            int cnt = Integer.parseInt(ss[1]) + 1;
            dlm.setElementAt(ss[0] + " x" + cnt, foundIdx);
        }else{
            dlm.addElement(item + " x1");
        }
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        var selIndices = orderList.getSelectedIndices();
        if(selIndices.length < 1) return;
        for(int i = selIndices.length - 1 ; i >= 0 ; i--){
            String[] ss = dlm.getElementAt(selIndices[i]).toString().split(" x");
            String item = ss[0];
            int quantity = Integer.parseInt(ss[1]);
            if(quantity>1){
                quantity -= 1;
                dlm.setElementAt(ss[0] + " x" + quantity, selIndices[i]);
            }else{
                dlm.removeElementAt(selIndices[i]);
            }
        }
    }//GEN-LAST:event_delBtnActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MI3C_HWK10_412630153_03().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> menuCbx;
    private javax.swing.JList<String> orderList;
    // End of variables declaration//GEN-END:variables
}
