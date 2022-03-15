package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Write a description of class DeleteAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DeleteContact implements IContactAction
{    
    public void actionPerformed(ActionEvent e){
        int delete = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete", JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
                
        if(delete == JOptionPane.YES_OPTION){
            Controllers.ContactsController cont = Controllers.ContactsController.getInstance();

            //get contact list
            JList list = cont.getView().getList();

            //if none is selected --> exit
            if(list.getSelectedIndex() == -1){return;}
            
            //get selected contact
            Models.ContactModel model = (Models.ContactModel)list.getSelectedValue();

            //remove contact from groups
            LinkedHashMap<Integer, Models.GroupModel> groups = Data.Globals.getInstance().getGroups();
            for (Map.Entry<Integer, Models.GroupModel> entry : groups.entrySet()) {
                int key = entry.getKey();
                Models.GroupModel group = entry.getValue();
                
                //if group has contact then remove contact from group
                if(group.getContactIDs().contains(model.getContactID())){
                    group.removeContact(model.getContactID());
                }
            }
            
            //save contact to memento undo
            Memento.OriginatorContact originator = cont.getOriginatorUndo();
            Memento.CareTakerContact caretaker = cont.getCareTakerUndo();
            originator.setState(model);
            caretaker.add(originator.saveStateToMemento());
            
            //delete contact            
            Data.Globals.getInstance().removeContactFromFolder(model);
        }
        delete = 0;
    }
}
