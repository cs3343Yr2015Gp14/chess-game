/**
 * @author
 *
 */
package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chessGame.ChessMonitoringSystem;
import chessGame.ChessPiece;
import chessGame.ChessPlayer;
import chessGame.Bishop;
import chessGame.King;
import chessGame.Knight;
import chessGame.Pawn;
import chessGame.Queen;
import chessGame.Rook;
import chessGame.GameMode;
import chessGame.ScoringMode;
import junit.framework.TestCase;

public class TestScoringMode extends TestCase{
	private ChessMonitoringSystem chessMonitoringSystem = ChessMonitoringSystem.getInstance();
	
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() {}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	@Test
	public void testAddScore() {
		ChessPlayer player=new ChessPlayer("John", 1);
		GameMode mode = new ScoringMode();
		int[] scoreRelated={10, 0};
		mode.addScore(player, scoreRelated);
		assertEquals(10,player.getPlayerScore());	
	}	

}