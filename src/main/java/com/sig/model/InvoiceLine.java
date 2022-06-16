package com.sig.model;

public class InvoiceLine {
    private String itemName;
    private int itemCount;
    private double itemPrice;
    private double itemTotal;
    private InvoiceHeader invoice;



    private int itemNum;
    public InvoiceLine(){

    }

    public InvoiceLine( String itemName, int itemCount, double itemPrice, InvoiceHeader invoice) {
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.invoice = invoice;
        this.itemNum = invoice.getInvoiceLines().size()+1;
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
    public int getItemNum() {
        return itemNum;
    }
    @Override
    public String toString(){
        //return "Item number " + itemNumber + " in invoice number " + invoice.getInvoiceNum() + " of " + itemName + " for " + itemPrice +" EGP for total of " +itemTotal+"\n";
        return  invoice.getInvoiceNum()+ ","+ itemName + "," + itemPrice + "," + itemCount +"\n";
    }

    public String toCSV(){
        return  invoice.getInvoiceNum()+ ","+ itemName + "," + (int)itemPrice + "," + itemCount +"\n";
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }
}
