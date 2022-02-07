package Actions.GroupActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class OpenGroups here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenGroups implements IOpenGroupAction
{
    public void actionPerformed(ActionEvent e){
       MainFrame.MainFrame.getInstance().setCurrentPanel(Controllers.GroupsController.getInstance().getView());
    }
}
