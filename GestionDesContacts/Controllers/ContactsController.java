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
    
    private ContactsController(){
        this.view = new Views.ContactsView();
        Data.Globals.getInstance().addObserver(view);
        addListeners();
    }
    
    private void addListeners(){
        view.getSearchButton().addActionListener(new Actions.ContactActions.SearchContactAction());
    }
    
    public static ContactsController getInstance(){
        if(instance == null) instance = new ContactsController();
        return instance;
    }
    public Views.ContactsView getView(){return this.view;}
}
