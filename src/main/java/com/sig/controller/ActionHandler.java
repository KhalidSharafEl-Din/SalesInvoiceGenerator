package com.sig.controller;

import com.sig.model.*;
import com.sig.view.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;

public class ActionHandler implements ActionListener, ListSelectionListener {

    private SalesInvoiceGeneratorJFrame frame;
    private InvoiceCreation invoiceCreation;
    private LineCreation lineCreation;

    public ActionHandler(SalesInvoiceGeneratorJFrame frame){
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Save File":
                System.out.println("Save File");
                saveFile();
                break;
            case "Load File":
                System.out.println("Load File");
                LoadFile();
                break;
            case "Exit":
                System.out.println("Exit Program");
                System.exit(0);
                break;
            case "New Invoice":
                System.out.println("New Invoice");
                createNewInvoice();
                break;
            case "Delete Invoice":
                System.out.println("Delete Invoice");
                deleteInvoice();
                break;
            case "New Item":
                System.out.println("New Item");
                createNewItem();
                break;
            case "Delete Item":
                System.out.println("Delete Item");
                deleteItem();
                break;
            case "cancelLineCreationButton" :
                cancelLineCreation();
                break;
            case "confirmLineCreationButton" :
                confirmLineCreation();
                break;
            case "cancelInvoiceCreationButton" :
                cancelInvoiceCreation();
                break;
            case "confirmInvoiceCreationButton" :
                confirmInvoiceCreation();
                break;
            default:
                System.out.println("Action!!!");
        }
    }
    public void valueChanged(ListSelectionEvent e){
        System.out.println("Hello!!");
        int selectedIndex = frame.getInvoiceHeaderTable().getSelectedRow();
        if(selectedIndex > -1 ) {
            System.out.println("You Selected Row " + selectedIndex);
            InvoiceHeader header = frame.getHeaders().get(selectedIndex);

            frame.getInvoiceNumLabelC().setText("" + header.getInvoiceNum());
            frame.getInvoiceDateLabelC().setText(header.getInvoiceDate());
            frame.getCustomerLabelC().setText(header.getCustomerName());
            frame.getInvoiceTotalLabelC().setText("" + header.getInvoiceTotal());

            linesTableData linesTableData = new linesTableData(header.getInvoiceLines());
            frame.getInvoiceLinesTable().setModel(linesTableData);
            linesTableData.fireTableDataChanged();
        }
    }
    private void saveFile() {
        FileOperations fileIO = new FileOperations();
        JFileChooser fileChooser = new JFileChooser();
        Path headerPath=null;
        Path linesPath=null;
        // Get the path for the invoices header and lines files
        if(fileChooser.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION){
            File headerFile = fileChooser.getSelectedFile();
            headerPath = Paths.get(headerFile.getAbsolutePath());
        }
        if(fileChooser.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION){
            File linesFile = fileChooser.getSelectedFile();
            linesPath = Paths.get(linesFile.getAbsolutePath());
        }

        fileIO.writeFile(frame.getHeaders(), headerPath, linesPath);

    }
    private void LoadFile() {
        FileOperations fileIO = new FileOperations();
        JFileChooser fileChooser = new JFileChooser();
        Path headerPath=null;
        Path linesPath=null;
        // Get the path for the invoices header and lines files
        if(fileChooser.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION){
            File headerFile = fileChooser.getSelectedFile();
            headerPath = Paths.get(headerFile.getAbsolutePath());
        }
        if(fileChooser.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION){
            File linesFile = fileChooser.getSelectedFile();
            linesPath = Paths.get(linesFile.getAbsolutePath());
        }
        // use the fileIO to parse the data and return an array list containing the data
        ArrayList<InvoiceHeader> headers = fileIO.readFile(headerPath, linesPath);
        System.out.println(headers);
        // Update the table on the screen
        frame.setHeaders(headers);
        invoicesTableData invoicesTableData = new invoicesTableData(headers);
        frame.setInvoicesTableData(invoicesTableData);
        frame.getInvoiceHeaderTable().setModel(invoicesTableData);
        frame.getInvoicesTableData().fireTableDataChanged();
    }
    private void createNewInvoice() {
        invoiceCreation = new InvoiceCreation(frame, true);
        invoiceCreation.setVisible(true);
    }
    private void deleteInvoice() {
        // Get the Invoice Selected
        int selectedIndex = frame.getInvoiceHeaderTable().getSelectedRow();
        // Remove it from the ArrayList
        frame.getHeaders().remove(selectedIndex);
        // Update the invoices numbers to avoid gaps in the table
        for (int i = selectedIndex; i < frame.getHeaders().size(); i++) {
            frame.getHeaders().get(i).setInvoiceNum(i+1);
        }
        // Update tables
        frame.getInvoicesTableData().fireTableDataChanged();
    }
    private void createNewItem() {
        lineCreation = new LineCreation(frame, true);
        lineCreation.setVisible(true);
    }
    private void deleteItem() {
        // Get the Invoice Selected
        int selectedIndexItem = frame.getInvoiceLinesTable().getSelectedRow();
        int selectedIndexInvoice = frame.getInvoiceHeaderTable().getSelectedRow();
        // Remove it from the ArrayList
        if(selectedIndexItem >-1 && selectedIndexInvoice >-1){
            frame.getHeaders().get(selectedIndexInvoice).removeInvoiceItem(selectedIndexItem);
        }
        // Update the itemNumbers for the rest of the items
        for (int i = selectedIndexItem; i < frame.getHeaders().get(selectedIndexInvoice).getInvoiceLines().size(); i++) {
            frame.getHeaders().get(selectedIndexInvoice).getInvoiceLines().get(i).setItemNum(i+1);
        }

        // Update tables
        linesTableData linesTableData = (linesTableData) frame.getInvoiceLinesTable().getModel();
        linesTableData.fireTableDataChanged();
        frame.getInvoicesTableData().fireTableDataChanged();
    }
    private void confirmInvoiceCreation() {
        String date = invoiceCreation.getCreationDateTextField().getText();
        String customer = invoiceCreation.getCustomerNameTextField().getText();
        int num = frame.getNextInvoiceNum();
        InvoiceHeader head = new InvoiceHeader(num, customer, date);
        frame.getHeaders().add(head);
        frame.getInvoicesTableData().fireTableDataChanged();

        invoiceCreation.setVisible(false);
        invoiceCreation.dispose();
        invoiceCreation = null;
    }
    private void cancelInvoiceCreation() {
        invoiceCreation.setVisible(false);
        invoiceCreation.dispose();
        invoiceCreation = null;
    }
    private void confirmLineCreation() {
        String itemName = lineCreation.getItemNameTextField().getText();
        double price = Double.parseDouble(lineCreation.getItemPriceTextField().getText());
        int count = Integer.parseInt(lineCreation.getItemCountTextField().getText());


        int selectedIndex = frame.getInvoiceHeaderTable().getSelectedRow();
        InvoiceHeader header = frame.getHeaders().get(selectedIndex);

        InvoiceLine line = new InvoiceLine(itemName, count, price,header);
        header.getInvoiceLines().add(line);
        linesTableData linesTableData = (linesTableData) frame.getInvoiceLinesTable().getModel();
        linesTableData.fireTableDataChanged();
        frame.getInvoicesTableData().fireTableDataChanged();

        lineCreation.setVisible(false);
        lineCreation.dispose();
        lineCreation = null;
    }
    private void cancelLineCreation() {
        lineCreation.setVisible(false);
        lineCreation.dispose();
        lineCreation = null;
    }

}
