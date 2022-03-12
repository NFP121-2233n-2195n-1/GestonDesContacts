package Actions.ContactActions;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class SortCityActionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SortCityActionTest
{
    /**
     * Default constructor for test class SortCityActionTest
     */
    public SortCityActionTest()
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
            Actions.ContactActions.SortCityAction sortCity1 = new Actions.ContactActions.SortCityAction();
            LinkedHashMap<Integer,Models.ContactModel> map = new LinkedHashMap<Integer,Models.ContactModel>();
            
            Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
            map.put(contact1.getContactID(),contact1);
            
            Models.ContactModel contact2 = new Models.ContactModel("jess","bassil","beirut");
            map.put(contact2.getContactID(),contact2);
            
            LinkedHashMap<Integer,Models.ContactModel> newMap = sortCity1.sortMapByCity(map);
            List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
            assertEquals(contact2.getContactID(), list.get(0).getContactID());
            assertEquals(contact1.getContactID(), list.get(1).getContactID());
        }
     @Test
    public void testSameNameMapEntry(){
        Actions.ContactActions.SortCityAction sortCity1 = new Actions.ContactActions.SortCityAction();
        LinkedHashMap<Integer,Models.ContactModel> myMap = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        myMap.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("jess","rahme","nahr");
        myMap.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = sortCity1.sortMapByCity(myMap);
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        assertEquals(contact2.getContactID(), list.get(1).getContactID());
        assertEquals(contact1.getContactID(), list.get(0).getContactID()); 
    }
    @Test
    public void testSameFirstLetterMapEntry(){
        Actions.ContactActions.SortCityAction sortCity1 = new Actions.ContactActions.SortCityAction();
        LinkedHashMap<Integer,Models.ContactModel> myMap = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        myMap.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("samira","rassil","sahr");
        myMap.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = sortCity1.sortMapByCity(myMap);
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        assertEquals(contact2.getContactID(), list.get(1).getContactID());
        assertEquals(contact1.getContactID(), list.get(0).getContactID()); 
    }


}
