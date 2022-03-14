package Memento;


/**
 * Write a description of class MementoContact here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MementoContact
{
   private Models.ContactModel state;

   public MementoContact(Models.ContactModel state){
      this.state = state;
   }

   public Models.ContactModel getState(){
      return state;
   }    
}