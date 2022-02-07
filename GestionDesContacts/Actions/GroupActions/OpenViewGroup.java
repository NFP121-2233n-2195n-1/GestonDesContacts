package Actions.GroupActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class OpenViewGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenViewGroup implements IOpenGroupAction
{
    public void actionPerformed(ActionEvent e){
       MainFrame.MainFrame.getInstance().setCurrentPanel(Controllers.ContactsController.getInstance().getView());
    }
}
