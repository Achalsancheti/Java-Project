/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.VaccineManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FactoryEnterprise;
import Business.MainUserAccount.MainUserAccount;
import Business.Network.Network;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.WorkQueue.SendDroneWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Achal Sancheti
 */
public class EmergencyVaccineJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private MainUserAccount userAccount;
    private Organization organization;
    private EcoSystem business;
    private Timer t = null;
    private int count = 0;

    /**
     * Creates new form EmergencyVaccineJPanel
     */
    public EmergencyVaccineJPanel(JPanel userProcessContainer, MainUserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.organization = organization;
        this.business = business;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof SendDroneWorkRequest) {

                Object[] row = new Object[6];

                String vaccine = ((SendDroneWorkRequest) request).getVaccineName();
                row[0] = request;
                int quantity = ((SendDroneWorkRequest) request).getQuantity();
                row[1] = quantity;
                row[2] = request.getReceiver();
                row[3] = request.getStatus();
                row[4] = request.getDate();
                row[5] = request.getTime();

                model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vaccinenameTextField = new javax.swing.JTextField();
        quantitySpinner = new javax.swing.JSpinner();
        sendButton = new javax.swing.JButton();
        ProgressBar = new javax.swing.JProgressBar();
        backButton = new javax.swing.JButton();
        drone = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        changestatusButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Quantity", "Receiver", "Status", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 721, 150));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Vaccine Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Quantity:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));
        add(vaccinenameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 130, -1));
        add(quantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 60, 30));

        sendButton.setBackground(new java.awt.Color(0, 0, 0));
        sendButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sendButton.setForeground(new java.awt.Color(255, 255, 255));
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 170, 30));

        ProgressBar.setStringPainted(true);
        add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 230, -1));

        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("<<Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, 33));

        drone.setBackground(new java.awt.Color(224, 237, 46));
        drone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        drone.setText("See Drone Location");
        drone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                droneActionPerformed(evt);
            }
        });
        add(drone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, -1, 33));

        jButton1.setBackground(new java.awt.Color(224, 237, 46));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("See Progress");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, 150, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Factory");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Hospital");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 60, -1, -1));

        changestatusButton.setBackground(new java.awt.Color(0, 0, 0));
        changestatusButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changestatusButton.setForeground(new java.awt.Color(255, 255, 255));
        changestatusButton.setText("Change Status");
        changestatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changestatusButtonActionPerformed(evt);
            }
        });
        add(changestatusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 150, 33));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 600, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/drone.jpg"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 770, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        if (!vaccinenameTextField.getText().isEmpty()) {
            String vaccine = vaccinenameTextField.getText();
            int purchaseQuantity = (Integer) quantitySpinner.getValue();
            if (purchaseQuantity <= 0) {
                JOptionPane.showMessageDialog(this, "Please Provide Quantity", "Warning", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String date = new java.text.SimpleDateFormat("MM/dd/yyyy").format(new Date());
            String time = new java.text.SimpleDateFormat("h:mm:ss a").format(new Date());

            SendDroneWorkRequest vaccineo = new SendDroneWorkRequest();
            vaccineo.setVaccineName(vaccine);
            vaccineo.setQuantity(purchaseQuantity);
            vaccineo.setStatus("Request Sent");
            vaccineo.setSender(userAccount);
            vaccineo.setDate(date);
            vaccineo.setTime(time);

            Enterprise ent = null;
            Organization org = null;
            for (Network network : business.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enterprise instanceof FactoryEnterprise) {
                        ent = enterprise;
                    }

                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof ManagerOrganization) {
                            org = organization;
                            break;
                        }
                    }
                }
            }

            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(vaccineo);
                userAccount.getWorkQueue().getWorkRequestList().add(vaccineo);
            }

            JOptionPane.showMessageDialog(null, "Request Has Been Sent To Factory Manager", "Success", JOptionPane.INFORMATION_MESSAGE);
            vaccinenameTextField.setText("");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter All The Vaccine Name", "Error", JOptionPane.ERROR_MESSAGE);
            vaccinenameTextField.setText("");
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void droneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_droneActionPerformed
     
        DroneJFrame jf = new DroneJFrame();
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setSize(1070,300);
        jf.setLocation(180,200);
        jf.setVisible(true);
        
    }//GEN-LAST:event_droneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        t = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                ProgressBar.setValue(count);
                if (ProgressBar.getValue() < 100) {
                    ProgressBar.setValue(ProgressBar.getValue() + 8);
                    ProgressBar.setForeground(Color.BLUE);
                }
                if (ProgressBar.getValue() == 100) {
                    t.stop();
                    ProgressBar.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Drone Has Been Reached To The Hospital");
                }
            }
        });
        t.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void changestatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changestatusButtonActionPerformed
        int selectedRow = orderTable.getSelectedRow();

        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) orderTable.getValueAt(selectedRow, 0);
            if (request.getStatus().equalsIgnoreCase("Received")) {
                JOptionPane.showMessageDialog(null, "Vaccine Already Received.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                request.setStatus("Received");
                populateTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Choose A Vaccine To Process.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_changestatusButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton backButton;
    private javax.swing.JButton changestatusButton;
    private javax.swing.JButton drone;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField vaccinenameTextField;
    // End of variables declaration//GEN-END:variables
}
