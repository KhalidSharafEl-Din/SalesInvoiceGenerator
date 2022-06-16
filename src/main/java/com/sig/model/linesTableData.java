package com.sig.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class linesTableData extends AbstractTableModel {
    private ArrayList<InvoiceLine> lines;
    private final String[] columns = {"No.", "Item Name", "Item Price", "Item Count","Item Total"};

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

}
