package Actions.ContactActions;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class SortLNameActionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SortLNameActionTest
{
    /**
     * Default constructor for test class SortLNameActionTest
     */
    public SortLNameActionTest()
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
        public void testRandomContactsMapEntry()
        {
            Actions.ContactActions.SortLNameAction sortLNam1 = new Actions.ContactActions.SortLNameAction();
            LinkedHashMap<Integer,Models.ContactModel> map = new LinkedHashMap<Integer,Models.ContactModel>();
            
            Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
            map.put(contact1.getContactID(),contact1);
            
            Models.ContactModel contact2 = new Models.ContactModel("jess","bassil","nahr");
            map.put(contact2.getContactID(),contact2);
            
            LinkedHashMap<Integer,Models.ContactModel> newMap = sortLNam1.sortMapByLastName(map);
            List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
            assertEquals(contact2.getContactID(), list.get(0).getContactID());
            assertEquals(contact1.getContactID(), list.get(1).getContactID());
        }
     @Test
    public void testSameNameMapEntry(){
        Actions.ContactActions.SortLNameAction sortLNam1 = new Actions.ContactActions.SortLNameAction();
        LinkedHashMap<Integer,Models.ContactModel> myMap = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        myMap.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("jess","rahme","nahr");
        myMap.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = sortLNam1.sortMapByLastName(myMap);
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        assertEquals(contact2.getContactID(), list.get(1).getContactID());
        assertEquals(contact1.getContactID(), list.get(0).getContactID()); 
    }
    @Test
    public void testSameFirstLetterMapEntry(){
        Actions.ContactActions.SortLNameAction sortLNam1 = new Actions.ContactActions.SortLNameAction();
        LinkedHashMap<Integer,Models.ContactModel> myMap = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        myMap.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("samira","rassil","nahr");
        myMap.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = sortLNam1.sortMapByLastName(myMap);
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        assertEquals(contact2.getContactID(), list.get(1).getContactID());
        assertEquals(contact1.getContactID(), list.get(0).getContactID()); 
    }


}
