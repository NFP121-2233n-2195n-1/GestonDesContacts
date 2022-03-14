package Actions.GroupActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class RedoDeleteGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RedoDeleteGroup implements IGroupAction
{
    public void actionPerformed(ActionEvent e){
        //redo delete
        
        Controllers.GroupsController cont = Controllers.GroupsController.getInstance();
        
        //get last redo group from memento
        Memento.OriginatorGroup originatorRedo = cont.getOriginatorRedo();
        Memento.CareTakerGroup caretakerRedo = cont.getCareTakerRedo();
        
        //get last group to redelete it
        Memento.MementoGroup memento = caretakerRedo.getLast();
        if(memento == null) return;

        originatorRedo.getStateFromMemento(caretakerRedo.getLast());
        Models.GroupModel lastDeletedModel = originatorRedo.getState();
        
        
        //redelete group from folder
        Data.Globals.getInstance().removeGroupFromFolder(lastDeletedModel);
        
        //delete last group from list of redo mementos
        caretakerRedo.removeLast();
        
        //add deleted group to undo list
        
        //add last deleted group to undo mementos list
        Memento.OriginatorGroup originatorUndo = cont.getOriginatorUndo();
        Memento.CareTakerGroup caretakerUndo = cont.getCareTakerUndo();
        originatorUndo.setState(lastDeletedModel);
        caretakerUndo.add(originatorUndo.saveStateToMemento());
        
    }
}
