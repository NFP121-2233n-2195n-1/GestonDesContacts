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
        //get view of list of contacts
        Views.ContactsView view = Controllers.ContactsController.getInstance().getView();

        //get search input
        JTextField searchInput = view.getSearchInput();

        //get search
        String search = searchInput.getText(); 

        //get contacts data
        LinkedHashMap<Integer, Models.ContactModel> newMap = searchMapByWord(Data.Globals.getInstance().getContacts(), search);

        view.setDataInList(newMap);
    }
    
    public LinkedHashMap<Integer,Models.ContactModel> searchMapByWord(LinkedHashMap<Integer, Models.ContactModel> filteredContacts, String search){
        //create new map
        LinkedHashMap<Integer,Models.ContactModel> newMap = new LinkedHashMap<Integer,Models.ContactModel>();
            
        if(search == null || search == ""){
            //if search if empty do nothing
        } else {
            //iterate contacts
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
        return newMap;
    }
}
