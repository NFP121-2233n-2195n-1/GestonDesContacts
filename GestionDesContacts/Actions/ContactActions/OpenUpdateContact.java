package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.JList;


/**
 * Write a description of class OpenUpdateContact here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenUpdateContact implements IOpenContactAction
{    
    public void actionPerformed(ActionEvent e){
        Controllers.UpdateContactController controller = Controllers.UpdateContactController.getInstance();
        JList list = Controllers.ContactsController.getInstance().getView().getList();
        
        if(list.getSelectedIndex() == -1){return;}
        
        Models.ContactModel model = (Models.ContactModel)list.getSelectedValue();
        controller.setModel(model);
        MainFrame.MainFrame.getInstance().setCurrentPanel(controller.getView());
    }
}
