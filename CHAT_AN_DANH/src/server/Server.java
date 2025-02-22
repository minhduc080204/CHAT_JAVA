/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import login.DBconnect;
import login.Login;

/**
 *
 * @author DUC
 */
public class Server extends javax.swing.JFrame {
    public static volatile ServerThreadBus serverThreadBus=new ServerThreadBus();
    public static Socket socketOfServer;
    public static ServerSocket listener = null;
    public static ServerThread serverThread= null;
    public static int clientNumber = 0;
    public DefaultTableModel model;
    public int select=0;
    /**
     * Creates new form Server
     */
    public Server() throws ClassNotFoundException, SQLException {        
        initComponents();
        listAcc();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    void listAcc() throws ClassNotFoundException, SQLException{
        model=(DefaultTableModel)tbAcc.getModel();
        Connection conn=DBconnect.getConnection();
        String sql="select *from account";
        PreparedStatement ps=conn.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Vector data = new Vector();  
            data.add(rs.getString(1));
            data.add(rs.getString(2));
            model.addRow(data);
            
        }
        tbAcc.setModel(model);        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        delACC = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        runsv = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAcc = new javax.swing.JTable();
        addACC = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addPass = new javax.swing.JTextField();
        addAcc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SERVER");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("SERVER CONTROLER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 260, 80));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        delACC.setBackground(new java.awt.Color(204, 255, 255));
        delACC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delACC.setText("Delete Account");
        delACC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delACCMouseClicked(evt);
            }
        });
        jPanel3.add(delACC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 140, 30));

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        runsv.setBackground(new java.awt.Color(153, 255, 153));
        runsv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        runsv.setText("RUN SERVER");
        runsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                runsvMouseClicked(evt);
            }
        });
        runsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runsvActionPerformed(evt);
            }
        });
        jPanel4.add(runsv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 50));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(10);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(3);
        jTextArea1.setText(" Note: the function cannot\n be used while the server\n is running");
        jTextArea1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 180, 70));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 360, 90));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 380, 10));

        tbAcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên tài khoản", "Mật khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAccMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAcc);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 360, 150));

        addACC.setBackground(new java.awt.Color(204, 255, 255));
        addACC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addACC.setText("Add Account");
        addACC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addACCMouseClicked(evt);
            }
        });
        jPanel3.add(addACC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 150, 30));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 380, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mật khẩu");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 90, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tài khoản");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 80, 30));
        jPanel3.add(addPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 200, 30));

        addAcc.setToolTipText("");
        jPanel3.add(addAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 200, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 380, 510));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void runsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runsvMouseClicked
        JOptionPane.showMessageDialog(null, "Server is running!");
        new Login().setVisible(true);
        dispose();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    listener = new ServerSocket(7777);
                } catch (IOException e) {
                    System.out.println(e);
                    System.exit(1);
                }
                ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 
                100,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8)
                );
                try {
                    while (true) {                
                        socketOfServer = listener.accept();
                        serverThread = new ServerThread(socketOfServer, clientNumber++);
                        serverThreadBus.add(serverThread);
                        System.out.println("Số thread đang chạy là: "+serverThreadBus.getLength());                
                        executor.execute(serverThread);                
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        listener.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();        
    }//GEN-LAST:event_runsvMouseClicked

    private void delACCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delACCMouseClicked
        if(tbAcc.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản cần xóa");
        }else{
            try {
                Connection conn=DBconnect.getConnection();
                String sql="select *from account";
                PreparedStatement ps=conn.prepareCall(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    if(rs.getString(1).equals((String)model.getValueAt(select-1, 0))){
                        sql="delete from account where name='"+(String) model.getValueAt(select, 0)+"';";
                        ps=conn.prepareCall(sql);
                        ps.execute();                        
                        listAcc();
                        break;
                    }
                }                
                new Server().setVisible(true);
                this.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_delACCMouseClicked

    private void runsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runsvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_runsvActionPerformed

    private void addACCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addACCMouseClicked
        try {
            Connection conn=DBconnect.getConnection();
            String sql="select *from account";
            PreparedStatement ps=conn.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            String a=addAcc.getText().replaceAll(" ", "");
            String b=addPass.getText().replaceAll(" ", "");
            int c=0;
            if(a.equals("")||b.equals("")){
                JOptionPane.showMessageDialog(null, "Không được để trống !");
            }else{
                while(rs.next()){
                    if(a.equals(rs.getString(1).replaceAll(" ", ""))){
                        JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại !");
                        c=0;
                        break;
                    }else{
                        c=1;
                    }
                }
                if(c==1){
                    sql="insert into account(name, pass) values ('"+a+"',' "+b+"') ";
                    ps=conn.prepareCall(sql);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Added new Account !");
                    dispose();
                    new server.Server().setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addACCMouseClicked

    private void tbAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccMouseClicked
        model=(DefaultTableModel)tbAcc.getModel();
        select=tbAcc.getSelectedRow();
    }//GEN-LAST:event_tbAccMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new login.Login().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addACC;
    private javax.swing.JTextField addAcc;
    private javax.swing.JTextField addPass;
    private javax.swing.JButton delACC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton runsv;
    private javax.swing.JTable tbAcc;
    // End of variables declaration//GEN-END:variables
}
