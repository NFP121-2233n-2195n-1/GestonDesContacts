package Actions.GroupActions;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Write a description of class SaveUpdateGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaveUpdateGroup implements IGroupAction
{
    public void actionPerformed(ActionEvent e){
        Controllers.UpdateGroupController cont = Controllers.UpdateGroupController.getInstance();
        String groupName = ""+cont.getView().getGroupNameTextField().getText();
        String groupDescription = ""+cont.getView().getGroupDescriptionTextField().getText();
        
        Models.GroupModel group = cont.getModel();
        group.setGroupName(groupName);
        group.setGroupDescription(groupDescription);
        
        DefaultTableModel model = cont.getView().getContactsTableModel();
        group.removeAllContacts();
        
        for(int i=0; i<model.getRowCount(); i++){
            int contactID = (int)model.getValueAt(i,0);
            boolean contactIsAdded = (boolean)model.getValueAt(i,3);
            if(!contactIsAdded){
                continue;
            }
            group.addContact(contactID);
        }
        
        Data.Globals.getInstance().saveGroupToFolder(group);
        OpenGroups og = new OpenGroups();
        og.actionPerformed(e);
        JOptionPane.showMessageDialog(null,"Saved Successfully.", "Saved", JOptionPane.WARNING_MESSAGE);

    }
}
