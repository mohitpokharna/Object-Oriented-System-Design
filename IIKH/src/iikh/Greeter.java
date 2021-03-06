/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

import java.awt.event.FocusAdapter;

/**
 *
 * @author mohit
 */
public class Greeter extends javax.swing.JFrame {

    /**
     * Creates new form Greeter
     */
    public Greeter() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        browseDatabase = new javax.swing.JButton();
        editRecipe = new javax.swing.JButton();
        createPlan = new javax.swing.JButton();
        reviewPlan = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to IIKH");
        jLabel1.setMaximumSize(new java.awt.Dimension(141, 121));
        jLabel1.setMinimumSize(new java.awt.Dimension(141, 121));
        jLabel1.setPreferredSize(new java.awt.Dimension(141, 121));
        getContentPane().add(jLabel1);

        browseDatabase.setText("Browse Database");
        browseDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseDatabaseActionPerformed(evt);
            }
        });
        getContentPane().add(browseDatabase);

        editRecipe.setText("Add/ Edit Recipe");
        editRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRecipeActionPerformed(evt);
            }
        });
        getContentPane().add(editRecipe);

        createPlan.setText("Create Plan");
        createPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlanActionPerformed(evt);
            }
        });
        getContentPane().add(createPlan);

        reviewPlan.setText("Review Plan ");
        reviewPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewPlanActionPerformed(evt);
            }
        });
        getContentPane().add(reviewPlan);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseDatabaseActionPerformed
        // TODO add your handling code here:
        DatabaseManager dm = new DatabaseManager();
        dm.setVisible(true);
        dm.addMeal.setVisible(false);
        dm.editMeal.setVisible(false);
        dm.deleteMeal.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_browseDatabaseActionPerformed

    private void createPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlanActionPerformed
        // TODO add your handling code here:
        PlanManager pm = new PlanManager();
        pm.setVisible(true);
        pm.nameList.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_createPlanActionPerformed

    private void editRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRecipeActionPerformed
        // TODO add your handling code here:
        DatabaseManager dm = new DatabaseManager();
        dm.setVisible(true);
        dm.editMeal.addFocusListener(new FocusAdapter() {});
        this.setVisible(false);
    }//GEN-LAST:event_editRecipeActionPerformed

    private void reviewPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewPlanActionPerformed
        // TODO add your handling code here:
        PlanManager pm = new PlanManager();
        pm.setVisible(true);
        pm.planName.setVisible(false);
        pm.Back.setEnabled(true);
        pm.savePlan.setVisible(false);
//        pm.reviewPlan.addFocusListener(new FocusAdapter() {});
//        this.setVisible(false);
    }//GEN-LAST:event_reviewPlanActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Greeter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Greeter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Greeter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Greeter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Greeter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseDatabase;
    private javax.swing.JButton createPlan;
    private javax.swing.JButton editRecipe;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reviewPlan;
    // End of variables declaration//GEN-END:variables
}
