package Actions.GroupActions;
import java.awt.event.ActionEvent;
import javax.swing.JTable;


/**
 * Write a description of class OpenUpdateGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenUpdateGroup implements IOpenGroupAction
{
    public void actionPerformed(ActionEvent e){
       Controllers.GroupsController groupsCont = Controllers.GroupsController.getInstance();
       JTable groupsTable = groupsCont.getView().getGroupsTable();
       int selectedIndex = groupsTable.getSelectedRow();
       
       if(selectedIndex == -1){return;}
       
       //get selected group
       int selectedGroupID = (int)groupsTable.getValueAt(selectedIndex,0);
            
       //get group object
       Models.GroupModel model = Data.Globals.getInstance().getGroups().get(selectedGroupID);
       
       
       Controllers.UpdateGroupController updateCont = Controllers.UpdateGroupController.getInstance();
       updateCont.setModel(model);
       
       
       MainFrame.MainFrame.getInstance().setCurrentPanel(updateCont.getView());
    }
}
