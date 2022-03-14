package Actions.GroupActions;
import java.awt.event.ActionEvent;


/**
 * Write a description of class UndoDeleteGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UndoDeleteGroup implements IGroupAction
{
    public void actionPerformed(ActionEvent e){
        Controllers.GroupsController cont = Controllers.GroupsController.getInstance();
        
        //undo group from memento
        Memento.OriginatorGroup originatorUndo = cont.getOriginatorUndo();
        Memento.CareTakerGroup caretakerUndo = cont.getCareTakerUndo();
        
        //get last deleted group
        Memento.MementoGroup memento = caretakerUndo.getLast();
        if(memento ==null) return;

        originatorUndo.getStateFromMemento(caretakerUndo.getLast());
        Models.GroupModel lastDeletedModel = originatorUndo.getState();
        
        //add last deleted group to folder
        Data.Globals.getInstance().saveGroupToFolder(lastDeletedModel);
        
        //delete last group from list of undo mementos
        caretakerUndo.removeLast();
        
        //add last deleted group to redo mementos list
        Memento.OriginatorGroup originatorRedo = cont.getOriginatorRedo();
        Memento.CareTakerGroup caretakerRedo = cont.getCareTakerRedo();
        originatorRedo.setState(lastDeletedModel);
        caretakerRedo.add(originatorRedo.saveStateToMemento());
            

    }
}
