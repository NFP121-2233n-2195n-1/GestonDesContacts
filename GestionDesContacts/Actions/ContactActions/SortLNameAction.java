package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;


/**
 * Write a description of class SortLNameAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortLNameAction implements IContactAction
{    
    public void actionPerformed(ActionEvent e){
        Views.ContactsView view = Controllers.ContactsController.getInstance().getView();
        LinkedHashMap<Integer, Models.ContactModel> filteredContacts = view.getFilteredContactsMap();
        
        
        //sort map and set data in list
        List<Map.Entry<Integer,Models.ContactModel> > list= new ArrayList<Map.Entry<Integer,Models.ContactModel> >(filteredContacts.entrySet());
            
            //Sorted list
            Collections.sort(list,new Comparator<Map.Entry<Integer,Models.ContactModel> >() {
                // Comparing two entries by value
                public int compare(
                    Map.Entry<Integer,Models.ContactModel> entry1,
                    Map.Entry<Integer,Models.ContactModel> entry2)
                {
                    String myStr1=entry1.getValue().getLastName();
                    String myStr2=entry2.getValue().getLastName();
                    // Substracting the entries
                    return   myStr1.compareTo(myStr2);
                }
            });
            
            LinkedHashMap<Integer,Models.ContactModel> newMap = new LinkedHashMap<Integer,Models.ContactModel>();
            Iterator<Map.Entry<Integer,Models.ContactModel>> it = list.iterator();
            while(it.hasNext()){ 
                Map.Entry<Integer,Models.ContactModel> item = it.next();
                newMap.put(item.getKey(),item.getValue());
            }
            
            view.setDataInList(newMap);
    }
}
