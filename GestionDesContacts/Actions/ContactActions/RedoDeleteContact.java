package Actions.ContactActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class RedoDeleteAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RedoDeleteContact implements IContactAction
{    
    public void actionPerformed(ActionEvent e){
        //redo delete
        
        Controllers.ContactsController cont = Controllers.ContactsController.getInstance();
        
        //get last redo contact from memento
        Memento.OriginatorContact originatorRedo = cont.getOriginatorRedo();
        Memento.CareTakerContact caretakerRedo = cont.getCareTakerRedo();
        
        //get last contact to redelete it
        Memento.MementoContact memento = caretakerRedo.getLast();
        if(memento == null) return;

        originatorRedo.getStateFromMemento(caretakerRedo.getLast());
        Models.ContactModel lastDeletedModel = originatorRedo.getState();
        
        
        //redelete contact from folder
        Data.Globals.getInstance().removeContactFromFolder(lastDeletedModel);
        
        //delete last contact from list of redo mementos
        caretakerRedo.removeLast();
        
        //add deleted contact to undo list
        
        //add last deleted contact to undo mementos list
        Memento.OriginatorContact originatorUndo = cont.getOriginatorUndo();
        Memento.CareTakerContact caretakerUndo = cont.getCareTakerUndo();
        originatorUndo.setState(lastDeletedModel);
        caretakerUndo.add(originatorUndo.saveStateToMemento());
            
    }
}
