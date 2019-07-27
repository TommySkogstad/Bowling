public class Game
{
	private Frame[] bowling = new Frame[10];

	/**
	 * Creates a game of ten frames, where the last is flagged as last frame.
	 * Also sets to order, used for scoring
	 */
	public Game()
	{
		for(int i=0;i<bowling.length-1;i++)
			bowling[i] = new Frame();
		bowling[9] = new Frame(true);
		for(int i=1;i<bowling.length;i++)
			bowling[i-1].setNext(bowling[i]);
	}//end constructor

	/**
	 * Calculates score for a single frame, check for last frame
	 * @param f Frame to calculate score for
	 * @return Score for a single frame
	 */
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

	/**
	 * Calculate score for whole game, added score for every frame together
	 * @return Total score
	 */
	public int gameScore()
	{
		int points=0;
		for(Frame f:bowling)
			points+=frameScore(f);
		return points;
	}//end gameScore

	/**
	 * @return A formated string containing every throw in the game.
	 */
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		for(Frame f:bowling)
			builder.append(f + " | ");
		return builder.toString();
	}//end toString
}//end class
