package Memento;


/**
 * Write a description of class OriginatorContact here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OriginatorContact
{
   private Models.ContactModel state;

   public void setState(Models.ContactModel state){
      this.state = state;
   }

   public Models.ContactModel getState(){
      return state;
   }

   public MementoContact saveStateToMemento(){
      return new MementoContact(state);
   }

   public void getStateFromMemento(MementoContact memento){
      if(memento == null) return;
      state = memento.getState();
   }
}