package Actions.GroupActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class OpenUpdateGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenUpdateGroup implements IOpenGroupAction
{
    public void actionPerformed(ActionEvent e){
       MainFrame.MainFrame.getInstance().setCurrentPanel(Controllers.ContactsController.getInstance().getView());
    }
}
