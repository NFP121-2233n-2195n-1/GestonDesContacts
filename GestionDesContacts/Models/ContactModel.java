package Models;
import java.util.Observable;
import java.util.Map;
import java.io.Serializable;


/**
 * Write a description of class ContactModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ContactModel extends Observable implements Serializable
{
    private static int next = 0;
    private int contactID;
    private String firstName;
    private String lastName;
    private String city;
    private Map<Integer,PhoneNumber> phoneNumbers;
    private Map<Integer,GroupModel> groups;
    
    public ContactModel(){
        contactID = next;
        next++;
    }
    
    public int getContactID(){ return this.contactID; }
    public String getFirstName(){ return this.firstName; }
    public String getLastName(){ return this.lastName; }
    public String getCity(){ return this.city; }
    public Map<Integer,PhoneNumber> getPhoneNumbers(){ return this.phoneNumbers; }
    public PhoneNumber getPhoneNumber(int phoneNumberID){
        return phoneNumbers.get(phoneNumberID);
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
        setChanged();
        notifyObservers();
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
        setChanged();
        notifyObservers();
    }
    public void setCity(String city){
        this.city = city;
        setChanged();
        notifyObservers();
    }
    
    public String toString(){
        return ""+contactID+". "+firstName+" "+lastName+" - "+city;
    }
    
    public void addGroup(GroupModel group){
        groups.put(group.getGroupID(), group);
        setChanged();
        notifyObservers();
    }
    
    public void addPhoneNumber(PhoneNumber phoneNumber){
        phoneNumbers.put(phoneNumber.getPhoneNumberID(), phoneNumber);
        setChanged();
        notifyObservers();
    }
    
    public void removeGroup(int groupID){
        this.groups.remove(groupID);
        setChanged();
        notifyObservers();
    }
    
    public void removePhoneNumber(int phoneNumberID){
        this.phoneNumbers.remove(phoneNumberID);
        setChanged();
        notifyObservers();
    }
}
