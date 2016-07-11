/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.MainUserAccount.MainUserAccount;
import Business.Organization.DoctorOrganization;
import Business.WorkQueue.SmartWatchWorkRequest;
import Business.WorkQueue.WorkRequest;
import static UserInterface.DoctorRole.ChatDoctorJFrame.s;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.x.XFullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Achal Sancheti
 */
public class ManageSmartWatchJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    WorkRequest request;
    DoctorOrganization doctorOrganization;
    MainUserAccount userAccount;
    Enterprise enterprise;
    EcoSystem business;

    /**
     * Creates new form ManageSmartWatch
     */
    public ManageSmartWatchJPanel(JPanel userProcessContainer, Enterprise enterprise,WorkRequest request, MainUserAccount userAccount,DoctorOrganization doctorOrganization,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.doctorOrganization = doctorOrganization;
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
        DefaultTableModel model = (DefaultTableModel) vitalTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request: doctorOrganization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[7];
            
            if(request instanceof SmartWatchWorkRequest){
            int respiratory = ((SmartWatchWorkRequest)request).getRespiratoryRate();
            row[0] = respiratory;
            int heart = ((SmartWatchWorkRequest)request).getHeartRate();
            row[1] = heart;
            int blood = ((SmartWatchWorkRequest)request).getBloodPressure();
            row[2] = blood;
            float weight = ((SmartWatchWorkRequest)request).getWeight();
            row[3] = weight;
            String condition = ((SmartWatchWorkRequest)request).getCondition();
            row[4] = condition;
            row[5] = request.getDate();
            row[6] = request.getTime();
            
            model.addRow(row);}
        }
    }
    
    private void createChart()
    {
        DefaultCategoryDataset vitalSignDataset=new DefaultCategoryDataset();
        int selectedRow = vitalTable.getSelectedRow();

        for (WorkRequest vitalSign : doctorOrganization.getWorkQueue().getWorkRequestList()) {
            if(vitalSign instanceof SmartWatchWorkRequest){
            vitalSignDataset.addValue(((SmartWatchWorkRequest)vitalSign).getRespiratoryRate(),"RR", vitalSign.getDate());
            vitalSignDataset.addValue(((SmartWatchWorkRequest)vitalSign).getHeartRate(),"HR", vitalSign.getDate());
            vitalSignDataset.addValue(((SmartWatchWorkRequest)vitalSign).getBloodPressure(),"BP", vitalSign.getDate());
            vitalSignDataset.addValue(((SmartWatchWorkRequest)vitalSign).getWeight(),"WT", vitalSign.getDate());
            }
        JFreeChart vitalSignChart= ChartFactory.createBarChart3D("Vital Sign Chart", "Time Stamp", "Rate", vitalSignDataset, PlotOrientation.VERTICAL, true, false, false);
        vitalSignChart.setBackgroundPaint(Color.white);
        CategoryPlot vitalSignChartPlot = vitalSignChart.getCategoryPlot();
        vitalSignChartPlot.setBackgroundPaint(Color.lightGray);    
        
        org.jfree.chart.axis.CategoryAxis vitalSignDomainAxis = vitalSignChartPlot.getDomainAxis();
        vitalSignDomainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        NumberAxis vitalSignRangeAxis = (NumberAxis) vitalSignChartPlot.getRangeAxis();
        vitalSignRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        ChartFrame chartFrame = new ChartFrame("Chart", vitalSignChart);
        chartFrame.setVisible(true);
        chartFrame.setSize(500, 500);

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
        vitalTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        backButton = new javax.swing.JButton();
        sendvideoButton = new javax.swing.JButton();
        viewvideoButton = new javax.swing.JButton();
        viewlocationButton = new javax.swing.JButton();
        sendmessageButton = new javax.swing.JButton();
        seeappointmentButton = new javax.swing.JButton();
        chatButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vitalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Respiratory Rate", "Heart Rate", "Blood Pressure", "Weight", "Condition", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vitalTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 790, 150));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Respiratory Rate:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Heart Rate:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Blood Pressure:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Weight:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Lower Limit");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Upper Limit");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, -1, -1));

        lable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable1.setForeground(new java.awt.Color(0, 0, 153));
        lable1.setText("jLabel10");
        add(lable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, -1, -1));

        lable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable2.setForeground(new java.awt.Color(0, 0, 153));
        lable2.setText("jLabel11");
        add(lable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 160, -1, -1));

        lable3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable3.setForeground(new java.awt.Color(0, 0, 153));
        lable3.setText("jLabel12");
        add(lable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 190, -1, -1));

        lable4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable4.setForeground(new java.awt.Color(0, 0, 153));
        lable4.setText("jLabel13");
        add(lable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 190, -1, -1));

        lable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable5.setForeground(new java.awt.Color(0, 0, 153));
        lable5.setText("jLabel14");
        add(lable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 220, -1, -1));

        lable6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable6.setForeground(new java.awt.Color(0, 0, 153));
        lable6.setText("jLabel15");
        add(lable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 220, -1, -1));

        lable7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable7.setForeground(new java.awt.Color(0, 0, 153));
        lable7.setText("jLabel16");
        add(lable7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 250, -1, -1));

        lable8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lable8.setForeground(new java.awt.Color(0, 0, 153));
        lable8.setText("jLabel17");
        add(lable8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 250, -1, -1));

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

        sendvideoButton.setBackground(new java.awt.Color(0, 0, 0));
        sendvideoButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sendvideoButton.setForeground(new java.awt.Color(255, 255, 255));
        sendvideoButton.setText("Send Video To Patient");
        sendvideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendvideoButtonActionPerformed(evt);
            }
        });
        add(sendvideoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(971, 390, 250, 33));

        viewvideoButton.setBackground(new java.awt.Color(0, 0, 0));
        viewvideoButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewvideoButton.setForeground(new java.awt.Color(255, 255, 255));
        viewvideoButton.setText("View Patient's Video");
        viewvideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewvideoButtonActionPerformed(evt);
            }
        });
        add(viewvideoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 250, 33));

        viewlocationButton.setBackground(new java.awt.Color(0, 0, 0));
        viewlocationButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewlocationButton.setForeground(new java.awt.Color(255, 255, 255));
        viewlocationButton.setText("View Patient's Location");
        viewlocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewlocationButtonActionPerformed(evt);
            }
        });
        add(viewlocationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 450, 250, 33));

        sendmessageButton.setBackground(new java.awt.Color(0, 0, 0));
        sendmessageButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sendmessageButton.setForeground(new java.awt.Color(255, 255, 255));
        sendmessageButton.setText("Send Emergency Message");
        sendmessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendmessageButtonActionPerformed(evt);
            }
        });
        add(sendmessageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 510, 250, 30));

        seeappointmentButton.setBackground(new java.awt.Color(0, 0, 0));
        seeappointmentButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seeappointmentButton.setForeground(new java.awt.Color(255, 255, 255));
        seeappointmentButton.setText("See Appointment");
        seeappointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeappointmentButtonActionPerformed(evt);
            }
        });
        add(seeappointmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 570, 250, 33));

        chatButton.setBackground(new java.awt.Color(0, 0, 0));
        chatButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chatButton.setForeground(new java.awt.Color(255, 255, 255));
        chatButton.setText("Chat With Patient");
        chatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatButtonActionPerformed(evt);
            }
        });
        add(chatButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 220, 33));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void sendvideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendvideoButtonActionPerformed
        int dialogButton = JOptionPane.YES_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would You Like To Send The Video?");
        if(dialogResult==JOptionPane.YES_OPTION){
        JOptionPane.showMessageDialog(null, "Video Has Been Successfully Sent To Patient","Success",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_sendvideoButtonActionPerformed

    private void viewvideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewvideoButtonActionPerformed
        int dialogButton = JOptionPane.YES_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would You Like To See The Video?");
        if(dialogResult==JOptionPane.YES_OPTION){
        Canvas c = new Canvas();
        c.setBackground(Color.black);

        JFrame f = new JFrame();
        f.add(c);
        f.setLocation(360,200);
        f.setSize(600, 450);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setVisible(true);

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        MediaPlayerFactory mpf = new MediaPlayerFactory();

        EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new XFullScreenStrategy(f));

        emp.setVideoSurface(mpf.newVideoSurface(c));

        emp.setEnableMouseInputHandling(false);
        emp.setEnableKeyInputHandling(false);

        String file = "C:\\achal.mp4";
        emp.prepareMedia(file);
        emp.play();
        }
    }//GEN-LAST:event_viewvideoButtonActionPerformed

    private void viewlocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewlocationButtonActionPerformed
        int dialogButton = JOptionPane.YES_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would You Like To See The Patient Location??");
        if(dialogResult==JOptionPane.YES_OPTION){
        if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Northeastern+University/@42.3398106,-71.0913604,17z/data=!3m1!4b1!4m2!3m1!1s0x89e37a1999cf5ce1:0xc97b00e66522b98c"));
            } catch (URISyntaxException ex) {
                Logger.getLogger(CalculateVitalSignJPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CalculateVitalSignJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_viewlocationButtonActionPerformed

    private void sendmessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendmessageButtonActionPerformed
        
            DoctorMessageJPanel messageJPanel = new DoctorMessageJPanel(userProcessContainer, userAccount,enterprise,business);
            userProcessContainer.add("MessageJPanel", messageJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        
    }//GEN-LAST:event_sendmessageButtonActionPerformed

    private void seeappointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeappointmentButtonActionPerformed
            SeeAppointmentJPanel seeAppointmentJPanel = new SeeAppointmentJPanel(userProcessContainer, userAccount,enterprise,doctorOrganization);
            userProcessContainer.add("SeeAppointmentJPanel", seeAppointmentJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
    }//GEN-LAST:event_seeappointmentButtonActionPerformed

    private void chatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatButtonActionPerformed
        int dialogButton = JOptionPane.YES_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would You Like To Do Chat With Doctor?");
        if(dialogResult==JOptionPane.YES_OPTION){
            ChatDoctorJFrame cpjf = new ChatDoctorJFrame();
            cpjf.setVisible(true);
            
            cpjf.setLocation(360,200);
            cpjf.setSize(550,500);
            cpjf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    
    }//GEN-LAST:event_chatButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JButton backButton;
    private javax.swing.JButton chatButton;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JButton seeappointmentButton;
    private javax.swing.JButton sendmessageButton;
    private javax.swing.JButton sendvideoButton;
    private javax.swing.JButton viewlocationButton;
    private javax.swing.JButton viewvideoButton;
    private javax.swing.JTable vitalTable;
    // End of variables declaration//GEN-END:variables
}
