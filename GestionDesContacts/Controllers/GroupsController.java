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
    
    private Memento.OriginatorGroup originatorUndo;
    private Memento.CareTakerGroup caretakerUndo;
    private Memento.OriginatorGroup originatorRedo;
    private Memento.CareTakerGroup caretakerRedo;

    
    public GroupsController()
    {
        this.originatorUndo = new Memento.OriginatorGroup();
        this.caretakerUndo = new Memento.CareTakerGroup();
        this.originatorRedo = new Memento.OriginatorGroup();
        this.caretakerRedo = new Memento.CareTakerGroup();
        
        this.view = new Views.GroupsView();
        Data.Globals.getInstance().addObserver(view);
        addListeners();
    }
    
    private void addListeners(){
        view.getAddNewGroupButton().addActionListener(new Actions.GroupActions.OpenNewGroup());
        view.getUpdateGroupButton().addActionListener(new Actions.GroupActions.OpenUpdateGroup());
        view.getDeleteGroupButton().addActionListener(new Actions.GroupActions.DeleteGroup());
        
        view.getSortByGroupNameButton().addActionListener(new Actions.GroupActions.SortGroupNameAction());
        view.getSortByNbOfContactsButton().addActionListener(new Actions.GroupActions.SortGroupContactsNbAction());
        
        view.getUndoDeleteButton().addActionListener(new Actions.GroupActions.UndoDeleteGroup());
        view.getRedoDeleteButton().addActionListener(new Actions.GroupActions.RedoDeleteGroup());
        
        view.getGroupsTable().getSelectionModel().addListSelectionListener(new Actions.GroupActions.LoadContactsForGroup());
    }
    
    public Memento.OriginatorGroup getOriginatorUndo(){return this.originatorUndo;}
    public Memento.CareTakerGroup getCareTakerUndo(){return this.caretakerUndo;}
    public Memento.OriginatorGroup getOriginatorRedo(){return this.originatorRedo;}
    public Memento.CareTakerGroup getCareTakerRedo(){return this.caretakerRedo;}
    
    public static GroupsController getInstance(){
        if(instance == null) instance = new GroupsController();
        return instance;
    }
    public Views.GroupsView getView(){return this.view;}
}
