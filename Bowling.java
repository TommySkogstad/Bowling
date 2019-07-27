//TODO: import JUnit for testing

public class Bowling
{
	public static void main(String[] args)
	{
		Game myGame = new Game();
		System.out.println("Random game:");
		System.out.println("Frames: " + myGame);
		System.out.println("Score: " + myGame.gameScore());

		Game perfectGame = new Game(10);
		System.out.println("\nPerfect game:");
		System.out.println("Frames: " + perfectGame);
		System.out.println("Score: " + perfectGame.gameScore());

		Game spareGame = new Game(5);
		System.out.println("\nSpare game");
		System.out.println("Frames: " + spareGame);
		System.out.println("Score: " + spareGame.gameScore());

		Game badGame = new Game(3);
		System.out.println("\nBad game:");
		System.out.println("Frames: " + badGame);
		System.out.println("Score: " + badGame.gameScore());

	}//end main
}//end class
