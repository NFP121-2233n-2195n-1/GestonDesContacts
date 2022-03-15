package Actions.GroupActions;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class SortGroupContactsNbActionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SortGroupContactsNbActionTest
{
    /**
     * Default constructor for test class SortGroupContactsNbActionTest
     */
    public SortGroupContactsNbActionTest()
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
        Actions.GroupActions.SortGroupContactsNbAction sortGCNb = new Actions.GroupActions.SortGroupContactsNbAction();
        assertEquals(null, sortGCNb.sortMapByGroupName(null));
    }
    
    @Test
    public void testRandomGroupsMapEntry()
    {
        Actions.GroupActions.SortGroupContactsNbAction sortGCNb = new Actions.GroupActions.SortGroupContactsNbAction();
        LinkedHashMap<Integer,Models.GroupModel> map = new LinkedHashMap<Integer,Models.GroupModel>();
        
        Models.GroupModel group1 = new Models.GroupModel("gname1","gdesc1");
        map.put(group1.getGroupID(),group1);
        
        Models.GroupModel group2 = new Models.GroupModel("gname2","gdesc2");
        Models.ContactModel contact1 = new Models.ContactModel("f","l","c");
        group2.addContact(contact1.getContactID());
        map.put(group2.getGroupID(),group2);
        
        LinkedHashMap<Integer,Models.GroupModel> newMap = sortGCNb.sortMapByGroupName(map);
        List<Models.GroupModel> list = new ArrayList<Models.GroupModel>(newMap.values());
        assertEquals(group1.getGroupID(), list.get(0).getGroupID());
        assertEquals(group2.getGroupID(), list.get(1).getGroupID());
    }
    
      @Test
    public void testSameNbMapEntry(){
        Actions.GroupActions.SortGroupContactsNbAction sortGCNb = new Actions.GroupActions.SortGroupContactsNbAction();
        LinkedHashMap<Integer,Models.GroupModel> myMap = new LinkedHashMap<Integer,Models.GroupModel>();
        
        Models.GroupModel group1 = new Models.GroupModel("gname","d");
        myMap.put(group1.getGroupID(),group1);
        
        Models.GroupModel group2 = new Models.GroupModel("gname","d2");
        myMap.put(group2.getGroupID(),group2);
        
        LinkedHashMap<Integer,Models.GroupModel> newMap = sortGCNb.sortMapByGroupName(myMap);
        List<Models.GroupModel> list = new ArrayList<Models.GroupModel>(newMap.values());
        assertEquals(group2.getGroupID(), list.get(1).getGroupID());
        assertEquals(group1.getGroupID(), list.get(0).getGroupID()); 
    }

}
