package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Write a description of class SaveUpdateContactAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaveUpdateContactAction implements IContactAction
{
    public void actionPerformed(ActionEvent e){
        Controllers.UpdateContactController cont = Controllers.UpdateContactController.getInstance();
        String firstName = ""+cont.getView().getFirstNameTextField().getText();
        String lastName = ""+cont.getView().getLastNameTextField().getText();
        String city = ""+cont.getView().getCityTextField().getText();
        
        //Models.ContactModel newContact = new Models.ContactModel(firstName, lastName, city);
        Models.ContactModel contact = cont.getModel();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setCity(city);
        contact.removeAllPhoneNumbers();
        
        DefaultTableModel model = cont.getView().getTableModel();
        
        for(int i=0; i<model.getRowCount(); i++){
            String regionCode = ""+model.getValueAt(i,0);
            String regionNumber = ""+model.getValueAt(i,1);
            if((regionCode.isEmpty() && regionNumber.isEmpty())
                || (regionCode.equals("null") && regionNumber.equals("null"))){
                continue;
            }
            contact.addPhoneNumber(new Models.PhoneNumber(regionCode, regionNumber));
        }
        
        Data.Globals.getInstance().saveContactToFolder(contact);
        OpenContacts oc = new OpenContacts();
        oc.actionPerformed(e);
        JOptionPane.showMessageDialog(null,"Saved Successfully.", "Saved", JOptionPane.WARNING_MESSAGE);

    }
}
