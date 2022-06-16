package com.sig.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InvoiceHeader {
    private int invoiceNum;
    private LocalDate invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> invoiceLines;
    private double invoiceTotal;

    InvoiceHeader(int invoiceNum, String customerName){
        this.invoiceNum = invoiceNum;
        this.customerName = customerName;
        this.invoiceDate = LocalDate.now();
        this.invoiceLines = new ArrayList<>();
    }
    public InvoiceHeader(int invoiceNo, String customerName, String invoiceDate){
        this(invoiceNo, customerName);
        setInvoiceDate(invoiceDate);
    }
    InvoiceHeader(int invoiceNo, String customerName, ArrayList<InvoiceLine> invoiceLines){
        this(invoiceNo, customerName);
        this.invoiceLines = invoiceLines;
    }
    InvoiceHeader(int invoiceNo, String customerName, String invoiceDate, ArrayList<InvoiceLine> invoiceLines){
        this(invoiceNo, customerName, invoiceDate);
        this.invoiceLines = invoiceLines;
    }

    public void addInvoiceItem(InvoiceLine item) {
        this.invoiceLines.add(item);
        getInvoiceTotal();
    }

    public void removeInvoiceItem(InvoiceLine item) {
        this.invoiceLines.remove(item);
        getInvoiceTotal();
    }
    public void removeInvoiceItem(int itemNum) {
        this.invoiceLines.remove(itemNum);
        getInvoiceTotal();
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
        getInvoiceTotal();
    }

    public double getInvoiceTotal(){
        invoiceTotal = 0.0;
        for (InvoiceLine line : invoiceLines) {
            invoiceTotal += line.getItemTotal();
        }
        return this.invoiceTotal;
    }
    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {

        return invoiceDate.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = LocalDate.parse(invoiceDate, DateTimeFormatter.ofPattern("dd-MM-uuuu"));
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }



    @Override
    public String toString(){
        //return "The invoice NO."+ invoiceNum +" was created on " + invoiceDate.toString()+" for " + customerName + " with " + invoiceLines.size() + " items totaling to " + invoiceTotal +" EGP.";
        return "invoice"+invoiceNum+"Date("+invoiceDate+"),"+customerName + " Items " + invoiceLines ;
        //return  invoiceNum + "," + invoiceDate + "," +customerName +"\n";
    }
    public String toCSV(){
        String date = invoiceDate.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));
        return  invoiceNum + "," + date + "," +customerName +"\n";
    }

    public static void main(String[] args) {
        InvoiceHeader invoice = new InvoiceHeader(1, "Khalid", "15-02-2002");

        invoice.addInvoiceItem(new InvoiceLine("MacBook Pro 16inch",2,2500,invoice));
        invoice.addInvoiceItem(new InvoiceLine("Iphone 13 Pro Max",3,1500,invoice));
        invoice.addInvoiceItem(new InvoiceLine("Air Pods Pro",3,500,invoice));

        //invoice.removeInvoiceItem(3);

        System.out.println(invoice);
        System.out.println(invoice.invoiceLines);
    }
}
