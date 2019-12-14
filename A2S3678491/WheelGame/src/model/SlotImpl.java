package model;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot  {
	
	
	private int position;
	private Color color;
	private int number;
	
	
	public SlotImpl(int position, Color color, int number)
	{
		this.position = position;
		this.color = color;
		this.number = number;
	}

	@Override
	public int getPosition() 
	{	
		return position;
	}

	@Override
	public int getNumber() 
	{	
		return number;
	}

	@Override
	public Color getColor()
	{	
		return color;
	}

	@Override
	public boolean equals(Slot slot) 
	{
		boolean result = false;
		if(slot.getNumber() == this.number && slot.getColor().equals(this.color))
		{
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean equals(Object slot)
	{
		boolean result = false;	
		if(slot instanceof Slot)
		{
			SlotImpl slotToBeCompare =  (SlotImpl) slot;
			if(this.equals(slotToBeCompare) && (this.hashCode() == slotToBeCompare.hashCode()))
			{
				result = true;
			}
		}
		
		return result;
	}
	
	@Override
	public int hashCode()
	{
		return this.hashCode();
	}
	
	@Override
	public String toString()
	{
		return String.format("Position: %d,  Color: %s, Number: %d",
				             this.getPosition(), this.getColor().correctFormat(), this.getNumber());
	}
	

}
