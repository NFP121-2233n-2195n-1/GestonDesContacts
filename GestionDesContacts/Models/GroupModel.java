package Models;
import java.util.Observable;
import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Write a description of class GroupModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GroupModel extends Observable implements Serializable
{
    private static int next = 0;
    private int groupID;
    private String groupName;
    private String groupDescription;
    private LinkedHashMap<Integer, ContactModel> contacts;
    
    GroupModel(){
        groupID = next;
        next++;
    }
    
    public int getGroupID(){return this.groupID;}
    public String getGroupName(){return this.groupName;}
    public String getGroupDescription(){return this.groupDescription;}
    public LinkedHashMap<Integer,ContactModel> getContacts(){return this.contacts;}
    
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
    
    public void addContact(ContactModel contact){
        contacts.put(contact.getContactID(), contact);
        setChanged();
        notifyObservers();
    }
    
    public void removeContact(ContactModel contact){
        contacts.remove(contact.getContactID());
        setChanged();
        notifyObservers();
    }

}
