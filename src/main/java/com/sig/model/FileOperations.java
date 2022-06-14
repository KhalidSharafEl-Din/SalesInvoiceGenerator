package com.sig.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileOperations {
    public ArrayList<InvoiceHeader> readFile(){
        ArrayList<InvoiceHeader> headers = new ArrayList<>();
        String row;
        BufferedReader csvReader = null;
        try{
            csvReader = new BufferedReader(new FileReader("src/main/java/com/sig/model/InvoiceHeader.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                // do something with the data
                int invoiceNum = Integer.parseInt(data[0]);
                String invoiceDate = data[1];
                String customerName = data[2];
                headers.add(new InvoiceHeader(invoiceNum,customerName, invoiceDate));
            }
        } catch (IOException e) {e.printStackTrace();}
        finally {
            // Close the file.
            try {csvReader.close();} catch (IOException e) {e.printStackTrace();}
        }

        try{
            csvReader = new BufferedReader(new FileReader("src/main/java/com/sig/model/InvoiceLine.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                // do something with the data
                int invoiceNum = Integer.parseInt(data[0]);
                String itemName = data[1];
                double itemPrice = Double.parseDouble(data[2]);
                int itemCount = Integer.parseInt(data[3]);
                InvoiceLine line = new InvoiceLine(itemName, itemCount, itemPrice,headers.get(invoiceNum-1));
                headers.get(invoiceNum-1).addInvoiceItem(line);
            }
        } catch (IOException e) {e.printStackTrace();}
        finally {
            // Close the file
            try {csvReader.close();} catch (IOException e) {e.printStackTrace();}
        }

        return headers;
    }

    public boolean writeFile(ArrayList<InvoiceHeader> invoiceHeader){
        return true;
    }

    public static void main(String[] args) {
        FileOperations fileIO = new FileOperations();
        System.out.println(fileIO.readFile());
    }
}
