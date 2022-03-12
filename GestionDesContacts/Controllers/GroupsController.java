package Controllers;


/**
 * Write a description of class GroupsController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GroupsController
{
    private Views.GroupsView view;
    private static GroupsController instance = new GroupsController();
    
    public GroupsController()
    {
        this.view = new Views.GroupsView();
        Data.Globals.getInstance().addObserver(view);
        addListeners();
    }
    
    private void addListeners(){
        view.getAddNewGroupButton().addActionListener(new Actions.GroupActions.OpenNewGroup());
        view.getUpdateGroupButton().addActionListener(new Actions.GroupActions.OpenUpdateGroup());

        view.getGroupsTable().getSelectionModel().addListSelectionListener(new Actions.GroupActions.LoadContactsForGroup());
    }
    
    public static GroupsController getInstance(){
        if(instance == null) instance = new GroupsController();
        return instance;
    }
    public Views.GroupsView getView(){return this.view;}
}
