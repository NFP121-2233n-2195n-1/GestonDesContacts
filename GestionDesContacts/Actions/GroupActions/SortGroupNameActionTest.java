package Actions.GroupActions;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * The test class SortGroupNameActionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SortGroupNameActionTest
{
    /**
     * Default constructor for test class SortGroupNameActionTest
     */
    public SortGroupNameActionTest()
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
        Actions.GroupActions.SortGroupNameAction sortGNam1 = new Actions.GroupActions.SortGroupNameAction();
        assertEquals(null, sortGNam1.sortMapByGroupName(null));
    }
    
    @Test
    public void testRandomGroupsMapEntry()
    {
        Actions.GroupActions.SortGroupNameAction sortGNam1 = new Actions.GroupActions.SortGroupNameAction();
        LinkedHashMap<Integer,Models.GroupModel> map = new LinkedHashMap<Integer,Models.GroupModel>();
        
        Models.GroupModel group1 = new Models.GroupModel("gname1","gdesc1");
        map.put(group1.getGroupID(),group1);
        
        Models.GroupModel group2 = new Models.GroupModel("gname2","gdesc2");
        map.put(group2.getGroupID(),group2);
        
        LinkedHashMap<Integer,Models.GroupModel> newMap = sortGNam1.sortMapByGroupName(map);
        List<Models.GroupModel> list = new ArrayList<Models.GroupModel>(newMap.values());
        assertEquals(group1.getGroupID(), list.get(0).getGroupID());
        assertEquals(group2.getGroupID(), list.get(1).getGroupID());
    }
    
      @Test
    public void testSameNameMapEntry(){
        Actions.GroupActions.SortGroupNameAction sortGNam1 = new Actions.GroupActions.SortGroupNameAction();
        LinkedHashMap<Integer,Models.GroupModel> myMap = new LinkedHashMap<Integer,Models.GroupModel>();
        
        Models.GroupModel group1 = new Models.GroupModel("gname","d");
        myMap.put(group1.getGroupID(),group1);
        
        Models.GroupModel group2 = new Models.GroupModel("gname","d2");
        myMap.put(group2.getGroupID(),group2);
        
        LinkedHashMap<Integer,Models.GroupModel> newMap = sortGNam1.sortMapByGroupName(myMap);
        List<Models.GroupModel> list = new ArrayList<Models.GroupModel>(newMap.values());
        assertEquals(group2.getGroupID(), list.get(1).getGroupID());
        assertEquals(group1.getGroupID(), list.get(0).getGroupID()); 
    }

    @Test
    public void testSameFirstLetterMapEntry(){
        Actions.GroupActions.SortGroupNameAction sortGNam1 = new Actions.GroupActions.SortGroupNameAction();
        LinkedHashMap<Integer,Models.GroupModel> myMap = new LinkedHashMap<Integer,Models.GroupModel>();
        
        Models.GroupModel group1 = new Models.GroupModel("gugu","");
        myMap.put(group1.getGroupID(),group1);
        
        Models.GroupModel group2 = new Models.GroupModel("gaga","");
        myMap.put(group2.getGroupID(),group2);
        
        LinkedHashMap<Integer,Models.GroupModel> newMap = sortGNam1.sortMapByGroupName(myMap);
        List<Models.GroupModel> list = new ArrayList<Models.GroupModel>(newMap.values());
        assertEquals(group2.getGroupID(), list.get(0).getGroupID());
        assertEquals(group1.getGroupID(), list.get(1).getGroupID()); 
    }

}
