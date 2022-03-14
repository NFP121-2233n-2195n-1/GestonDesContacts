package Actions.GroupActions;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Write a description of class SaveNewGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaveNewGroup implements IGroupAction
{
    public void actionPerformed(ActionEvent e){
        Controllers.NewGroupController cont = Controllers.NewGroupController.getInstance();
        String groupName = ""+cont.getView().getGroupNameTextField().getText();
        String groupDescription = ""+cont.getView().getGroupDescriptionTextField().getText();
        
        Models.GroupModel newGroup = new Models.GroupModel(groupName,groupDescription);
        
        DefaultTableModel model = cont.getView().getContactsTableModel();
        
        for(int i=0; i<model.getRowCount(); i++){
            int contactID = (int)model.getValueAt(i,0);
            boolean contactIsAdded = (boolean)model.getValueAt(i,3);
            if(!contactIsAdded){
                continue;
            }
            newGroup.addContact(contactID);
        }

        //clear fields
        cont.getView().clearInputs();
        
        Data.Globals.getInstance().saveGroupToFolder(newGroup);
        OpenGroups og = new OpenGroups();
        og.actionPerformed(e);
        
        JOptionPane.showMessageDialog(null,"Saved Successfully.", "Saved", JOptionPane.WARNING_MESSAGE);

    }
}
