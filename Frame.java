public class Frame
{
	private int throw1;
	private int throw2;
	private boolean lastFrame;
	private int bonus1;
	private int bonus2;
	private Frame next;

	public Frame(boolean x)
	{
		lastFrame = x;
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
	}

	private int randomizer(int n)
	{
		return (int)(Math.random()*(n+1));
	}

	public void setNext(Frame f)
	{
		next=f;
	}

	public int getThrow1()
	{
		return throw1;
	}

	public int getThrow2()
	{
		return throw2;
	}

	public int getBonus1()
        {
                return bonus1;
        }

        public int getBonus2()
        {
                return bonus2;
        }

	public Frame getNext()
	{
		return next;
	}

	public boolean isLast()
	{
		return lastFrame;
	}

	public String toString()
	{
		if(lastFrame)
			if(throw1==10)
				if(bonus1==10)
					if(bonus2==10)
						return "X X X";
					else
						return "X X " + bonus2;
				else
					return "X " + bonus1 + " " + bonus2;
			else if((throw1+throw2)==10)
				return throw1 + " / " + bonus1;
			else
				return throw1 + " " + throw2;
		else
		{
			if(throw1==10)
				return "X";
			else if((throw1+throw2)==10)
				return throw1 + " /";
			else
				return throw1 + " " + throw2;
		}
	}
}
