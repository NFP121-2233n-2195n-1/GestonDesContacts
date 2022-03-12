package Actions.ContactActions;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * The test class SearchContactActionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SearchContactActionTest
{
    /**
     * Default constructor for test class SearchContactActionTest
     */
    public SearchContactActionTest()
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
    public void testNullWordEntry()
    {
        Actions.ContactActions.SearchContactAction searchAction1 = new Actions.ContactActions.SearchContactAction();
        assertEquals((searchAction1.searchMapByWord(null,null)).size(), 0);
    }
    
    @Test
    public void testRandomContactsMapEntry()
    {
        Actions.ContactActions.SearchContactAction searchAction1 = new Actions.ContactActions.SearchContactAction();
        LinkedHashMap<Integer,Models.ContactModel> map = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        map.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("jess","bassil","nahr");
        map.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = searchAction1.searchMapByWord(map,"s");
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        //contact1 contains s in the fist name
        assertEquals(contact1.getContactID(), list.get(0).getContactID());

        //contact2 contains s in the last name
        assertEquals(contact2.getContactID(), list.get(1).getContactID());
    }
    
    @Test
    public void testRandomContactsMapEntry2()
    {
        Actions.ContactActions.SearchContactAction searchAction1 = new Actions.ContactActions.SearchContactAction();
        LinkedHashMap<Integer,Models.ContactModel> map = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        map.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("toni","habche","nahr");
        map.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = searchAction1.searchMapByWord(map,"s");
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
        //contact1 contains s in the fist name
        assertEquals(contact1.getContactID(), list.get(0).getContactID());

    }
    
      @Test
    public void testRandomContactsMapEntry3()
    {
        Actions.ContactActions.SearchContactAction searchAction1 = new Actions.ContactActions.SearchContactAction();
        LinkedHashMap<Integer,Models.ContactModel> map = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        map.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("jess","bassil","nahr");
        map.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = searchAction1.searchMapByWord(map,"t");
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
    
        assertEquals(list.size(), 0);
    }
    
    @Test
    public void testEmptySearch()
    {
        Actions.ContactActions.SearchContactAction searchAction1 = new Actions.ContactActions.SearchContactAction();
        LinkedHashMap<Integer,Models.ContactModel> map = new LinkedHashMap<Integer,Models.ContactModel>();
        
        Models.ContactModel contact1 = new Models.ContactModel("susu","rahme","nahr");
        map.put(contact1.getContactID(),contact1);
        
        Models.ContactModel contact2 = new Models.ContactModel("jess","bassil","nahr");
        map.put(contact2.getContactID(),contact2);
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = searchAction1.searchMapByWord(map,null);
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
      
        assertEquals(contact1.getContactID(), list.get(0).getContactID());
        assertEquals(contact2.getContactID(), list.get(1).getContactID());
    }
    
    @Test
    public void testEmptyMap()
    {
        Actions.ContactActions.SearchContactAction searchAction1 = new Actions.ContactActions.SearchContactAction();
       
        
        LinkedHashMap<Integer,Models.ContactModel> newMap = searchAction1.searchMapByWord(null,"s");
        List<Models.ContactModel> list = new ArrayList<Models.ContactModel>(newMap.values());
      
        assertEquals(list.size(), 0);

    }
}
