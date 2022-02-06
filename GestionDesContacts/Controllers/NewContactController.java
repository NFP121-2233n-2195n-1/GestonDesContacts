package Controllers;


/**
 * Write a description of class NewContactController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NewContactController
{
    private Models.ContactModel model;
    private Views.NewContactView view;
    
    private static NewContactController instance = new NewContactController();
    
    private NewContactController(){
        this.model = new Models.ContactModel();
        this.view = new Views.NewContactView();
        model.addObserver(view);
        
        addListeners();
    }
    
    private void addListeners(){
    }
    
    public static NewContactController getInstance(){
        if(instance == null) instance = new NewContactController();
        return instance;
    }
    public Views.NewContactView getView(){return this.view;}
}
