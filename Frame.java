public class Frame
{
	private int throw1;
	private int throw2;

	public Frame()
	{
		throw1=randomizer(10);
		throw2=randomizer(10-throw1);
	}

	private int randomizer(int n)
	{
		return (int)(Math.random()*(n+1));
	}

	public int getThrow1()
	{
		return throw1;
	}

	public int getThrow2()
	{
		return throw2;
	}

	public String toString()
	{
		if(throw1==10)
			return "X";
		else if((throw1+throw2)==10)
			return "/";
		else
			return String.valueOf((throw1+throw2));
	}
}
