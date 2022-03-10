package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;

/**
 * Write a description of class OpenViewContact here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenViewContact implements IOpenContactAction
{    
    public void actionPerformed(ActionEvent e){
        Controllers.ViewContactController controller = Controllers.ViewContactController.getInstance();
        JList list = Controllers.ContactsController.getInstance().getView().getList();
        
        if(list.getSelectedIndex() == -1){return;}
        
        Models.ContactModel model = (Models.ContactModel)list.getSelectedValue();
        controller.setModel(model);
        MainFrame.MainFrame.getInstance().setCurrentPanel(controller.getView());
    }
}
