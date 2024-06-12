/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tl;

import om.*;
import hr.*;
import hris.ConnectionManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author i5
 */
public class empcred extends javax.swing.JPanel {

    /**
     * Creates new form empcred
     */
    Connection con;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model;
    
    public empcred() {
        initComponents();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel9.setBackground(java.awt.Color.white);
        jPanel9.setPreferredSize(new java.awt.Dimension(1098, 688));

        jLabel63.setText("Employee Number:");

        jLabel64.setText("First Name:");

        jLabel65.setText("Last Name:");

        jButton6.setText("SEARCH");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("CLEAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("UPDATE RECORD");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1001, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                // Your initial data here, for example:
                // {1, "John", "Doe", "john.doe@example.com", "LOB1", "Manager1", "Position1", "Active"},
            },
            new String [] {
                "Employee Number", "First Name", "Last Name", "Company email", "LOB", "Operation Manager", "Position", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jScrollPane15.setViewportView(jScrollPane4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1066, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                // TODO add your handling code here:
                searchData();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
          DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    int selectedRow = jTable2.getSelectedRow(); // Get the selected row index

    if (selectedRow == -1) {
        // No row is selected
        JOptionPane.showMessageDialog(this, "Please select a row to update", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        Connection con = ConnectionManager.getConnection();
        String query = "UPDATE cred SET Status = ? WHERE EmployeeID = ?";
        PreparedStatement pstmt = con.prepareStatement(query);

        // Retrieve data from the selected row
        String empID = getStringValue(model.getValueAt(selectedRow, 0));
        String status = getStringValue(model.getValueAt(selectedRow, 7)); // Assuming Position is in the seventh column

        // Set parameters for the prepared statement
        pstmt.setString(1, status);
        pstmt.setString(2, empID);
      

        // Execute the update
        int rowsUpdated = pstmt.executeUpdate();
        System.out.println("Rows updated: " + rowsUpdated);
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Employee updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadData(); // Assuming this method reloads the data in the JTable
        } else {
            JOptionPane.showMessageDialog(this, "No rows were updated", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating employee: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            clearFields();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed
    private String getStringValue(Object obj) {
    if (obj != null) {
        return obj.toString();
    } else {
        return ""; // or any default value you prefer
    }
}


     // Method to clear text fields
    private void clearFields() {
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        loadData();
    }
    
    // Method to update existing employee
   
      // Method to add mouse listener to jTable2
    private void addTableListener() {
        jTable2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTable2.getSelectedRow();
                if (selectedRow != -1) {
                    jTextField5.setText(jTable2.getValueAt(selectedRow, 0).toString());
                    jTextField6.setText(jTable2.getValueAt(selectedRow, 1).toString());
                    jTextField7.setText(jTable2.getValueAt(selectedRow, 2).toString());
                }
            }
        });
    }
  
    private void searchData() {
    String employeeID = jTextField5.getText().trim();
    String firstName = jTextField6.getText().trim();
    String lastName = jTextField7.getText().trim(); 
        
  // Validate Employee ID
    if (employeeID.isEmpty() && firstName.isEmpty() && lastName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Text Fields cannot be empty", "Validation Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    try {
        con = ConnectionManager.getConnection();
        stmt = con.createStatement();

        // Construct the SQL query based on the search criteria
        String query = "SELECT * FROM cred WHERE 1=1"; // 1=1 is used as a placeholder for dynamic conditions

        if (!employeeID.isEmpty()) {
            query += " AND EmployeeID = '" + employeeID + "'";
        }
        if (!firstName.isEmpty()) {
            query += " AND emp_fname LIKE '%" + firstName + "%'";
        }
        if (!lastName.isEmpty()) {
            query += " AND emp_lname LIKE '%" + lastName + "%'";
        }
        
        rs = stmt.executeQuery(query);

        // Clear existing table data
        model.setRowCount(0);

        boolean foundAgent = false; // Flag to check if any agents were found

        // Add search results to the table model
        while (rs.next()) {
           

            // Check if the position is "Agent"
            if (rs.getString("Position").equals("Agent")) {
                foundAgent = true; // Set flag to true if an agent is found
            }
            if(rs.getString("Position").equals("Agent")){
                 model.addRow(new Object[]{
                    rs.getInt("EmployeeID"),
                    rs.getString("emp_fname"),
                    rs.getString("emp_lname"),
                    rs.getString("cEmail"),
                    rs.getString("LOB"),
                    rs.getString("OM"),
                    rs.getString("Position"),
                    rs.getString("Status")
            });
            }

        }

        // If no agents were found, show a JOptionPane
        if (!foundAgent) {
            JOptionPane.showMessageDialog(this, "No Agents Found", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            loadData();
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    
     private void loadData() {
        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            
             rs = stmt.executeQuery("SELECT COUNT(DISTINCT EmployeeID) AS dayInCount FROM dtr WHERE status = 'Day In' AND DATE(timestamp) = CURRENT_DATE()");

 
            
            rs = stmt.executeQuery("SELECT * from cred WHERE Position = 'Agent'");

            // Create a DefaultTableModel with column names
            String[] columnNames = {"Employee Number", "First Name", "Last Name", "Company email", "LOB", "Operation Manager", "Position", "Status"};
            model = new DefaultTableModel(columnNames, 0);

            while (rs.next()) {
        model.addRow(new Object[]{
            rs.getInt("EmployeeID"),
            rs.getString("emp_fname"),
            rs.getString("emp_lname"),
            rs.getString("cEmail"),
            rs.getString("LOB"),
            rs.getString("OM"),
            rs.getString("Position"), // corrected typo here
            rs.getString("Status")
        });
            }

            // Once all data is loaded, set the model to your JTable
            jTable2.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
