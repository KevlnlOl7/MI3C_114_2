package HWK9;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class MI3C_HWK9_412630153_01_Client extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MI3C_HWK9_412630153_01_Client.class.getName());
    int port = 4444;
    String ip = "127.0.0.1";
    Socket querySocket = null;
    public MI3C_HWK9_412630153_01_Client() {
        initComponents();
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        nameTf.setEditable(false);
        scoreTf.setEditable(false);
    }
    public class clientThread extends Thread{
        public void run(){processQuery();};
    }
    public void processQuery(){
        if(!classARBtn.isSelected() && !classBRBtn.isSelected()){
            nameTf.setText("Select a class plz");
            return;
        }
        String regex = "[0-9]{4}";
        if(!idTf.getText().matches(regex)){
            nameTf.setText("Input 4-digit number plzz");
            scoreTf.setText("");
            return;
        }
        String classOpt = "";
        if(classARBtn.isSelected()){
            classOpt = "A";
        }else if (classBRBtn.isSelected()){
            classOpt = "B";
        }else{
            classOpt = "None";
        }
        nameTf.setText("");
        try(Socket querySocket = new Socket(ip, port);
            DataOutputStream dos = new DataOutputStream(querySocket.getOutputStream())){
            dos.writeUTF(classOpt + "," + idTf.getText().trim());
            dos.flush();
            try (ObjectInputStream ois = new ObjectInputStream(querySocket.getInputStream());){
                ScoreRecord sr = (ScoreRecord) ois.readObject();
                nameTf.setText(sr.name);
                scoreTf.setText(sr.score + "");
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idTf = new javax.swing.JTextField();
        nameTf = new javax.swing.JTextField();
        scoreTf = new javax.swing.JTextField();
        classARBtn = new javax.swing.JRadioButton();
        classBRBtn = new javax.swing.JRadioButton();
        queryBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans TC", 0, 18)); // NOI18N
        jLabel1.setText("Score Query Client");

        jLabel2.setText("ID:");
        jLabel3.setText("Name:");
        jLabel4.setText("Score:");
        buttonGroup1.add(classARBtn);
        classARBtn.setText("Class A");

        buttonGroup1.add(classBRBtn);
        classBRBtn.setText("Class B");

        queryBtn.setText("Query");
        queryBtn.addActionListener(this::queryBtnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(92, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(classARBtn)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(124, 124, 124)
                                                                .addComponent(classBRBtn))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(35, 35, 35)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(scoreTf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(idTf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addComponent(queryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(classBRBtn)
                                        .addComponent(classARBtn))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(idTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(scoreTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(queryBtn)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void queryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryBtnActionPerformed
        // TODO add your handling code here:
        new clientThread().start();
    }//GEN-LAST:event_queryBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MI3C_HWK9_412630153_01_Client().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton classARBtn;
    private javax.swing.JRadioButton classBRBtn;
    private javax.swing.JTextField idTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameTf;
    private javax.swing.JButton queryBtn;
    private javax.swing.JTextField scoreTf;
    // End of variables declaration//GEN-END:variables
}
