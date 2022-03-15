package Data;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


/**
 * Write a description of class Data here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Data
{
    private static File mainDirectory = new File("D:\\GestionDesContactsApp");
    
    Data(){
        createFiles();
    }
    
    public void createFiles(){
        if(!mainDirectory.exists()){
            mainDirectory.mkdir();
            try{
                File contacts = new File(mainDirectory+"\\contacts.txt");
                contacts.createNewFile();
                File groups = new File(mainDirectory+"\\groups.txt");
                groups.createNewFile();
            }
            catch(IOException e){}
        }
    }
    
    public static File getMainDirectory(){return mainDirectory;}
    
    public LinkedHashMap<Integer,Models.ContactModel> getContactsData(){
        LinkedHashMap map = new LinkedHashMap();
        try{
            FileInputStream in = new FileInputStream(mainDirectory+"\\contacts.txt");
            ObjectInputStream ois = new ObjectInputStream(in);
            map = (LinkedHashMap) (ois.readObject());
        }catch(java.io.EOFException e){System.out.println(e.getMessage());}
        catch(Exception e){System.out.println(e.getMessage());}
        
        return map;
    }
    
    public LinkedHashMap<Integer,Models.GroupModel> getGroupsData(){
        LinkedHashMap map = new LinkedHashMap();
        try{
            FileInputStream in = new FileInputStream(mainDirectory+"\\groups.txt");
            ObjectInputStream ois = new ObjectInputStream(in);
            map = (LinkedHashMap) (ois.readObject());
        }catch(java.io.EOFException e){System.out.println(e.getMessage());}
        catch(Exception e){System.out.println(e.getMessage());}
        
        return map;
    }

    public void saveContactsToFolder(LinkedHashMap<Integer,Models.ContactModel> map){
        if(map == null) return;
        try{
            FileOutputStream out = new FileOutputStream(mainDirectory+"\\contacts.txt");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(map);
            oos.flush();
        }
        catch(java.io.EOFException ex){System.out.println(ex.getMessage());}
        catch(Exception e){System.out.println(e.getMessage());}
    }
    
    public void saveGroupsToFolder(LinkedHashMap<Integer,Models.GroupModel> map){
        if(map == null) return;
        try{
            FileOutputStream out = new FileOutputStream(mainDirectory+"\\groups.txt");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(map);
            oos.flush();
        }
        catch(java.io.EOFException ex){System.out.println(ex.getMessage());}
        catch(Exception e){System.out.println(e.getMessage());}
    }
}
