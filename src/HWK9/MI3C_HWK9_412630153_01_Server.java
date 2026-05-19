package HWK9;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class MI3C_HWK9_412630153_01_Server extends javax.swing.JFrame {
    boolean running = true;
    int port = 4444;
    static ArrayList<ScoreRecord> classA = new ArrayList<>();
    static ArrayList<ScoreRecord> classB = new ArrayList<>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MI3C_HWK9_412630153_01_Server.class.getName());

    public MI3C_HWK9_412630153_01_Server() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        msgTa.setEditable(false);
        readCSV(classA, "C:/Data/score_A.csv");
        readCSV(classB, "C:/Data/score_B.csv");
        new serverThread().start();
    }
    public void readCSV(ArrayList<ScoreRecord> arr,String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String aLine;
            String regexID = "[0-9]{4}", regexName = "[A-Za-z]+", regexScore = "[.0-9]{4}";
            while((aLine = br.readLine()) != null){
                String[] srs = aLine.trim().split(",");
                if(srs[0].startsWith("\uFEFF")){
                    srs[0] = srs[0].substring(1);
                }
                if(srs[0].matches(regexID) && srs[1].matches(regexName) && srs[2].matches(regexScore)){
                    arr.add(new ScoreRecord(Integer.parseInt(srs[0]), srs[1], Float.parseFloat(srs[2])));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public class serverThread extends Thread{
        public void run(){initServer();};
    }
    public void initServer(){
        try{
            ServerSocket ss = new ServerSocket(port);
            msgTa.append("Server init ....\n");
            while(running){
                Socket clientSocket = ss.accept();
                msgTa.append("accept a client: " + clientSocket + "\n");
                new Thread(()->{processRequest(clientSocket);}).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void processRequest(Socket client){
        try(DataInputStream dis = new DataInputStream(client.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream())){
            String s = dis.readUTF();
            String[] ss = s.split(",");
            String targetID = ss[1].trim();
            String regex = "[0-9]{4}";
            boolean isFound = false;
            if(!targetID.matches(regex)){
                oos.writeObject(new ScoreRecord());
                oos.flush();
                return;
            }
            ArrayList<ScoreRecord> temp;
            if(ss[0].equals("A")) {
                temp = classA;
            }else if (ss[0].equals("B")){
                temp = classB;
            }else{
                temp = null;
                return;
            }
            for (ScoreRecord sr: temp){
                if(sr.id == Integer.parseInt(targetID)){
                    oos.writeObject(sr);
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                oos.writeObject(new ScoreRecord());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        msgTa = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msgTa.setColumns(20);
        msgTa.setRows(5);
        jScrollPane2.setViewportView(msgTa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(() -> new MI3C_HWK9_412630153_01_Server().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea msgTa;
    // End of variables declaration//GEN-END:variables
}
