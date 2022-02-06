package Controllers;


/**
 * Write a description of class NewContactController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NewContactController
{
    private Views.NewContactView view;
    
    private static NewContactController instance = new NewContactController();
    
    private NewContactController(){
        this.view = new Views.NewContactView();
        Data.Globals.getInstance().addObserver(view);
        addListeners();
    }
    
    private void addListeners(){
        view.getSaveButton().addActionListener(new Actions.ContactActions.SaveNewContactAction());
        view.getCancelButton().addActionListener(new Actions.ContactActions.CancelNewContactAction());
    }
    
    public static NewContactController getInstance(){
        if(instance == null) instance = new NewContactController();
        return instance;
    }
    
    public Views.NewContactView getView(){return this.view;}
}
