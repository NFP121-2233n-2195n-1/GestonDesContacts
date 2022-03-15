package Actions.GroupActions;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Write a description of class SortGroupContactsNbAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortGroupContactsNbAction implements IGroupAction
{
    public void actionPerformed(ActionEvent e){
        Views.GroupsView view = Controllers.GroupsController.getInstance().getView();
        LinkedHashMap<Integer, Models.GroupModel> filteredGroups = view.getFilteredGroupsMap();
        
        LinkedHashMap<Integer,Models.GroupModel> newMap = sortMapByGroupName(filteredGroups);

        view.setFilteredGroupsMap(newMap);
    }
    
    
    public LinkedHashMap<Integer, Models.GroupModel> sortMapByGroupName(LinkedHashMap<Integer, Models.GroupModel> filteredGroups){
        if(filteredGroups == null) return null;
        
        //sort map and set data in list
        List<Map.Entry<Integer,Models.GroupModel> > list= new ArrayList<Map.Entry<Integer,Models.GroupModel> >(filteredGroups.entrySet());
        
        //Sorted list
        Collections.sort(list,new Comparator<Map.Entry<Integer,Models.GroupModel> >() {
            // Comparing two entries by value
            public int compare(
                Map.Entry<Integer,Models.GroupModel> entry1,
                Map.Entry<Integer,Models.GroupModel> entry2)
            {
                int nbOfContacts1=entry1.getValue().getContactIDs().size();
                int nbOfContacts2=entry2.getValue().getContactIDs().size();
                // Substracting the entries
                return   nbOfContacts1 - nbOfContacts2;
            }
        });
        
        LinkedHashMap<Integer,Models.GroupModel> newMap = new LinkedHashMap<Integer,Models.GroupModel>();
        Iterator<Map.Entry<Integer,Models.GroupModel>> it = list.iterator();
        while(it.hasNext()){ 
            Map.Entry<Integer,Models.GroupModel> item = it.next();
            newMap.put(item.getKey(),item.getValue());
        }
        
        return newMap;
    }
}
