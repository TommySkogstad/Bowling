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
		frame1.setNext(frame2);
		frame3 = new Frame(false);
		frame2.setNext(frame3);
		frame4 = new Frame(false);
		frame3.setNext(frame4);
		frame5 = new Frame(false);
		frame4.setNext(frame5);
		frame6 = new Frame(false);
		frame5.setNext(frame6);
		frame7 = new Frame(false);
		frame6.setNext(frame7);
		frame8 = new Frame(false);
		frame7.setNext(frame8);
		frame9 = new Frame(false);
		frame8.setNext(frame9);
		frame10 = new Frame(true);
		frame9.setNext(frame10);
	}

	private int frameScore(Frame f)
	{
		int points=0;
		if(f.getThrow1()==10)//is this a strike?
			if(f.isLast())//is it last frame?
				points+=10+f.getBonus1()+f.getBonus2();
			else if(f.getNext().getThrow1()==10)//is next frame a strike?
				if(f.getNext().isLast())//is it second to last frame?
					points+=20+f.getNext().getBonus1();
				else
					points+=20+f.getNext().getNext().getThrow1();
			else
				points+=10+f.getNext().getThrow1()+f.getNext().getThrow2();
		else if((f.getThrow1()+f.getThrow2())==10)//is this a spare?
			if(f.isLast())//is it last frame?
				points+=10+f.getBonus1();
			else
				points+=10+f.getNext().getThrow1();
		else
			points+=f.getThrow1()+f.getThrow2();
		return points;
	}

	public int gameScore()
	{
		int points=0;
		Frame f = frame1;
		while(!f.isLast())
		{
			points+=frameScore(f);
			f=f.getNext();
		}
		points+=frameScore(f);
		return points;
	}

	public String toString()
	{
		return "Frames: " + frame1 + " | " + frame2 + " | " + frame3 + " | " + frame4 + " | " + frame5 + " | " +
			frame6 + " | " + frame7 + " | " + frame8 + " | " + frame9 + " | " + frame10;
	}
}
