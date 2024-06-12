package jdev.form;

import hris.ConnectionManager;
import hris.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import jdev.card.ModelCard;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Form_om extends javax.swing.JPanel {

    public Form_om() {
        initComponents();
        init();
        loadData();
        // UPDATE TABLE AND EMPLOYEE PRESENT
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(roundPanel2.isVisible()) {
                        con = ConnectionManager.getConnection();
                    
                            pst = con.prepareStatement("SELECT emp_info.EmployeeID, CONCAT(emp_info.emp_lname, \", \", emp_info.emp_fname, \" \", emp_info.emp_mname) AS emp_name, emp_info.emp_department, dtr.timestamp, dtr.status FROM dtr LEFT JOIN emp_info ON dtr.EmployeeID=emp_info.EmployeeID WHERE dtr.timestamp>DATE(dtr.timestamp)ORDER BY dtr.timestamp DESC");
                        
                        rs = pst.executeQuery();
                        
                        model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);
                        
                        while(rs.next()) {
                            String emp_id = String.valueOf(rs.getInt("EmployeeID"));
                            String emp_name = rs.getString("emp_name");
                            String emp_dept = rs.getString("emp_department");
                            String emp_timestamp = rs.getString("timestamp");
                            String emp_status = rs.getString("status");
                            

                            String data[] = {emp_id, emp_name, emp_dept, emp_timestamp, emp_status};
                            model.addRow(data);
                        }
                        
                        stmt = con.createStatement();
                        
                        rs = stmt.executeQuery("SELECT COUNT(EmployeeID) AS emp_count FROM dtr WHERE dtr.status=\"Day In\" AND DATE(dtr.timestamp)=CURRENT_DATE()");
                        
                        rs.next();
                        
                        //jLabel7.setText(String.valueOf(rs.getInt("emp_count")));
                        
                        
                        con.close();
                    }
                        
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        
        // SET DATE AND TIME
        jLabel10.setText(new SimpleDateFormat("EEE, dd MMMMM yyyy").format(Calendar.getInstance().getTime()));
        
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(roundPanel2.isVisible())
                    setTime();
            }
        }).start();
    }
    
    Connection con;
    Statement stmt;
    PreparedStatement pst;
    ResultSet rs;
    SimpleDateFormat  sdf = new SimpleDateFormat("hh:mm:ss a");
    String time;
    DefaultTableModel model;
    
    private void loadData() {
        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            
            rs = stmt.executeQuery("SELECT COUNT(EmployeeID) AS emp_count FROM dtr WHERE dtr.status=\"Day In\" AND DATE(dtr.timestamp)=CURRENT_DATE()");
                        
            rs.next();
                        
            card5.lbValues.setText(String.valueOf(rs.getInt("emp_count")));
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void setTime() {
        time = sdf.format(Calendar.getInstance().getTime());
        jLabel11.setText(time);
    }

    private void init() {

        //  init card data

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new jdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        roundPanel2 = new jdev.swing.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        card5 = new jdev.card.Card();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Employee Department", "Timestamp", "Employee Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.gray);
        jLabel1.setText("Employee Live Status");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(393, Short.MAX_VALUE))
            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                    .addContainerGap(38, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        roundPanel2.setBackground(java.awt.Color.white);
        roundPanel2.setRound(10);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("jLabel11");

        jButton13.setText("DAY IN");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("BREAK IN");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("BREAK OUT");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("LUNCH IN");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("LUNCH OUT");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("DAY OUT");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(111, 111, 111)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        card5.setDescription("Logged Employee");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
            jButton13.setEnabled(true);
            jButton14.setEnabled(false);
            jButton15.setEnabled(false);
            jButton16.setEnabled(false);
            jButton17.setEnabled(false);
            jButton18.setEnabled(false);
        
        try {
            con = ConnectionManager.getConnection();

            pst = con.prepareStatement("INSERT INTO dtr (EmployeeID, status) VALUES (?, ?)");

            pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
            pst.setString(2, "Day In");

            pst.execute();

            con.close();

            jButton13.setEnabled(false);
            jButton14.setEnabled(true);
            jButton15.setEnabled(false);
            jButton16.setEnabled(true);
            jButton17.setEnabled(false);
            jButton18.setEnabled(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            con = ConnectionManager.getConnection();

            pst = con.prepareStatement("INSERT INTO dtr (EmployeeID, status) VALUES (?, ?)");

            pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
            pst.setString(2, "Break In");

            pst.execute();

            con.close();
            
            jButton13.setEnabled(false);
            jButton14.setEnabled(false);
            jButton15.setEnabled(true);
            jButton16.setEnabled(false);
            jButton17.setEnabled(false);
            jButton18.setEnabled(false);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            con = ConnectionManager.getConnection();

            pst = con.prepareStatement("INSERT INTO dtr (EmployeeID, status) VALUES (?, ?)");

            pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
            pst.setString(2, "Break Out");

            pst.execute();

            con.close();
            
            jButton13.setEnabled(false);
            jButton14.setEnabled(true);
            jButton15.setEnabled(false);
            jButton16.setEnabled(true);
            jButton17.setEnabled(false);
            jButton18.setEnabled(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {
            con = ConnectionManager.getConnection();

            pst = con.prepareStatement("INSERT INTO dtr (EmployeeID, status) VALUES (?, ?)");

            pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
            pst.setString(2, "Lunch In");

            pst.execute();

            con.close();

            jButton13.setEnabled(false);
            jButton14.setEnabled(false);
            jButton15.setEnabled(false);
            jButton16.setEnabled(false);
            jButton17.setEnabled(true);
            jButton18.setEnabled(false);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        try {
            con = ConnectionManager.getConnection();

            pst = con.prepareStatement("INSERT INTO dtr (EmployeeID, status) VALUES (?, ?)");

            pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
            pst.setString(2, "Lunch Out");

            pst.execute();

            con.close();

            jButton13.setEnabled(false);
            jButton14.setEnabled(true);
            jButton15.setEnabled(false);
            jButton16.setEnabled(false);
            jButton17.setEnabled(false);
            jButton18.setEnabled(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            con = ConnectionManager.getConnection();

            pst = con.prepareStatement("INSERT INTO dtr (EmployeeID, status) VALUES (?, ?)");

            pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
            pst.setString(2, "Day Out");

            pst.execute();

            con.close();

            jButton13.setEnabled(true);
            jButton14.setEnabled(false);
            jButton15.setEnabled(false);
            jButton16.setEnabled(false);
            jButton17.setEnabled(false);
            jButton18.setEnabled(false);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jdev.card.Card card5;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private jdev.swing.RoundPanel roundPanel1;
    private jdev.swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
