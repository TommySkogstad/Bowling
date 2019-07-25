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

	private int score(Frame f)
	{
		int points=0;
		if(f.getThrow1()==10)
			if(f.getNext().getThrow1()==10)
				points+=f.getThrow1()+f.getNext().getThrow1()+f.getNext().getNext().getThrow1();
			else
				points+=f.getThrow1()+f.getNext().getThrow1()+f.getNext().getThrow2();
		else if((f.getThrow1()+f.getThrow2())==10)
			points+=f.getThrow1()+f.getThrow2()+f.getNext().getThrow1();
		else
			points+=f.getThrow1()+f.getThrow2();
		return points;
	}

	public String toString()
	{
		return frame1 + " | " + frame2 + " | " + frame3 + " | " +
			frame4 + " | " + frame5 + " | " + frame6 + " | " +
			frame7 + " | " + frame8 + " | " + frame9 + " | " +
			frame10 + " \n Score:" + score(frame1) + " | " + (score(frame1)+score(frame2));
	}
}
