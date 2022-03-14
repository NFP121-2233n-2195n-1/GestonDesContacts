package Memento;


/**
 * Write a description of class MementoGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MementoGroup
{
   private Models.GroupModel state;

   public MementoGroup(Models.GroupModel state){
      this.state = state;
   }

   public Models.GroupModel getState(){
      return state;
   }    
}