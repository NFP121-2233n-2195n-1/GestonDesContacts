package Models;
import java.util.Observable;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Date;
import java.util.ArrayList;

/**
 * Write a description of class GroupModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GroupModel extends Observable implements Serializable
{
    private int groupID;
    private static int next = 0;
    private String groupName;
    private String groupDescription;
    private ArrayList<Integer> contactIDs;
    
    public GroupModel(String groupName, String groupDescription){
        groupID = (int) (new Date().getTime()/1000)+next;
        next++;
        contactIDs = new ArrayList<Integer>();
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }
    
    public int getGroupID(){return this.groupID;}
    public String getGroupName(){return this.groupName;}
    public String getGroupDescription(){return this.groupDescription;}
    public ArrayList<Integer> getContactIDs(){return this.contactIDs;}
    
    public void setGroupName(String groupName){
        this.groupName = groupName;
        setChanged();
        notifyObservers();
    }
    
    public void setGroupDescription(String groupDescription){
        this.groupDescription = groupDescription;
        setChanged();
        notifyObservers();
    }
    
    public void addContact(int contactID){
        contactIDs.add(contactID);
        setChanged();
        notifyObservers();
    }
    
    public void removeContact(int contactID){
        contactIDs.remove(Integer.valueOf(contactID));
        setChanged();
        notifyObservers();
    }
    
    public void removeAllContacts(){
        contactIDs = new ArrayList<Integer>();
    }

}
