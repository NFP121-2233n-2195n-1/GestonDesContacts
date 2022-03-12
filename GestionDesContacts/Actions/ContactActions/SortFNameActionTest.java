package Actions.ContactActions;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * The test class SortFNameActionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SortFNameActionTest
{
    /**
     * Default constructor for test class SortFNameActionTest
     */
    public SortFNameActionTest()
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
    public void testNullMapEntry()
    {
        Actions.ContactActions.SortFNameAction sortFNam1 = new Actions.ContactActions.SortFNameAction();
        assertEquals(null, sortFNam1.sortMapByFirstName(null));
    }
    
    @Test
    public void testRandomContactsMapEntry()
    {
        Actions.ContactActions.SortFNameAction sortFNam1 = new Actions.ContactActions.SortFNameAction();
        LinkedHashMap<Integer,Models.ContactModel> map = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        map.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("jess","bassil","nahr");
        map.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = sortFNam1.sortMapByFirstName(map);
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        assertEquals(contact2.getContactID(), list.get(0).getContactID());
        assertEquals(contact1.getContactID(), list.get(1).getContactID());
    }
    
      @Test
    public void testSameNameMapEntry(){
        Actions.ContactActions.SortFNameAction sortFNam1 = new Actions.ContactActions.SortFNameAction();
        LinkedHashMap<Integer,Models.ContactModel> myMap = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        myMap.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("susu","bassil","nahr");
        myMap.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = sortFNam1.sortMapByFirstName(myMap);
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        assertEquals(contact2.getContactID(), list.get(1).getContactID());
        assertEquals(contact1.getContactID(), list.get(0).getContactID()); 
    }

    @Test
    public void testSameFirstLetterMapEntry(){
        Actions.ContactActions.SortFNameAction sortFNam1 = new Actions.ContactActions.SortFNameAction();
        LinkedHashMap<Integer,Models.ContactModel> myMap = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        myMap.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("samira","bassil","nahr");
        myMap.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = sortFNam1.sortMapByFirstName(myMap);
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        assertEquals(contact2.getContactID(), list.get(0).getContactID());
        assertEquals(contact1.getContactID(), list.get(1).getContactID()); 
    }
}

