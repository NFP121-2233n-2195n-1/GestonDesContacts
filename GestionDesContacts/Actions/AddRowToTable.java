package Actions;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

/**
 * Write a description of class AddRowToTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AddRowToTable implements ActionListener
{
        JTable table;
        DefaultTableModel tableModel;
        public AddRowToTable(JTable table){
            this.table = table;
            this.tableModel = (DefaultTableModel)table.getModel();
        }
        public void actionPerformed(ActionEvent e){
            tableModel.addRow(new Object[]{});
            table.setModel(tableModel);
            table.revalidate();
        }
}
