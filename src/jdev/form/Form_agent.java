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

public class Form_agent extends javax.swing.JPanel {

    public Form_agent() {
        initComponents();
        init();
        loadData();
        loadData2();
        loadData3();
        
        // UPDATE TABLE AND EMPLOYEE PRESENT
        // UPDATE TABLE AND EMPLOYEE PRESENT
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(roundPanel2.isVisible()) {
                        con = ConnectionManager.getConnection();
                    
                        pst = con.prepareStatement("SELECT emp_info.EmployeeID, CONCAT(emp_info.emp_lname, \", \", emp_info.emp_fname, \" \", emp_info.emp_mname) AS emp_name, emp_info.emp_department, dtr.timestamp, dtr.status FROM dtr LEFT JOIN emp_info ON dtr.EmployeeID=emp_info.EmployeeID WHERE emp_info.EmployeeID=? ORDER BY dtr.timestamp DESC");
                        
                        pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
                        
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
        
        // Fetch productivity value for the current employee ID
        pst = con.prepareStatement("SELECT productivity FROM productivity WHERE id = ?");
        pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
        rs = pst.executeQuery();
        
        // If there is a result, update the card label
        if(rs.next()) {
            card1.lbValues.setText(String.valueOf(rs.getString("productivity")));
        }
        
        con.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
   private void loadData2() {
    try {
        con = ConnectionManager.getConnection();
        
        // Fetch Quality and Knowledge Checker values for the current employee ID
        pst = con.prepareStatement("SELECT Quality, Knowledge_Checker, Overall FROM performance WHERE EmployeeID = ?");
        pst.setInt(1, Integer.parseInt(User.getEmployeeID()));
        rs = pst.executeQuery();
        
        // If there is a result, update the respective card labels
        if(rs.next()) {
            // Update card2 with Quality value
            card2.lbValues.setText(String.valueOf(rs.getString("Quality")));
            // Update card5 with Knowledge Checker value
            card4.lbValues.setText(String.valueOf(rs.getString("Overall")));
            card5.lbValues.setText(String.valueOf(rs.getString("Knowledge_Checker")));
        }
        
        con.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
   
   private void loadData3() {
    String employeeID = User.getEmployeeID();
    
    try (Connection con = ConnectionManager.getConnection()) {
        
        // Retrieve the attendance value for the specified employeeID
        String query1 = "SELECT Attdnce AS att FROM performance WHERE EmployeeID = ?";
        try (PreparedStatement pst1 = con.prepareStatement(query1)) {
            pst1.setInt(1, Integer.parseInt(employeeID));
            try (ResultSet rs1 = pst1.executeQuery()) {
                if (rs1.next()) {
                    card3.lbValues.setText(String.valueOf(rs1.getDouble("att")) + "%");
                } else {
                    card3.lbValues.setText("N/A");
                }
            }
        }
       
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

        card1 = new jdev.card.Card();
        card2 = new jdev.card.Card();
        card3 = new jdev.card.Card();
        card4 = new jdev.card.Card();
        card5 = new jdev.card.Card();
        roundPanel1 = new jdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        roundPanel2 = new jdev.swing.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1098, 688));

        card1.setDescription("Productivity");

        card2.setColor1(new java.awt.Color(95, 211, 226));
        card2.setColor2(new java.awt.Color(26, 166, 170));
        card2.setDescription("QA");
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.PIE_CHART);

        card3.setColor1(new java.awt.Color(95, 243, 140));
        card3.setColor2(new java.awt.Color(3, 157, 27));
        card3.setDescription("Attendance");
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.RING_VOLUME);

        card4.setDescription("Overall");

        card5.setDescription("Knowledge Check");

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
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(115, 115, 115)))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
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
                .addContainerGap(69, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private jdev.card.Card card1;
    private jdev.card.Card card2;
    private jdev.card.Card card3;
    private jdev.card.Card card4;
    private jdev.card.Card card5;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private jdev.swing.RoundPanel roundPanel1;
    private jdev.swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
