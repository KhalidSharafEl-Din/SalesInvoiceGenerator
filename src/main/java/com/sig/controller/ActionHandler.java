package com.sig.controller;

import com.sig.model.*;
import com.sig.view.InvoiceCreation;
import com.sig.view.LineCreation;
import com.sig.view.SalesInvoiceGeneratorJFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    // This function is called when any value changes in GUI tables
    public void valueChanged(ListSelectionEvent e){
        // Getting the index of the selected row
        int selectedIndex = frame.getInvoiceHeaderTable().getSelectedRow();
        // Checking if we are out of range or something, [No row Selected]
        if(selectedIndex > -1 ) {
            System.out.println("You Selected Row " + selectedIndex);            // For Debug
            // Getting the corresponding entry in the model
            InvoiceHeader header = frame.getHeaders().get(selectedIndex);
            // Updating the GUI Labels on the side.
            frame.getInvoiceNumLabelC().setText("" + header.getInvoiceNum());
            frame.getInvoiceDateLabelC().setText(header.getInvoiceDate());
            frame.getCustomerLabelC().setText(header.getCustomerName());
            frame.getInvoiceTotalLabelC().setText("" + header.getInvoiceTotal());
            // Updating the tables
            frame.getInvoiceLinesTable().setModel(new linesTableData(header.getInvoiceLines())); setTablePrefSize();
            frame.getLinesTableData().fireTableDataChanged();
        }
    }
    private void saveFile() {
        FileOperations fileIO = new FileOperations();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text or CSV files only", "txt", "text","csv");
        fileChooser.setFileFilter(filter);
        fileChooser.addChoosableFileFilter(filter);
        Path headerPath=null;
        Path linesPath=null;
        // Get the file paths that we want to write to
        if(fileChooser.showSaveDialog(frame)==JFileChooser.APPROVE_OPTION){
            File headerFile = fileChooser.getSelectedFile();
            headerPath = Paths.get(headerFile.getAbsolutePath());
            if(!headerPath.endsWith(".csv")){
                headerPath = Path.of(headerPath + ".csv");
            }
        }
        if(fileChooser.showSaveDialog(frame)==JFileChooser.APPROVE_OPTION){
            File linesFile = fileChooser.getSelectedFile();
            linesPath = Paths.get(linesFile.getAbsolutePath());
            if(!linesPath.endsWith(".csv")){
                linesPath = Path.of(linesPath + ".csv");
            }
        }
        // Getting the data from the frame object and passing along with the file passed to the file writer [CSV]
        fileIO.writeFile(frame.getHeaders(), headerPath, linesPath);

    }
    private void LoadFile() {
        FileOperations fileIO = new FileOperations();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text or CSV files only", "txt", "text","csv");
        fileChooser.setFileFilter(filter);
        fileChooser.addChoosableFileFilter(filter);
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
        ArrayList<InvoiceHeader> headers = null;
        try{headers = fileIO.readFile(headerPath, linesPath);}
        catch (Exception e){JOptionPane.showMessageDialog(null, "Please select the proper files to load, these file are the wrong file format or corrupt files.", "Error", JOptionPane.ERROR_MESSAGE);return;}
        System.out.println(headers);
        // Update the table on the screen
        frame.setHeaders(headers);
        invoicesTableData invoicesTableData = new invoicesTableData(headers);
        frame.setInvoicesTableData(invoicesTableData);
        frame.getInvoicesTableData().fireTableDataChanged();
        frame.getInvoiceHeaderTable().setModel(invoicesTableData);
        setTablePrefSize();
    }
    private void createNewInvoice() {
        // Creating a new dialog box and setting it visible
        invoiceCreation = new InvoiceCreation(frame, true);
        invoiceCreation.setVisible(true);
    }
    private void deleteInvoice() {
        // Get the Invoice Selected
        int selectedIndex = frame.getInvoiceHeaderTable().getSelectedRow();
        if(selectedIndex < 0){JOptionPane.showMessageDialog(null, "Please Select an Invoice From the Invoices Table To Delete", "Error", JOptionPane.ERROR_MESSAGE);return;}
        // Remove it from the ArrayList
        frame.getHeaders().remove(selectedIndex);
        // Update the invoices numbers to avoid gaps in the table
        for (int i = selectedIndex; i < frame.getHeaders().size(); i++) {
            frame.getHeaders().get(i).setInvoiceNum(i+1);
        }
        // Update Table and GUI
        clearLabelsContent();
        frame.getInvoicesTableData().fireTableDataChanged();
        frame.getInvoiceLinesTable().setModel(new linesTableData(new ArrayList<>()));    setTablePrefSize();
        frame.getLinesTableData().fireTableDataChanged();

    }
    private void createNewItem() {
        if(frame.getInvoiceNumLabelC().getText().isBlank()){JOptionPane.showMessageDialog(null, "Please Select an Invoice From the Invoices Table", "Error", JOptionPane.ERROR_MESSAGE);return;}
        // Creating a new dialog box and setting it visible
        lineCreation = new LineCreation(frame, true);
        lineCreation.setVisible(true);
    }
    private void deleteItem() {
        // Get the Invoice Selected
        int selectedIndexItem = -1;
        int selectedIndexInvoice = -1;
        try {
            selectedIndexItem = frame.getInvoiceLinesTable().getSelectedRow();
            selectedIndexInvoice = Integer.parseInt(frame.getInvoiceNumLabelC().getText())-1;
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please Select an Item from any invoice to delete.", "Error", JOptionPane.ERROR_MESSAGE);return;
        }
        // Remove it from the ArrayList
        if(selectedIndexItem >-1 && selectedIndexInvoice >-1){
            frame.getHeaders().get(selectedIndexInvoice).removeInvoiceItem(selectedIndexItem);
        }else{
            JOptionPane.showMessageDialog(null, "Please Select an Item from any invoice to delete.", "Error", JOptionPane.ERROR_MESSAGE);return;
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
        // Get the data from the user input (GUI)
        String date= invoiceCreation.getCreationDateTextField().getText();

        String customer = invoiceCreation.getCustomerNameTextField().getText();
        // If the user didn't enter a date, Use current date.
        if(date.isBlank()){date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));}
        if(customer.isBlank()){customer = "Unknown Customer";}
        // Get the index of this entry
        int num = frame.getNextInvoiceNum();
        // Create a new invoiceHeader with the given information and add it to the Model
        InvoiceHeader head = null;
        try{  head = new InvoiceHeader(num, customer, date); }
        catch (DateTimeParseException e)
        {JOptionPane.showMessageDialog(null, "Please Enter the date as dd-mm-yyyy or leave it blank to enter today's date.", "Error", JOptionPane.ERROR_MESSAGE);return;}
        frame.getHeaders().add(head);
        // Update the table
        frame.getInvoicesTableData().fireTableDataChanged();
        // Close the dialog box
        invoiceCreation.setVisible(false);
        invoiceCreation.dispose();
        invoiceCreation = null;
    }
    private void cancelInvoiceCreation() {
        // Close the dialog box
        invoiceCreation.setVisible(false);
        invoiceCreation.dispose();
        invoiceCreation = null;
    }
    private void confirmLineCreation() {
        String itemName = null;
        double price = 0;
        int count =0;
        try {
            // Get the data from the user input (GUI)
            itemName = lineCreation.getItemNameTextField().getText(); if(itemName.isBlank()) itemName ="Generic Item";
            price = Double.parseDouble(lineCreation.getItemPriceTextField().getText());
            count = Integer.parseInt(lineCreation.getItemCountTextField().getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please Enter Valid Data", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Get the index of the invoice that contains this item
        int selectedIndex = Integer.parseInt(frame.getInvoiceNumLabelC().getText())-1;
        // Getting the parent invoice
        InvoiceHeader header = frame.getHeaders().get(selectedIndex);
        // Creating an invoiceItem then adding it to the list of items
        InvoiceLine line = new InvoiceLine(itemName, count, price,header);
        header.getInvoiceLines().add(line);
        // Updating the tables
        linesTableData linesTableData = (linesTableData) frame.getInvoiceLinesTable().getModel();
        linesTableData.fireTableDataChanged();
        frame.getInvoicesTableData().fireTableDataChanged();
        // Close the dialog box
        lineCreation.setVisible(false);
        lineCreation.dispose();
        lineCreation = null;
    }
    private void cancelLineCreation() {
        // Close the dialog box
        lineCreation.setVisible(false);
        lineCreation.dispose();
        lineCreation = null;
    }

    private void setTablePrefSize(){
        frame.getInvoiceHeaderTable().getColumnModel().getColumn(0).setPreferredWidth(26);
        frame.getInvoiceHeaderTable().getColumnModel().getColumn(1).setPreferredWidth(120);
        frame.getInvoiceHeaderTable().getColumnModel().getColumn(2).setPreferredWidth(225);
        frame.getInvoiceHeaderTable().getColumnModel().getColumn(3).setPreferredWidth(75);

        frame.getInvoiceLinesTable().getColumnModel().getColumn(0).setPreferredWidth(26);
        frame.getInvoiceLinesTable().getColumnModel().getColumn(1).setPreferredWidth(225);
        frame.getInvoiceLinesTable().getColumnModel().getColumn(2).setPreferredWidth(120);
        frame.getInvoiceLinesTable().getColumnModel().getColumn(3).setPreferredWidth(75);
        frame.getInvoiceLinesTable().getColumnModel().getColumn(4).setPreferredWidth(75);
    }

    private void clearLabelsContent(){
        frame.getInvoiceNumLabelC().setText("");
        frame.getInvoiceDateLabelC().setText("");
        frame.getCustomerLabelC().setText("");
        frame.getInvoiceTotalLabelC().setText("");
    }
}
