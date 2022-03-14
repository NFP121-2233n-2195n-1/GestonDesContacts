package Actions.GroupActions;
import java.awt.event.ActionEvent;
import javax.swing.*;


/**
 * Write a description of class DeleteGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeleteGroup implements IGroupAction
{
    public void actionPerformed(ActionEvent e){
        int delete = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete", JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
                
        if(delete == JOptionPane.YES_OPTION){
            Controllers.GroupsController cont = Controllers.GroupsController.getInstance();

            JTable groupsTable = cont.getView().getGroupsTable();
            int selectedIndex = groupsTable.getSelectedRow();
        
            if(selectedIndex == -1){return;}
       
            //get selected group
            int selectedGroupID = (int)groupsTable.getValueAt(selectedIndex,0);
            
            //get group object
            Models.GroupModel model = Data.Globals.getInstance().getGroups().get(selectedGroupID);
           
            //save group to memento undo
            Memento.OriginatorGroup originator = cont.getOriginatorUndo();
            Memento.CareTakerGroup caretaker = cont.getCareTakerUndo();
            originator.setState(model);
            caretaker.add(originator.saveStateToMemento());
            
            //delete group            
            Data.Globals.getInstance().removeGroupFromFolder(model);

        }
        delete = 0;
    
    }
}
