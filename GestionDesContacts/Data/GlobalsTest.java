package Data;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;

/**
 * The test class GlobalsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GlobalsTest
{
    /**
     * Default constructor for test class GlobalsTest
     */
    public GlobalsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testSaveContact(){
        Globals globals = Globals.getInstance();
        
        Models.ContactModel newContact = new Models.ContactModel("fname1","lname1","city1");
        Models.ContactModel newContact2 = new Models.ContactModel("fname2","lname2","city2");
        
        globals.saveContactToFolder(newContact);
        globals.saveContactToFolder(newContact2);
        
        LinkedHashMap<Integer,Models.ContactModel> mapFromFolder = globals.getContacts();

        assertEquals(mapFromFolder.get(newContact.getContactID()).getFirstName(),"fname1");
        assertEquals(mapFromFolder.get(newContact2.getContactID()).getFirstName(),"fname2");
        assertEquals(mapFromFolder.get(newContact.getContactID()).getLastName(),"lname1");
        assertEquals(mapFromFolder.get(newContact2.getContactID()).getLastName(),"lname2");
    
        //update contact
        newContact.setFirstName("new first name");
        globals.saveContactToFolder(newContact);
        assertEquals(mapFromFolder.get(newContact.getContactID()).getFirstName(),"new first name");
        assertEquals(mapFromFolder.get(newContact2.getContactID()).getFirstName(),"fname2");
        assertEquals(mapFromFolder.get(newContact.getContactID()).getLastName(),"lname1");
        assertEquals(mapFromFolder.get(newContact2.getContactID()).getLastName(),"lname2");
    
    }

    
    @Test
    public void testSaveGroup(){
        Globals globals = Globals.getInstance();
        
        Models.GroupModel newGroup = new Models.GroupModel("gname1","gdesc1");
        Models.GroupModel newGroup2 = new Models.GroupModel("gname2","gdesc2");
        
        globals.saveGroupToFolder(newGroup);
        globals.saveGroupToFolder(newGroup2);
        
        LinkedHashMap<Integer,Models.GroupModel> mapFromFolder = globals.getGroups();

        assertEquals(mapFromFolder.get(newGroup.getGroupID()).getGroupName(),"gname1");
        assertEquals(mapFromFolder.get(newGroup2.getGroupID()).getGroupName(),"gname2");
        assertEquals(mapFromFolder.get(newGroup.getGroupID()).getGroupDescription(),"gdesc1");
        assertEquals(mapFromFolder.get(newGroup2.getGroupID()).getGroupDescription(),"gdesc2");
    
        //update group
        newGroup.setGroupName("new group name");
        globals.saveGroupToFolder(newGroup);
        assertEquals(mapFromFolder.get(newGroup.getGroupID()).getGroupName(),"new group name");
        assertEquals(mapFromFolder.get(newGroup2.getGroupID()).getGroupName(),"gname2");
        assertEquals(mapFromFolder.get(newGroup.getGroupID()).getGroupDescription(),"gdesc1");
        assertEquals(mapFromFolder.get(newGroup2.getGroupID()).getGroupDescription(),"gdesc2");
    
    }
}
