
import javax.swing.DefaultListModel;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Leader
 */
public class MI3C_HWK10_412630153_01 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MI3C_HWK10_412630153_01.class.getName());
    DefaultListModel dlm = new DefaultListModel();
    public MI3C_HWK10_412630153_01() {
        initComponents();
        this.orderList.setModel(dlm);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        selBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        selBtn.setText("Select");
        selBtn.addActionListener(this::selBtnActionPerformed);
        jPanel1.add(selBtn, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout());

        menuList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Coke", "Fries", "Sundae", "Black Tea", "Konjac Jelly Milk Tea" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        menuList.addListSelectionListener(this::menuListValueChanged);
        jScrollPane1.setViewportView(menuList);

        jPanel2.add(jScrollPane1);

        jScrollPane2.setViewportView(orderList);

        jPanel2.add(jScrollPane2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selBtnActionPerformed
        dlm.clear();
        int[] itemIdx = menuList.getSelectedIndices();
        for(int idx : itemIdx){
            dlm.addElement(menuList.getModel().getElementAt(idx));
        }
    }//GEN-LAST:event_selBtnActionPerformed

    private void menuListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_menuListValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) {
            dlm.clear();
            int[] itemIdx = menuList.getSelectedIndices();
            for(int idx : itemIdx){
                dlm.addElement(menuList.getModel().getElementAt(idx));
            }
        }
    }//GEN-LAST:event_menuListValueChanged

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new MI3C_HWK10_412630153_01().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> menuList;
    private javax.swing.JList<String> orderList;
    private javax.swing.JButton selBtn;
    // End of variables declaration//GEN-END:variables
}
