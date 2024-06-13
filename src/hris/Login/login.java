/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hris.Login;

import java.sql.*;
import hris.*;
import hris.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author i5
 */
public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        edtEmpID = new javax.swing.JTextField();
        edtPw = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnClear1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(117, 0, 0));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hris/icons/rsz_1rsz_31logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(java.awt.Color.white);

        edtEmpID.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        edtEmpID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edtEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtEmpIDActionPerformed(evt);
            }
        });

        edtPw.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        edtPw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel1.setForeground(java.awt.Color.darkGray);
        jLabel1.setText("Employee ID:");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel2.setForeground(java.awt.Color.darkGray);
        jLabel2.setText("Password:");

        btnClear1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnClear1.setText("X");
        btnClear1.setBorderPainted(false);
        btnClear1.setContentAreaFilled(false);
        btnClear1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtEmpID)
                    .addComponent(edtPw)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClear1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnClear1)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(edtPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    private void edtEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtEmpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtEmpIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //login
        
        String empID = edtEmpID.getText();
        String empPw = edtPw.getText();
        
        try {
            con = ConnectionManager.getConnection();
            pst = con.prepareStatement("select * from login where EmployeeID=? and emp_pw=?");
            
            pst.setString(1, empID);
            pst.setString(2, empPw);
            
            rs = pst.executeQuery();
            
            if (rs.next()){
                if(rs.getString("position").equals("Human Resource")) {
                    rs.getInt("EmployeeID");
                    
                    try {
                        User.set("employeeID", String.valueOf(rs.getInt("EmployeeID")));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    this.dispose();
                    jdev.main.Main m = new jdev.main.Main();
                    //m.changeUsername(rs.getString("emp_fname"));
                    m.show();
                
                } else if (rs.getString("position").equals("Agent")) {
                    int employeeID = rs.getInt("EmployeeID");
                    
                    try {
                        User.set("employeeID", String.valueOf(rs.getInt("EmployeeID")));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    this.dispose();
                    jdev.main.Agent emp = new jdev.main.Agent();
//                    emp.changeUsername(rs.getString("emp_fname"));
                    emp.show();

                } else if (rs.getString("position").equals("Quality Analyst")) {
                    int employeeID = rs.getInt("EmployeeID");
                    
                    try {
                        User.set("employeeID", String.valueOf(rs.getInt("EmployeeID")));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    this.dispose();
                    jdev.main.Qa qa = new jdev.main.Qa();
                    qa.show();

                } else if (rs.getString("position").equals("Operation Manager")) {
                    int employeeID = rs.getInt("EmployeeID");
                    
                    try {
                        User.set("employeeID", String.valueOf(rs.getInt("EmployeeID")));
//                        User.set("employeeName", rs.getString("emp_name"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    this.dispose();
                    jdev.main.Om opm = new jdev.main.Om();
//                    opm.changeUsername(rs.getString("emp_fname"));
                    opm.show();

                } else if (rs.getString("position").equals("Team Leader")) {
                    int employeeID = rs.getInt("EmployeeID");
                    
                    try {
                        User.set("employeeID", String.valueOf(rs.getInt("EmployeeID")));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    this.dispose();
                    jdev.main.Tl tl = new jdev.main.Tl();
//                    tl.changeUsername(rs.getString("emp_fname"));
                    tl.show();

                } else if (rs.getString("position").equals("IT")) {
                    int employeeID = rs.getInt("EmployeeID");
                    
                    try {
                        User.set("employeeID", String.valueOf(rs.getInt("EmployeeID")));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    this.dispose();
                    jdev.main.IT it = new jdev.main.IT();
//                    it.changeUsername(rs.getString("emp_fname"));
                    it.show();

                } else if(rs.getString("position").equals("Subject Matter Expert")) {
                    int employeeID = rs.getInt("EmployeeID");
                    
                    try {
                        User.set("employeeID", String.valueOf(rs.getInt("EmployeeID")));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    this.dispose();
                    jdev.main.Sme sme = new jdev.main.Sme();
//                    sme.changeUsername(rs.getString("emp_fname"));
                    sme.show();

                } 
                
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Information, Please try again");
                edtPw.setText("");
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_btnClear1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear1;
    public javax.swing.JTextField edtEmpID;
    public javax.swing.JPasswordField edtPw;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
