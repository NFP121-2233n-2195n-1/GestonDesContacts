package Controllers;


/**
 * Write a description of class NewGroupController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NewGroupController
{
    private Views.NewGroupView view;
    private static NewGroupController instance = new NewGroupController();

    public NewGroupController()
    {
        this.view = new Views.NewGroupView();
        Data.Globals.getInstance().addObserver(view);
        addListeners();
    }
    
    private void addListeners(){
        view.getSaveGroupButton().addActionListener(new Actions.GroupActions.SaveNewGroup());
        view.getCancelGroupButton().addActionListener(new Actions.GroupActions.CancelNewGroup());
    }
    
    public static NewGroupController getInstance(){
        if(instance == null) instance = new NewGroupController();
        return instance;
    }
    
    public Views.NewGroupView getView(){return this.view;}
}
