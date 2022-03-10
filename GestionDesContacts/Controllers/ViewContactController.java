package Controllers;


/**
 * Write a description of class ViewContactController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ViewContactController
{
    private Views.ViewContactView view;
    private Models.ContactModel model;
    private static ViewContactController instance = new ViewContactController();
    
    private ViewContactController(){
        addListeners();
    }
    
    public void setModel(Models.ContactModel model){
        this.model = model;
        this.view = new Views.ViewContactView(model);
        Data.Globals.getInstance().addObserver(view);
    }
    
    private void addListeners(){
    }
    
    public static ViewContactController getInstance(){
        if(instance == null) instance = new ViewContactController();
        return instance;
    }
    
    public Views.ViewContactView getView(){return this.view;}
}
