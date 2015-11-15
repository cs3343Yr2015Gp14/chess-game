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
import junit.framework.TestCase;

public class TestChessPlayer extends TestCase{
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
	public void testAddAndGetScore() {
		ChessPlayer player=new ChessPlayer("John", 1);
		player.addScore(10);
		assertEquals(10,player.getPlayerScore());
	}	
	
	//test getPlayerScore
	@Test
	public void testgetPlayerScore() {
		ChessPlayer player=new ChessPlayer("John", 1);
		int result = player.getPlayerScore();
		assertEquals(0,result);
	}
	
	//test getPlayerId
	@Test
	public void testgetPlayerId() {
		ChessPlayer player=new ChessPlayer("John", 1);
		int result = player.getPlayerId();
		assertEquals(1,result);
	}
	
	//test lossPiece
	public void testlossPiece() {
		ChessPlayer player=new ChessPlayer("John", 1);
		int result = player.getPlayerId();
		assertEquals(1,result);
	}
	
}