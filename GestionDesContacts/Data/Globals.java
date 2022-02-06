package Data;
import java.util.Map;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;

/**
 * Write a description of class Globals here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Globals extends Observable
{
    private Map<Integer,Models.ContactModel> contacts;
    private Map<Integer, Models.GroupModel> groups;
    private static Globals instance;
    private Data data;
    
    private static final Color darkBlueColor = new Color(31, 78, 121);
    private static final Color lightBlueColor = new Color(157, 195, 230);
    private static final Font font = new Font ("TimesRoman", Font.PLAIN, 14);
    private static final Font bigFont = new Font ("TimesRoman", Font.PLAIN, 20);
    
    private Globals(){
        data = new Data();
    }
    
    public static Globals getInstance(){
        if(instance == null) instance = new Globals();
        return instance;
    }
    
    public Map<Integer, Models.ContactModel> getContacts(){
        if(this.contacts == null) contacts = data.getContactsData();
        return this.contacts;
    }
    public Map<Integer,Models.GroupModel> getGroups(){
        if(this.groups == null) groups = data.getGroupsData();
        return this.groups;
    }
    
    public static Color getDarkBlueColor() { return darkBlueColor; }
    public static Color getLightBlueColor() { return lightBlueColor; } 
    public static Font getFont() { return font; }
    public static Font getBigFont() {return bigFont;}
    
    public void saveContactToFolder(Models.ContactModel model){
        if(model==null) return;
        instance.getContacts().put(model.getContactID(), model);
        data.saveContactsToFolder(instance.getContacts());
        
        setChanged();
        notifyObservers();
    }
}
