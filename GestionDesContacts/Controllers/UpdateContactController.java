package Controllers;


/**
 * Write a description of class UpdateContactController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UpdateContactController
{
    private Views.UpdateContactView view;
    private Models.ContactModel model;
    private static UpdateContactController instance = new UpdateContactController();
    
    private UpdateContactController(){
        
    }
    
    public void setModel(Models.ContactModel model){
        this.model = model;
        this.view = new Views.UpdateContactView(model);
        addListeners();
        Data.Globals.getInstance().addObserver(view);
    }
    
    public Models.ContactModel getModel(){return this.model;}
    
    private void addListeners(){
        view.getSaveButton().addActionListener(new Actions.ContactActions.SaveUpdateContactAction());
        view.getCancelButton().addActionListener(new Actions.ContactActions.CancelUpdateContactAction());
        view.getAddPhoneNumberButton().addActionListener(new Actions.AddRowToTable(view.getTable()));
    }
    
    public static UpdateContactController getInstance(){
        if(instance == null) instance = new UpdateContactController();
        return instance;
    }
    
    public Views.UpdateContactView getView(){return this.view;}
}
