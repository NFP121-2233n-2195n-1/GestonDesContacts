package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedHashMap;

/**
 * Write a description of class SaveNewContactAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaveNewContactAction implements IContactAction
{
    public void actionPerformed(ActionEvent e){
        Controllers.NewContactController cont = Controllers.NewContactController.getInstance();
        String firstName = ""+cont.getView().getFirstNameTextField().getText();
        String lastName = ""+cont.getView().getLastNameTextField().getText();
        String city = ""+cont.getView().getCityTextField().getText();
        
        Models.ContactModel newContact = new Models.ContactModel(firstName, lastName, city);
        
        //get phone numbers
        DefaultTableModel model = cont.getView().getTableModel();
        
        for(int i=0; i<model.getRowCount(); i++){
            String regionCode = ""+model.getValueAt(i,0);
            String regionNumber = ""+model.getValueAt(i,1);
            if((regionCode.isEmpty() && regionNumber.isEmpty())
                || (regionCode.equals("null") && regionNumber.equals("null"))){
                continue;
            }
            newContact.addPhoneNumber(new Models.PhoneNumber(regionCode, regionNumber));
        }
        
        
        //get groups and save contact to these groups
        DefaultTableModel groupModel = cont.getView().getGroupsTableModel();
        //get all groups
        LinkedHashMap<Integer, Models.GroupModel> groupsMap = Data.Globals.getInstance().getGroups();
        for(int i=0; i<groupModel.getRowCount(); i++){
            boolean isContactInGroup = (boolean) groupModel.getValueAt(i,1);
            
            //get group ID
            int groupID = (int) groupModel.getValueAt(i,0);
            //get group
            Models.GroupModel group = groupsMap.get(groupID);
            if(isContactInGroup){
                //save contact to list of contacts in group
                group.addContact(newContact.getContactID());
                Data.Globals.getInstance().saveGroupToFolder(group);
            }            
            else {
                //remove contact from list of contacts
                //In this case the contact is new so it shouldn't be in other groups
                //--> do nothing
            }
        }
        
        //clear values in input && table
        cont.getView().clearInputs();
        
        Data.Globals.getInstance().saveContactToFolder(newContact);
        OpenContacts oc = new OpenContacts();
        oc.actionPerformed(e);
        JOptionPane.showMessageDialog(null,"Saved Successfully.", "Saved", JOptionPane.WARNING_MESSAGE);
    }
}
