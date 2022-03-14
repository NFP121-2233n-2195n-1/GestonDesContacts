package Memento;
import java.util.List;
import java.util.ArrayList;


/**
 * Write a description of class CareTakerGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CareTakerGroup
{
   private List<MementoGroup> mementoList = new ArrayList<MementoGroup>();

   public void add(MementoGroup state){
      mementoList.add(state);
   }

   public void remove(MementoGroup state){
       mementoList.remove(state);
   }
   
   public void removeLast(){
       MementoGroup state = getLast();
       remove(state);
   }
   
   public MementoGroup get(int index){
      return mementoList.get(index);
   }
   
   public MementoGroup getLast(){
       if(mementoList.size() == 0)return null;
       int lastIndex = mementoList.size() -1;
       return mementoList.get(lastIndex);
   }
}