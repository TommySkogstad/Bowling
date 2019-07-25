public class Game
{
	public Frame frame1;
	public Frame frame2;
	public Frame frame3;
	public Frame frame4;
	public Frame frame5;
	public Frame frame6;
	public Frame frame7;
	public Frame frame8;
	public Frame frame9;
	public Frame frame10;

	public Game()
	{
		frame1 = new Frame(false);
		frame2 = new Frame(false);
		frame3 = new Frame(false);
		frame4 = new Frame(false);
		frame5 = new Frame(false);
		frame6 = new Frame(false);
		frame7 = new Frame(false);
		frame8 = new Frame(false);
		frame9 = new Frame(false);
		frame10 = new Frame(true);
	}

	private int score()
	{
		int points=0;
		if(frame1.getThrow1()==10)
			if(frame2.getThrow1()==10)
				points+=frame1.getThrow1()+frame2.getThrow1()+frame3.getThrow1();
			else
				points+=frame1.getThrow1()+frame2.getThrow1()+frame2.getThrow2();
		else if((frame1.getThrow1()+frame1.getThrow2())==10)
			points+=frame1.getThrow1()+frame1.getThrow2()+frame2.getThrow1();
		else
			points+=frame1.getThrow1()+frame1.getThrow2();
		return points;
	}

	public String toString()
	{
		return frame1 + " | " + frame2 + " | " + frame3 + " | " +
			frame4 + " | " + frame5 + " | " + frame6 + " | " +
			frame7 + " | " + frame8 + " | " + frame9 + " | " +
			frame10 + " | Score:" + score();
	}
}
