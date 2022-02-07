package Models;
import java.util.Observable;
import java.util.LinkedHashMap;
import java.io.Serializable;
import java.util.Date;


/**
 * Write a description of class ContactModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ContactModel implements Serializable
{
    private int contactID;
    private String firstName;
    private String lastName;
    private String city;
    private LinkedHashMap<Integer,PhoneNumber> phoneNumbers;
    private LinkedHashMap<Integer,GroupModel> groups;
    
    public ContactModel(String firstName, String lastName, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        contactID = (int) (new Date().getTime()/1000);
        phoneNumbers = new LinkedHashMap<Integer, PhoneNumber>();
    }
    
    public int getContactID(){ return this.contactID; }
    public String getFirstName(){ return this.firstName; }
    public String getLastName(){ return this.lastName; }
    public String getCity(){ return this.city; }
    public LinkedHashMap<Integer,PhoneNumber> getPhoneNumbers(){ return this.phoneNumbers; }
    public PhoneNumber getPhoneNumber(int phoneNumberID){
        return phoneNumbers.get(phoneNumberID);
    }
    
    public void setFirstName(String firstName){this.firstName = firstName;}
    
    public void setLastName(String lastName){this.lastName = lastName;}
    
    public void setCity(String city){this.city = city;}
    
    public String toString(){
        return ""+contactID+". "+firstName+" "+lastName+" - "+city;
    }
    
    public void addGroup(GroupModel group){
        groups.put(group.getGroupID(), group);
    }
    
    public void addPhoneNumber(PhoneNumber phoneNumber){
        phoneNumbers.put(phoneNumber.getPhoneNumberID(), phoneNumber);
    }
    
    public void removeGroup(int groupID){
        this.groups.remove(groupID);
    }
    
    public void removePhoneNumber(int phoneNumberID){
        this.phoneNumbers.remove(phoneNumberID);
    }
}
