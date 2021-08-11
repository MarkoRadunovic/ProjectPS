/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.form.component.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.MeasurementUnit;
import rs.ac.bg.fon.ps.domain.Showpiece;

/**
 *
 * @author Korisnik
 */
public class ShowpieceTableModel extends AbstractTableModel{
    private String[] ColumnNames = {"ID","Name","Description","Weight","MU","Age"};
    private final List<Showpiece> showpieces;

    public ShowpieceTableModel(List<Showpiece> showpieces) {
        this.showpieces = showpieces;
    }

    @Override
    public String getColumnName(int column) {
        if(column>ColumnNames.length) return "N/A";
        return ColumnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex==0) || (columnIndex==1) || (columnIndex==2) || (columnIndex==3) || (columnIndex==4)|| (columnIndex==5);
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Showpiece showpiece = showpieces.get(rowIndex);
        switch(columnIndex){
            case 0:
                showpiece.setId(String.valueOf(value));
                break;
            case 1:
                showpiece.setName(String.valueOf(value));
                break;
            case 2:
                showpiece.setDescription(String.valueOf(value));
                break;
            case 3:
                showpiece.setWeight(Double.parseDouble(String.valueOf(value)));
                break;
            case 4:
                showpiece.setMeasurementUnit((MeasurementUnit) value);
                break;
            case 5:
                showpiece.setAge(String.valueOf(value));
                break;
        }
    }
    
    
    
    
    
    @Override
    public int getRowCount() {
        if(showpieces==null) return 0;
        return showpieces.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Showpiece showpiece = showpieces.get(rowIndex);
        switch(columnIndex){
            case 0: return showpiece.getId();
            case 1: return showpiece.getName();
            case 2: return showpiece.getDescription();
            case 3: return showpiece.getWeight();
            case 4: return showpiece.getMeasurementUnit();
            case 5: return showpiece.getAge();
            default: 
                return "N/A";
        }
    }

    public void addShowpiece(Showpiece showpiece) {
        showpieces.add(showpiece);
        fireTableRowsInserted(showpieces.size()-1, showpieces.size()-1);
    }

    public Showpiece getShowpieceAt(int row) {
        return showpieces.get(row);
    }

    public void deleteShowpiece(int row) {
        fireTableRowsDeleted(row, row);
    }
    
}
