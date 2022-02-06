package Actions.ContactActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class OpenNewContact here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenNewContact implements IOpenContactAction
{    
    public void actionPerformed(ActionEvent e){
           MainFrame.MainFrame.getInstance().setCurrentPanel(Controllers.NewContactController.getInstance().getView());
    }
}
