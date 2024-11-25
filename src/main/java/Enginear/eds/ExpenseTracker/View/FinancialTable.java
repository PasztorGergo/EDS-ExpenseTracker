package Enginear.eds.ExpenseTracker.View;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class FinancialTable extends JTable{
    public FinancialTable(AbstractTableModel model){
        this.setFillsViewportHeight(true);
        this.setModel(model);
    }
}
