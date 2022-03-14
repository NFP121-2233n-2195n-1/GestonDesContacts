package Actions.ContactActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class UndoDeleteAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UndoDeleteContact implements IContactAction
{    
    public void actionPerformed(ActionEvent e){
        Controllers.ContactsController cont = Controllers.ContactsController.getInstance();
        
        //undo contact from memento
        Memento.OriginatorContact originatorUndo = cont.getOriginatorUndo();
        Memento.CareTakerContact caretakerUndo = cont.getCareTakerUndo();
        
        //get last deleted contact
        Memento.MementoContact memento = caretakerUndo.getLast();
        if(memento ==null) return;

        originatorUndo.getStateFromMemento(caretakerUndo.getLast());
        Models.ContactModel lastDeletedModel = originatorUndo.getState();
        
        
        //add last deleted contact to folder
        Data.Globals.getInstance().saveContactToFolder(lastDeletedModel);
        
        //delete last contact from list of undo mementos
        caretakerUndo.removeLast();
        
        //add last deleted contact to redo mementos list
        Memento.OriginatorContact originatorRedo = cont.getOriginatorRedo();
        Memento.CareTakerContact caretakerRedo = cont.getCareTakerRedo();
        originatorRedo.setState(lastDeletedModel);
        caretakerRedo.add(originatorRedo.saveStateToMemento());
            
    }
}
