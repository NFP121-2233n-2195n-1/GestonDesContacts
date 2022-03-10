package Actions.ContactActions;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JTextField;

/**
 * Write a description of class SearchContactAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SearchContactAction implements IContactAction
{
    public void actionPerformed(ActionEvent e){
        Views.ContactsView view = Controllers.ContactsController.getInstance().getView();
        LinkedHashMap<Integer, Models.ContactModel> filteredContacts = Data.Globals.getInstance().getContacts();
        JTextField searchInput = view.getSearchInput();
        String search = searchInput.getText(); 
        LinkedHashMap<Integer,Models.ContactModel> newMap = new LinkedHashMap<Integer,Models.ContactModel>();
            
        if(search == null || search == ""){
        } else {
            for(Map.Entry<Integer,Models.ContactModel> entry: filteredContacts.entrySet()){
                Models.ContactModel contact = entry.getValue();
                String firstName = contact.getFirstName();
                String lastName = contact.getLastName();
                String city = contact.getCity();
                
                if(firstName.contains(search)||lastName.contains(search)||city.contains(search)){
                        newMap.put(contact.getContactID(),contact);
                }
            }
        }
        view.setDataInList(newMap);
    }
}
