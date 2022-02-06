package Actions.ContactActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class OpenContacts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenContacts implements IOpenContactAction
{
    public void actionPerformed(ActionEvent e){
       MainFrame.MainFrame.getInstance().setCurrentPanel(Controllers.ContactsController.getInstance().getView());
    }
}
