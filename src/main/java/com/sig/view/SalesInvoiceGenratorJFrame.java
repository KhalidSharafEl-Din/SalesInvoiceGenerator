package com.sig.view;

import com.sig.controller.ActionHandler;

import javax.swing.*;

public class SalesInvoiceGenratorJFrame extends javax.swing.JFrame {

    /**
     * Creates new form SalesInvoiceGenratorJFrame
     */
    public SalesInvoiceGenratorJFrame() {
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

        invoiceHeaderScrollPane = new javax.swing.JScrollPane();
        invoiceHeaderTable = new javax.swing.JTable();
        newInvoiceButton = new javax.swing.JButton();
        newInvoiceButton.addActionListener(handler);
        deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(handler);
        invoiceNumLabelH = new javax.swing.JLabel();
        customerLabelH = new javax.swing.JLabel();
        invoiceDateLabelH = new javax.swing.JLabel();
        invoiceTotalLabelH = new javax.swing.JLabel();
        invoiceNumLabelC = new javax.swing.JLabel();
        customerLabelC = new javax.swing.JLabel();
        invoiceDateLabelC = new javax.swing.JLabel();
        invoiceTotalLabelC = new javax.swing.JLabel();
        inoviceLinesScrollPane = new javax.swing.JScrollPane();
        invoiceLinesTable = new javax.swing.JTable();
        deleteItemButton = new javax.swing.JButton();
        deleteItemButton.addActionListener(handler);
        newItemButton = new javax.swing.JButton();
        newItemButton.addActionListener(handler);
        Separator = new javax.swing.JSeparator();
        myMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        openMenuItem.addActionListener(handler);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(handler);
        exitMenuItem = new javax.swing.JMenuItem();
        exitMenuItem.addActionListener(handler);
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        invoiceHeaderScrollPane.setViewportView(invoiceHeaderTable);

        newInvoiceButton.setText("New Invoice");
        newInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInvoiceButtonActionPerformed(evt);
            }
        });

        deleteInvoiceButton.setText("Delete Invoice");

        invoiceNumLabelH.setText("Invoice Num");

        customerLabelH.setText("Customer");

        invoiceDateLabelH.setText("Date");

        invoiceTotalLabelH.setText("Total");

        invoiceNumLabelC.setText("jLabel5");

        customerLabelC.setText("jLabel6");

        invoiceDateLabelC.setText("jLabel7");

        invoiceTotalLabelC.setText("jLabel8");

        invoiceLinesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        inoviceLinesScrollPane.setViewportView(invoiceLinesTable);

        deleteItemButton.setText("Delete Item");
        deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemButtonActionPerformed(evt);
            }
        });

        newItemButton.setText("New Item");
        newItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemButtonActionPerformed(evt);
            }
        });

        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openMenuItem.setText("Load File");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.setText("Save File");
        fileMenu.add(saveMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        myMenuBar.add(fileMenu);

        editMenu.setText("Edit");
        myMenuBar.add(editMenu);

        setJMenuBar(myMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoiceHeaderScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceNumLabelH)
                                    .addComponent(customerLabelH)
                                    .addComponent(invoiceDateLabelH)
                                    .addComponent(invoiceTotalLabelH))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceTotalLabelC)
                                    .addComponent(invoiceDateLabelC)
                                    .addComponent(customerLabelC)
                                    .addComponent(invoiceNumLabelC))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(inoviceLinesScrollPane)
                            .addComponent(Separator)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newInvoiceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteInvoiceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newItemButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteItemButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invoiceHeaderScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceNumLabelH)
                            .addComponent(invoiceNumLabelC))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerLabelH)
                            .addComponent(customerLabelC))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceDateLabelH)
                            .addComponent(invoiceDateLabelC))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceTotalLabelH)
                            .addComponent(invoiceTotalLabelC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(inoviceLinesScrollPane)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(newInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newItemButton)
                    .addComponent(deleteItemButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void newInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newInvoiceButtonActionPerformed

    private void newItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newItemButtonActionPerformed

    private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteItemButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SalesInvoiceGenratorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGenratorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGenratorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGenratorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesInvoiceGenratorJFrame().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separator;
    private javax.swing.JLabel customerLabelC;
    private javax.swing.JLabel customerLabelH;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane inoviceLinesScrollPane;
    private javax.swing.JLabel invoiceDateLabelC;
    private javax.swing.JLabel invoiceDateLabelH;
    private javax.swing.JScrollPane invoiceHeaderScrollPane;
    private javax.swing.JTable invoiceHeaderTable;
    private javax.swing.JTable invoiceLinesTable;
    private javax.swing.JLabel invoiceNumLabelC;
    private javax.swing.JLabel invoiceNumLabelH;
    private javax.swing.JLabel invoiceTotalLabelC;
    private javax.swing.JLabel invoiceTotalLabelH;
    private javax.swing.JMenuBar myMenuBar;
    private javax.swing.JButton newInvoiceButton;
    private javax.swing.JButton newItemButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    private ActionHandler handler = new ActionHandler();

}