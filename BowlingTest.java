import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingTest
{
	@Test
	public void testPerfectGameScore()
	{
		Game perfectGame = new Game(10);
		assertEquals(300, perfectGame.gameScore());
	}

	@Test
	public void testSpareGameScore()
	{
		Game spareGame = new Game(5);
		assertEquals(150, spareGame.gameScore());
	}

	@Test
	public void testBadGameScore()
	{
		Game badGame = new Game(3);
		assertEquals(60, badGame.gameScore());
	}
}//end Test
