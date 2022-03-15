package Data;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;

/**
 * The test class DataTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DataTest
{
    /**
     * Default constructor for test class DataTest
     */
    public DataTest()
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
    public void testSavedContactToFolderSuccessfully()
    {
        Data data = new Data();
        LinkedHashMap<Integer,Models.ContactModel> mapToSave = new LinkedHashMap<Integer,Models.ContactModel>();
    
        Models.ContactModel newContact = new Models.ContactModel("fname1","lname1","city1");
        Models.ContactModel newContact2 = new Models.ContactModel("fname2","lname2","city2");
        
        mapToSave.put(newContact.getContactID(), newContact);
        mapToSave.put(newContact2.getContactID(), newContact2);
        
        data.saveContactsToFolder(mapToSave);
        
        LinkedHashMap<Integer,Models.ContactModel> mapFromFolder = data.getContactsData();

        assertEquals(mapFromFolder.get(newContact.getContactID()).getFirstName(),"fname1");
        assertEquals(mapFromFolder.get(newContact2.getContactID()).getFirstName(),"fname2");
        assertEquals(mapFromFolder.get(newContact.getContactID()).getLastName(),"lname1");
        assertEquals(mapFromFolder.get(newContact2.getContactID()).getLastName(),"lname2");
    }
    
    @Test
    public void testSavedGroupsToFolderSuccessfully(){
        Data data = new Data();
        LinkedHashMap<Integer,Models.GroupModel> mapToSave = new LinkedHashMap<Integer,Models.GroupModel>();
    
        Models.GroupModel newGroup = new Models.GroupModel("gname1","gdesc1");
        Models.GroupModel newGroup2 = new Models.GroupModel("gname2","gdesc2");
        
        mapToSave.put(newGroup.getGroupID(), newGroup);
        mapToSave.put(newGroup2.getGroupID(), newGroup2);
        
        data.saveGroupsToFolder(mapToSave);
        
        LinkedHashMap<Integer,Models.GroupModel> mapFromFolder = data.getGroupsData();

        assertEquals(mapFromFolder.get(newGroup.getGroupID()).getGroupName(),"gname1");
        assertEquals(mapFromFolder.get(newGroup2.getGroupID()).getGroupName(),"gname2");
        assertEquals(mapFromFolder.get(newGroup.getGroupID()).getGroupDescription(),"gdesc1");
        assertEquals(mapFromFolder.get(newGroup2.getGroupID()).getGroupDescription(),"gdesc2");
    }
}

