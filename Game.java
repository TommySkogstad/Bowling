public class Game extends Frame
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
		frame1 = new Frame();
		frame2 = new Frame();
		frame3 = new Frame();
		frame4 = new Frame();
		frame5 = new Frame();
		frame6 = new Frame();
		frame7 = new Frame();
		frame8 = new Frame();
		frame9 = new Frame();
		frame10 = new Frame(); //TODO: add bonusthrows
	}

	public String toString()
	{
		return frame1 + " " + frame2 + " " + frame3 + " " +
			frame4 + " " + frame5 + " " + frame6 + " " +
			frame7 + " " + frame8 + " " + frame9 + " " +
			frame10 + " ";
	}
}
