package Memento;


/**
 * Write a description of class OriginatorGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OriginatorGroup
{ 
    private Models.GroupModel state;

   public void setState(Models.GroupModel state){
      this.state = state;
   }

   public Models.GroupModel getState(){
      return state;
   }

   public MementoGroup saveStateToMemento(){
      return new MementoGroup(state);
   }

   public void getStateFromMemento(MementoGroup memento){
      state = memento.getState();
   }
}