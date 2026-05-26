
import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Leader
 */
public class MI3C_HWK10_412630153_02 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MI3C_HWK10_412630153_02.class.getName());

    /**
     * Creates new form MI3C_HWK10_412630153_02
     */
    DefaultListModel orderdlm = new DefaultListModel();
    DefaultListModel menudlm = new DefaultListModel();
    public MI3C_HWK10_412630153_02() {
        initComponents();
        this.orderList.setModel(orderdlm);
        this.menuList.setModel(menudlm);
        this.totalTf.setEditable(false);
        loadMenu();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuList = new javax.swing.JList<>();
        countTf = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        totalTf = new javax.swing.JTextField();
        delBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Hamburger ($72)", "Coke ($38)", "Fries ($50)", "Sundae ($49)", "Chicken Nuggets 6 pcs ($68)", "McFlurry ($65)" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(menuList);

        addBtn.setText("Add");
        addBtn.addActionListener(this::addBtnActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(countTf)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(addBtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(countTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(addBtn)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 28, -1, -1));

        delBtn.setText("Del");
        delBtn.addActionListener(this::delBtnActionPerformed);

        jScrollPane2.setViewportView(orderList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(delBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(totalTf)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(totalTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(delBtn)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 28, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if(!menuList.isSelectionEmpty()){
            String regex = "[0-9]+", quantity = countTf.getText().trim();
            if(quantity.isEmpty()) quantity = "1";
            int[] itemIdx = menuList.getSelectedIndices();
            for (int idx : itemIdx){
                String item = menuList.getModel().getElementAt(idx);
                if(getPrice(item) != null){
                    int price = Integer.parseInt(getPrice(item));
                    if(quantity.matches(regex)){
                        int q = Integer.parseInt(quantity);
                        if(q > 0){
                            String msg = String.format("%s * %d = %d", item, q, price * q);
                            orderdlm.addElement(msg);
                        }  
                    }
                }
            updateAmount();
            }    
            
        }
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        if(orderList.getModel().getSize() > 0){
            var selIndices = orderList.getSelectedIndices();
            for (int i = selIndices.length - 1; i >= 0; i--) {
                orderdlm.removeElementAt(selIndices[i]);
            }
            updateAmount();
        }
        
    }//GEN-LAST:event_delBtnActionPerformed
    public void loadMenu(){
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Data/menu.txt"))){
            String aLine;
            while((aLine = br.readLine()) != null){
                aLine = aLine.trim();
                if(aLine.isEmpty()) continue;
                int spaceIdx = aLine.lastIndexOf(" ");
                if(spaceIdx != -1){
                    String item = aLine.substring(0 ,spaceIdx).trim();
                    String price = aLine.substring(spaceIdx+1).trim();
                    menudlm.addElement(String.format("%s %s", item, price));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String getPrice(String item){
        String regex = "(.*\\s+)([0-9]+)$";
        item = item.trim();
        String itemName = "", itemPrice = "";
        if(item.matches(regex)){
            itemName = item.substring(0, item.lastIndexOf(" "));
            itemPrice = item.substring(item.lastIndexOf(" ")+1);
        }
        return itemPrice;
    }
    public void updateAmount(){
       totalTf.setText(getTotalAmount()+"");
    }
    public int getTotalAmount(){
        if(orderList.getModel().getSize() < 1) return 0;
        String[] ss = orderList.getModel().toString().split(",");
        String regex = ".*= ([0-9]+).*";
        int price = 0;
        for(String s: ss){
            s = s.trim();
            if(s.matches(regex)){
                int start = s.indexOf("=")+2;
                int end = s.length();
                if(s.endsWith("]")){
                    end = s.indexOf("]");
                }
                price += Integer.parseInt(s.substring(start, end));
            }
        }
        return price;
    }
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
        java.awt.EventQueue.invokeLater(() -> new MI3C_HWK10_412630153_02().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField countTf;
    private javax.swing.JButton delBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> menuList;
    private javax.swing.JList<String> orderList;
    private javax.swing.JTextField totalTf;
    // End of variables declaration//GEN-END:variables
}
