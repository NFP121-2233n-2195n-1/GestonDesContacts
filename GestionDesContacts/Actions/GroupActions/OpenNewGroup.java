package Actions.GroupActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class OpenNewGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenNewGroup implements IOpenGroupAction
{
    public void actionPerformed(ActionEvent e){
       MainFrame.MainFrame.getInstance().setCurrentPanel(Controllers.NewGroupController.getInstance().getView());
    }
}
