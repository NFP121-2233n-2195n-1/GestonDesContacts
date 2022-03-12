package Controllers;


/**
 * Write a description of class UpdateGroupController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UpdateGroupController
{
    private Views.UpdateGroupView view;
    private static UpdateGroupController instance = new UpdateGroupController();
    
    private Models.GroupModel model;
    
    public UpdateGroupController()
    {
    }
    
    public void setModel(Models.GroupModel model){
        this.model = model;
        this.view = new Views.UpdateGroupView(model);
        addListeners();
        Data.Globals.getInstance().addObserver(view);
    }
    
    public Models.GroupModel getModel(){return this.model;}
    
    private void addListeners(){
        view.getSaveGroupButton().addActionListener(new Actions.GroupActions.SaveUpdateGroup());
        view.getCancelGroupButton().addActionListener(new Actions.GroupActions.CancelUpdateGroup());

        //for memento
        view.getGroupNameTextField().addActionListener(null);
        view.getGroupDescriptionTextField().addActionListener(null);
        view.getContactsTable().getModel().addTableModelListener(null);
    }
    
    public static UpdateGroupController getInstance(){
        if(instance == null) instance = new UpdateGroupController();
        return instance;
    }
    
    public Views.UpdateGroupView getView(){return this.view;}
}
