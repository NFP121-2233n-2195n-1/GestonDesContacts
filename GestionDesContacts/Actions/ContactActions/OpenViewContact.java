package Actions.ContactActions;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 * Write a description of class OpenViewContact here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OpenViewContact implements IOpenContactAction
{    
    public void actionPerformed(ActionEvent e){
        MainFrame.MainFrame.getInstance().setCurrentPanel(new JPanel());
    }
}
