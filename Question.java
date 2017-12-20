
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Question 
{
    private String list;
    
    
   public Question(String x)
   {
       list = x;
       
       
       
    }
    
    public boolean isThere(String place)
    {
       if(list.contains(place))
       {
           return true;
        }
        
        return false;
       
       
       
        
    

}
}