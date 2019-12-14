package model.enumeration;

/**
 * <pre> Provided enum type for Further Programming representing the color of a Slot on the Gaming Wheel
 * <b>NOTE:</b> GREEN0 and GREEN00 are provided as different colors to differentiate the 0 and 00 which
 * are both numeric zero in our implementation</pre>
 * 
 * @author Caspar Ryan
 */
public enum Color
{
	
  
   RED
   {
	   
	   public String correctFormat()
	   {
		   return "Red";
	   }
	   public String toString()
	   {
		   return "RED";
	   }
   },
   BLACK
   {
	   @Override
	   public String correctFormat()
	   {
		   return "Black";
	   }
	   public String toString()
	   {
		   return "BLACK";
	   }
   },
   GREEN0
   {
	   @Override
	   public String correctFormat()
	   {
		   return "Green0";
	   }
	   public String toString()
	   {
		   return "GREEN0";
	   }
   },
   GREEN00
   {
	   @Override
	   public String correctFormat()
	   {
		   return "Green00";
	   }
	   public String toString()
	   {
		   return "GREEN00";
	   }
   },;
	
	   

public abstract String correctFormat();
public abstract String toString();

}
   
   
	


