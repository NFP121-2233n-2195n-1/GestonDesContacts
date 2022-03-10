package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Write a description of class CancelUpdateContactAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CancelUpdateContactAction implements IContactAction
{
    public void actionPerformed(ActionEvent e){
        int cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Cancel", JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
                
        if(cancel == JOptionPane.YES_OPTION){
            OpenContacts oc = new OpenContacts();
            oc.actionPerformed(e);
        }
        cancel = 0;
    }
}
