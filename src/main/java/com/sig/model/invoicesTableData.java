package com.sig.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class invoicesTableData extends AbstractTableModel {
    private ArrayList<InvoiceHeader> headers;
    private final String[] columns = {"No.", "Date", "Customer", "Total"};
    private final Class[] columnsClass = new Class[] {Integer.class, String.class, String.class, Double.class};

    public invoicesTableData(ArrayList<InvoiceHeader> headers){
        this.headers = headers;
    }

    @Override
    public int getRowCount() {
        return headers.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int column){
        return this.columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        return this.columnsClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0 || columnIndex == 3) return false;
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader header = headers.get(rowIndex);
        switch (columnIndex){
            case 0:
                return header.getInvoiceNum();
            case 1:
                return header.getInvoiceDate();
            case 2:
                return header.getCustomerName();
            case 3:
                 return header.getInvoiceTotal();
            default: return "";

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        InvoiceHeader header = headers.get(rowIndex);
        switch (columnIndex){
            case 1: header.setInvoiceDate((String)aValue); break;
            case 2: header.setCustomerName((String)aValue); break;
            default:break;
        }
    }
}
