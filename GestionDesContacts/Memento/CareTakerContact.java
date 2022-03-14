package Memento;
import java.util.List;
import java.util.ArrayList;


/**
 * Write a description of class CareTakerContact here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CareTakerContact
{
   private List<MementoContact> mementoList = new ArrayList<MementoContact>();

   public void add(MementoContact state){
      mementoList.add(state);
   }

   public void remove(MementoContact state){
       mementoList.remove(state);
   }
   
   public void removeLast(){
       MementoContact state = getLast();
       remove(state);
   }
   
   public MementoContact get(int index){
      return mementoList.get(index);
   }
   
   public MementoContact getLast(){
       if(mementoList.size() == 0)return null;
       int lastIndex = mementoList.size() -1;
       return mementoList.get(lastIndex);
   }
}