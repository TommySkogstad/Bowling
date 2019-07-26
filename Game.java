public class Game
{
	private Frame[] bowling = new Frame[10];

	public Game()
	{
		for(int i=0;i<bowling.length-1;i++)
			bowling[i] = new Frame(false);
		bowling[9] = new Frame(true);
		for(int i=1;i<bowling.length;i++)
			bowling[i-1].setNext(bowling[i]);
	}//end constructor

	private int frameScore(Frame f)
	{
		if(f.getThrow1()==10)//is this a strike?
			if(f.isLast())//is it last frame?
				return 10+f.getBonus1()+f.getBonus2();
			else if(f.getNext().getThrow1()==10)//is next frame a strike?
				if(f.getNext().isLast())//is it second to last frame?
					return 20+f.getNext().getBonus1();
				else
					 return 20+f.getNext().getNext().getThrow1();
			else
				return 10+f.getNext().getThrow1()+f.getNext().getThrow2();
		else if((f.getThrow1()+f.getThrow2())==10)//is this a spare?
			if(f.isLast())//is it last frame?
				return 10+f.getBonus1();
			else
				return 10+f.getNext().getThrow1();
		else
			 return f.getThrow1()+f.getThrow2();
	}//end frameScore

	public int gameScore()
	{
		int points=0;
		for(Frame f:bowling)
			points+=frameScore(f);
		return points;
	}//end gameScore

	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		for(Frame f:bowling)
			builder.append(f + " | ");
		return builder.toString();
	}//end toString
}//end class
