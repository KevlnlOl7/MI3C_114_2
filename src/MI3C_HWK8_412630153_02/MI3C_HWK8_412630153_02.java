package MI3C_HWK8_412630153_02;
public class MI3C_HWK8_412630153_02 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MI3C_HWK8_412630153_02.class.getName());

    public MI3C_HWK8_412630153_02() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTa = new javax.swing.JTextArea();
        userTf = new javax.swing.JTextField();
        msgTf = new javax.swing.JTextField();
        ip1Tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ip2Tf = new javax.swing.JTextField();
        port1Tf = new javax.swing.JTextField();
        lisBtn = new javax.swing.JButton();
        port2Tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel1.setText("My IP / Port");

        mainTa.setColumns(20);
        mainTa.setRows(5);
        jScrollPane1.setViewportView(mainTa);

        jScrollPane2.setViewportView(jScrollPane1);

        userTf.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        userTf.setText("Peter");

        msgTf.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        msgTf.setText("Hello!");
        msgTf.addActionListener(this::msgTfActionPerformed);

        ip1Tf.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        ip1Tf.setText("127.0.0.1");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jLabel2.setText("Friend's IP / Port");

        ip2Tf.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        ip2Tf.setText("127.0.0.1");

        port1Tf.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        port1Tf.setText("4444");

        lisBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        lisBtn.setText("Listen");
        lisBtn.addActionListener(this::lisBtnActionPerformed);

        port2Tf.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        port2Tf.setText("5555");

        mainTa.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userTf, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msgTf, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ip1Tf)
                            .addComponent(ip2Tf))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(port1Tf, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(port2Tf))
                        .addGap(18, 18, 18)
                        .addComponent(lisBtn)
                        .addGap(8, 8, 8)))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ip1Tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(port1Tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lisBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ip2Tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(port2Tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userTf)
                    .addComponent(msgTf))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Receiver r = null;
    private void lisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisBtnActionPerformed
        int myPort = Integer.parseInt(port1Tf.getText());
        if(r==null || !r.isAlive()){
            Receiver r = new Receiver(myPort, this.mainTa);
            r.start();
            lisBtn.setEnabled(false);
        }
    }//GEN-LAST:event_lisBtnActionPerformed
    Sender s = new Sender(this.mainTa);
    private void msgTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgTfActionPerformed
        String friendIP = ip2Tf.getText();
        int friendPort = Integer.parseInt(port2Tf.getText());
        String msg = userTf.getText() + ": " + msgTf.getText()+"\n";
        new Thread(()->{
            s.send(friendIP, friendPort, msg);
        }).start();
        mainTa.append(userTf.getText() + ": " + msgTf.getText()+"\n");
        msgTf.setText(" ");
    }//GEN-LAST:event_msgTfActionPerformed
    public static void main(String args[]) {
        MI3C_HWK8_412630153_02 frame1 = new MI3C_HWK8_412630153_02();
        frame1.setTitle("視窗 A - Peter");
        frame1.userTf.setText("Peter");
        frame1.setVisible(true);
        MI3C_HWK8_412630153_02 frame2 = new MI3C_HWK8_412630153_02();
        frame2.setTitle("視窗 B - Mary");
        frame2.userTf.setText("Mary");
        frame2.port1Tf.setText("5555");
        frame2.port2Tf.setText("4444");
        frame2.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ip1Tf;
    private javax.swing.JTextField ip2Tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton lisBtn;
    private javax.swing.JTextArea mainTa;
    private javax.swing.JTextField msgTf;
    private javax.swing.JTextField port1Tf;
    private javax.swing.JTextField port2Tf;
    private javax.swing.JTextField userTf;
    // End of variables declaration//GEN-END:variables
}