package com.sig.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class linesTableData extends AbstractTableModel {
    private ArrayList<InvoiceLine> lines;
    private final String[] columns = {"No.", "Item Name", "Item Price", "Item Count","Item Total"};
    private final Class[] columnsClass = new Class[] {Integer.class, String.class, Double.class,Integer.class, Double.class};


    public linesTableData(ArrayList<InvoiceLine> lines){
        this.lines = lines;
    }

    @Override
    public int getRowCount() {
        return lines.size();
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
        if(columnIndex == 0 || columnIndex == 4) return false;
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line = lines.get(rowIndex);
        switch (columnIndex){
            case 0:
                return line.getItemNum();
            case 1:
                return line.getItemName();
            case 2:
                return line.getItemPrice();
            case 3:
                return line.getItemCount();
            case 4:
                return line.getItemTotal();
            default: return "";


        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        InvoiceLine line = lines.get(rowIndex);
        switch (columnIndex){
            case 1: line.setItemName((String)aValue); break;
            case 2: line.setItemPrice((Double)aValue); break;
            case 3: line.setItemCount((Integer) aValue); break;
            default:break;
        }
    }

}
