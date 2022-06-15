package com.sig.controller;
import com.sig.model.InvoiceHeader;
import com.sig.view.InvoiceCreation;
import com.sig.view.LineCreation;
import com.sig.view.SalesInvoiceGenratorJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    private SalesInvoiceGenratorJFrame frame;
    private InvoiceCreation invoiceCreation;
    private LineCreation lineCreation;

    public ActionHandler(SalesInvoiceGenratorJFrame frame){
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Save File":
                System.out.println("Save File");
                break;
            case "Load File":
                System.out.println("Load File");
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
                break;
            case "New Item":
                System.out.println("New Item");
                createNewItem();
                break;
            case "Delete Item":
                System.out.println("Delete Item");
                break;
            case "cancelLineCreationButton" :
                cancelLineCreation();
                break;
            default:
                System.out.println("Action!!!");
        }
    }

    private void cancelLineCreation() {
        lineCreation.setVisible(false);
        lineCreation.dispose();
        lineCreation = null;
    }

    private void createNewInvoice() {
        invoiceCreation = new InvoiceCreation(frame, true);
        invoiceCreation.setVisible(true);
    }

    private void createNewItem() {
        lineCreation = new LineCreation(frame, true);
        lineCreation.setVisible(true);
    }

}
