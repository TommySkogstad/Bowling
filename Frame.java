public class Frame
{
	private int throw1;
	private int throw2;
	private boolean lastFrame;
	private int bonus1;
	private int bonus2;
	private Frame next;

	/**
	 * Creates a bowling frame containing of 2 throws.
	 * There are several special cases, they are:
	 * Strike, strike in last frame and spare in last frame.
	 * @param last Boolean value if set to true if its last frame
	 */
	public Frame(boolean last)
	{
		lastFrame = last;
		if(lastFrame)
		{
			throw1=randomizer(10);
			if(throw1==10)
			{
				bonus1=randomizer(10);
				if(bonus1==10)
					bonus2=randomizer(10);
				else
					bonus2=randomizer(10-bonus1);
				throw2=0;
			}
			else
			{
				throw2=randomizer(10-throw1);
				if((throw1+throw2)==10)
					bonus1=randomizer(10);
				else
					bonus1=0;
				bonus2=0;
			}
		}
		else
		{
			throw1=randomizer(10);
			throw2=randomizer(10-throw1);
			bonus1=bonus2=0;
		}
	}//end constructor

	/**
	 * Constructor without boolean param, set boolean to false as default.
	 */
	public Frame()
	{
		this(false);
	}//end constructor

	/**
	 * Randomizes the throw.
	 * @param n Maximum value for the randomizer to reach
	 * @return Value between 0 and n
	 */
	private int randomizer(int n)
	{
		return (int)(Math.random()*(n+1));
	}//end randomizer

	/**
	 * Set up a link to the next frame, for use in score calculation
	 * @param f Frame linked to
	 */
	public void setNext(Frame f)
	{
		next=f;
	}//end setNext

	/**
	 * @return First throw
	 */
	public int getThrow1()
	{
		return throw1;
	}//end getThrow1

	/**
	 * @return Second throw
	 */
	public int getThrow2()
	{
		return throw2;
	}//end getThrow2

	/**
	 * @return First bonusthrow
	 */
	public int getBonus1()
        {
                return bonus1;
        }//end getBonus1

	/**
	 * @return Second bonusthrow
	 */
        public int getBonus2()
        {
                return bonus2;
        }//end getBonus2

	/**
	 * @return Next frame
	 */
	public Frame getNext()
	{
		return next;
	}//end getNext

	/**
	 * @return True if last frame
	 */
	public boolean isLast()
	{
		return lastFrame;
	}//end isLast

	/**
	 * @return Throws counted this frame
	 */
	public String toString()
	{
		if(lastFrame)//last frame?
			if(throw1==10)//strike?
				if(bonus1==10)//strike again?
					if(bonus2==10)
						return "X X X";
					else
						return "X X " + bonus2;
				else
					return "X " + bonus1 + " " + bonus2;
			else if((throw1+throw2)==10)//spare?
				return throw1 + " / " + bonus1;
			else
				return throw1 + " " + throw2;
		else
			if(throw1==10)//strike?
				return "X";
			else if((throw1+throw2)==10)//spare?
				return throw1 + " /";
			else
				return throw1 + " " + throw2;
	}//end toString
}//end class
