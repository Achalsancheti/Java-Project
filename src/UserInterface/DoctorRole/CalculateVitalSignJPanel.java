/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.MainUserAccount.MainUserAccount;
import Business.WorkQueue.VitalSignWorkRequest;
import Business.WorkQueue.DoctorTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Achal Sancheti
 */
public class CalculateVitalSignJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    WorkRequest request;
    Enterprise enterprise;
    MainUserAccount userAccount;
    EcoSystem business;

    /**
     * Creates new form CalculateVitalSignJPanel
     */
    public CalculateVitalSignJPanel(JPanel userProcessContainer,Enterprise enterprise,MainUserAccount userAccount,WorkRequest request,EcoSystem business) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.request=request;
        JFrame f = new JFrame();
        this.userAccount=userAccount;
        this.enterprise=enterprise;
        this.business=business;
        name.setText(request.getName());
        age.setText(String.valueOf(request.getAge()));
        vitalrange();
        populateTable();
    }
    
    public void vitalrange(){
        
        if((request.getAge()>0) && (request.getAge()<=10)){
            lable1.setText("20");
            lable2.setText("30");
            lable3.setText("80");
            lable4.setText("110");
            lable5.setText("80");
            lable6.setText("110");
            lable7.setText("22");
            lable8.setText("31");
        }
        
        if((request.getAge()>10) && (request.getAge()<=20)){
            lable1.setText("20");
            lable2.setText("30");
            lable3.setText("70");
            lable4.setText("120");
            lable5.setText("80");
            lable6.setText("110");
            lable7.setText("31");
            lable8.setText("40");
        }
        
        if((request.getAge()>20) && (request.getAge()<=30)){
            lable1.setText("15");
            lable2.setText("25");
            lable3.setText("60");
            lable4.setText("110");
            lable5.setText("80");
            lable6.setText("120");
            lable7.setText("41");
            lable8.setText("92");
        }
        
        if((request.getAge()>30)){
            lable1.setText("12");
            lable2.setText("20");
            lable3.setText("55");
            lable4.setText("105");
            lable5.setText("110");
            lable6.setText("120");
            lable7.setText("110");
            lable8.setText("180");
        }
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request: userAccount.getWorkQueue().getWorkRequestList()){
            if(request instanceof VitalSignWorkRequest){
            Object[] row = new Object[7];
            
            int respiratory = ((VitalSignWorkRequest)request).getRespiratoryRate();
            row[0] = respiratory;
            int heart = ((VitalSignWorkRequest)request).getHeartRate();
            row[1] = heart;
            int blood = ((VitalSignWorkRequest)request).getBloodPressure();
            row[2] = blood;
            float weight = ((VitalSignWorkRequest)request).getWeight();
            row[3] = weight;
            String condition = ((VitalSignWorkRequest)request).getCondition();
            row[4] = condition;
            row[5] = request.getDate();
            row[6] = request.getTime();
            
            model.addRow(row);
        }}
    }
    
    private void createChart()
    {
        DefaultCategoryDataset vitalSignDataset=new DefaultCategoryDataset();
        int selectedRow = Table.getSelectedRow();
        
//        for (WorkRequest vitalSign : userAccount.getWorkQueue().getWorkRequestList()) {
//        VitalSignWorkRequest vital = (VitalSignWorkRequest) Table.getValueAt(selectedRow, 0);
            
        for (WorkRequest vitalSign : userAccount.getWorkQueue().getWorkRequestList()) {
            if(vitalSign instanceof VitalSignWorkRequest){
            vitalSignDataset.setValue(((VitalSignWorkRequest)vitalSign).getRespiratoryRate(),"RR", vitalSign.getDate());
            vitalSignDataset.setValue(((VitalSignWorkRequest)vitalSign).getHeartRate(),"HR", vitalSign.getDate());
            vitalSignDataset.setValue(((VitalSignWorkRequest)vitalSign).getBloodPressure(),"BP", vitalSign.getDate());
            vitalSignDataset.setValue(((VitalSignWorkRequest)vitalSign).getWeight(),"WT", vitalSign.getDate());
            }
            JFreeChart vitalSignChart= ChartFactory.createBarChart3D("Vital Sign Chart", "Time Stamp", "Rate", vitalSignDataset, PlotOrientation.VERTICAL, true, false, false);
        vitalSignChart.setBackgroundPaint(Color.white);
        CategoryPlot vitalSignChartPlot = vitalSignChart.getCategoryPlot();
        vitalSignChartPlot.setBackgroundPaint(Color.lightGray);    
        
        CategoryPlot P=vitalSignChart.getCategoryPlot();
        P.setRangeGridlinePaint(Color.BLUE);
        
        ChartFrame frame=new ChartFrame("Vitalsign Bar Chart", vitalSignChart);
        frame.setVisible(true);
        frame.setSize(500, 500);

    }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        calculateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lable1 = new javax.swing.JLabel();
        lable2 = new javax.swing.JLabel();
        lable3 = new javax.swing.JLabel();
        lable4 = new javax.swing.JLabel();
        lable5 = new javax.swing.JLabel();
        lable6 = new javax.swing.JLabel();
        lable7 = new javax.swing.JLabel();
        lable8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        viewbargraphButton = new javax.swing.JButton();
        ordervaccineButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Respiratory Rate", "Heart Rate", "Blood Pressure", "Weight", "Condition", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setPreferredWidth(100);
            Table.getColumnModel().getColumn(1).setPreferredWidth(75);
            Table.getColumnModel().getColumn(2).setPreferredWidth(90);
            Table.getColumnModel().getColumn(3).setPreferredWidth(75);
            Table.getColumnModel().getColumn(4).setPreferredWidth(85);
            Table.getColumnModel().getColumn(5).setPreferredWidth(85);
            Table.getColumnModel().getColumn(6).setPreferredWidth(85);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, 770, 130));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Patient Name :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 153));
        name.setText("jLabel1");
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        age.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        age.setText("jLabel1");
        add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("(Age-");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText(")");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 10, -1));

        calculateButton.setBackground(new java.awt.Color(0, 0, 0));
        calculateButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        calculateButton.setForeground(new java.awt.Color(255, 255, 255));
        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        add(calculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 310, 130, 33));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Respiratory Rate:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Heart Rate:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Blood Pressure:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Weight:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Lower Limit");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Upper Limit");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        lable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable1.setForeground(new java.awt.Color(0, 0, 153));
        lable1.setText("jLabel10");
        add(lable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        lable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable2.setForeground(new java.awt.Color(0, 0, 153));
        lable2.setText("jLabel11");
        add(lable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        lable3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable3.setForeground(new java.awt.Color(0, 0, 153));
        lable3.setText("jLabel12");
        add(lable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        lable4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable4.setForeground(new java.awt.Color(0, 0, 153));
        lable4.setText("jLabel13");
        add(lable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        lable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable5.setForeground(new java.awt.Color(0, 0, 153));
        lable5.setText("jLabel14");
        add(lable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, -1));

        lable6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable6.setForeground(new java.awt.Color(0, 0, 153));
        lable6.setText("jLabel15");
        add(lable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        lable7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable7.setForeground(new java.awt.Color(0, 0, 153));
        lable7.setText("jLabel16");
        add(lable7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));

        lable8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable8.setForeground(new java.awt.Color(0, 0, 153));
        lable8.setText("jLabel17");
        add(lable8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, -1, 370));

        connectButton.setBackground(new java.awt.Color(0, 0, 0));
        connectButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        connectButton.setForeground(new java.awt.Color(255, 255, 255));
        connectButton.setText("Connect To Patients Smart Watch");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        add(connectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, -1, 40));

        viewbargraphButton.setBackground(new java.awt.Color(0, 0, 0));
        viewbargraphButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewbargraphButton.setForeground(new java.awt.Color(255, 255, 255));
        viewbargraphButton.setText("View Bar Graph");
        viewbargraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbargraphButtonActionPerformed(evt);
            }
        });
        add(viewbargraphButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 250, 40));

        ordervaccineButton.setBackground(new java.awt.Color(0, 0, 0));
        ordervaccineButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ordervaccineButton.setForeground(new java.awt.Color(255, 255, 255));
        ordervaccineButton.setText("Order Vaccine");
        ordervaccineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordervaccineButtonActionPerformed(evt);
            }
        });
        add(ordervaccineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 130, 33));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/smartwatch.jpg"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestLabTestJPanel", new CalculateJPanel(userProcessContainer, userAccount,enterprise,request,business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_calculateButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed

            int dialogButton = JOptionPane.YES_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like To Connect With Patient's Smart Watch?");
            if(dialogResult==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Your Device Is Now Connected With Patient's Smart Watch","Success",JOptionPane.PLAIN_MESSAGE);
            
            connectButton.setVisible(false);
            }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void viewbargraphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbargraphButtonActionPerformed
        
        int selectedRow = Table.getSelectedRow();
        
        int dialogButton = JOptionPane.YES_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would You Like To See The Bar Chart?");
        if(dialogResult==JOptionPane.YES_OPTION){
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        createChart();
        }
    }//GEN-LAST:event_viewbargraphButtonActionPerformed

    private void ordervaccineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordervaccineButtonActionPerformed
            OrderVaccineJPanel orderVaccineJPanel = new OrderVaccineJPanel(userProcessContainer, enterprise, userAccount);
            userProcessContainer.add("OrderVaccineJPanel", orderVaccineJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
    }//GEN-LAST:event_ordervaccineButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JLabel age;
    private javax.swing.JButton backButton;
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lable1;
    private javax.swing.JLabel lable2;
    private javax.swing.JLabel lable3;
    private javax.swing.JLabel lable4;
    private javax.swing.JLabel lable5;
    private javax.swing.JLabel lable6;
    private javax.swing.JLabel lable7;
    private javax.swing.JLabel lable8;
    private javax.swing.JLabel name;
    private javax.swing.JButton ordervaccineButton;
    private javax.swing.JButton viewbargraphButton;
    // End of variables declaration//GEN-END:variables
}
