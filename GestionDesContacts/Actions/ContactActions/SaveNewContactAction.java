package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**
 * Write a description of class SaveNewContactAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaveNewContactAction implements IContactAction
{
    public void actionPerformed(ActionEvent e){
        Controllers.NewContactController cont = Controllers.NewContactController.getInstance();
        String firstName = ""+cont.getView().getFirstNameTextField().getText();
        String lastName = ""+cont.getView().getLastNameTextField().getText();
        String city = ""+cont.getView().getCityTextField().getText();
        
        
        Models.ContactModel newContact = new Models.ContactModel(firstName, lastName, city);
        Data.Globals.getInstance().saveContactToFolder(newContact);
        JOptionPane.showMessageDialog(null,"Saved Successfully.", "Saved", JOptionPane.WARNING_MESSAGE);
            
    }
}
