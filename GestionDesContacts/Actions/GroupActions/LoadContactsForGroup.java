package Actions.GroupActions;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTable;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 * Write a description of class LoadContactsForGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoadContactsForGroup implements ListSelectionListener
{
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Controllers.GroupsController cont = Controllers.GroupsController.getInstance();
        Views.GroupsView view = cont.getView();
        
        JTable groupsTable = view.getGroupsTable();
        DefaultTableModel contactsTableModel = new DefaultTableModel(view.getTableHeaderContacts(),0){
            public boolean isCellEditable(int row, int col){
                switch(col){
                    default: 
                        return false;
                }
            }
        };
        
        int selectedRowIndex = groupsTable.getSelectedRow();
        if(selectedRowIndex == -1){
            //no row is selected then do nothing
            return;
        } else {
            //get selected group
            int selectedGroupID = (int)groupsTable.getValueAt(selectedRowIndex,0);
            
            //get group object
            Models.GroupModel selectedGroup = Data.Globals.getInstance().getGroups().get(selectedGroupID);
            
            
            //iterate contacts of selected group 
            Iterator <Integer> it = selectedGroup.getContactIDs().iterator();
            
            //set contacts in contacts' table model
            while(it.hasNext()){                 
                //get contact by id
                Models.ContactModel contact = Data.Globals.getInstance().getContacts().get(it.next());
                
                //set new row in contacts table model
                contactsTableModel.addRow(new Object[] {contact.getFirstName()+contact.getLastName(),contact.getCity()});
            }
            
            //set contacts table model in contacts table
            view.setContactsTableModel(contactsTableModel);
            
        }
    }
}
