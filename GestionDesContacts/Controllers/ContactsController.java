package Controllers;


/**
 * Write a description of class ContactsController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ContactsController
{
    private Views.ContactsView view;
    private static ContactsController instance = new ContactsController();

    private Memento.OriginatorContact originatorUndo;
    private Memento.CareTakerContact caretakerUndo;
    private Memento.OriginatorContact originatorRedo;
    private Memento.CareTakerContact caretakerRedo;
    
    private ContactsController(){
        this.originatorUndo = new Memento.OriginatorContact();
        this.caretakerUndo = new Memento.CareTakerContact();
        this.originatorRedo = new Memento.OriginatorContact();
        this.caretakerRedo = new Memento.CareTakerContact();
        
        this.view = new Views.ContactsView();
        //view observers LinkedHashMaps in Globals
        Data.Globals.getInstance().addObserver(view);
        addListeners();
    }
    
    private void addListeners(){
        view.getSearchButton().addActionListener(new Actions.ContactActions.SearchContactAction());
        view.getAddNewContactButton().addActionListener(new Actions.ContactActions.OpenNewContact());
        view.getDeleteContactButton().addActionListener(new Actions.ContactActions.DeleteContact());
        
        view.getUndoDeleteButton().addActionListener(new Actions.ContactActions.UndoDeleteContact());
        view.getRedoDeleteButton().addActionListener(new Actions.ContactActions.RedoDeleteContact());
        
        view.getSortByFirstNameButton().addActionListener(new Actions.ContactActions.SortFNameAction());
        view.getSortByLastNameButton().addActionListener(new Actions.ContactActions.SortLNameAction());
        view.getSortByCityButton().addActionListener(new Actions.ContactActions.SortCityAction());
        
        view.getViewContactButton().addActionListener(new Actions.ContactActions.OpenViewContact());
        view.getUpdateContactButton().addActionListener(new Actions.ContactActions.OpenUpdateContact());
    }
    
    public Memento.OriginatorContact getOriginatorUndo(){return this.originatorUndo;}
    public Memento.CareTakerContact getCareTakerUndo(){return this.caretakerUndo;}
    public Memento.OriginatorContact getOriginatorRedo(){return this.originatorRedo;}
    public Memento.CareTakerContact getCareTakerRedo(){return this.caretakerRedo;}
    
    
    public static ContactsController getInstance(){
        if(instance == null) instance = new ContactsController();
        return instance;
    }
    
    public Views.ContactsView getView(){return this.view;}
}
