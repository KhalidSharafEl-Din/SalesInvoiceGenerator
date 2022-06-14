package com.sig.model;

public class InvoiceLine {
    private String itemName;
    private int itemCount;
    private double itemPrice;
    private double itemTotal;
    private InvoiceHeader invoice;

    public InvoiceLine(){

    }

    public InvoiceLine( String itemName, int itemCount, double itemPrice, InvoiceHeader invoice) {
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.invoice = invoice;
        calItemTotal();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemTotal() {
        calItemTotal();
        return itemTotal;
    }

    public void calItemTotal() {
        this.itemTotal = this.itemCount * this.itemPrice;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString(){
        //return "Item number " + itemNumber + " in invoice number " + invoice.getInvoiceNum() + " of " + itemName + " for " + itemPrice +" EGP for total of " +itemTotal+"\n";
        return "" + itemName + "," + itemCount + "," + itemPrice;
    }
    
}
