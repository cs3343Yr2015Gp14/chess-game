/**
 * @author PP
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
import junit.framework.TestCase;

public class TestBishop extends TestCase{
	private ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
	
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
	//Test case: test for Player 1 bishop's diagonal move, c1->a3
	public void testPlayer1BishopNormalMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Bishop bishopStub = new Bishop(new ChessPlayer("John", 1), "c1");
		allChessPieces.add(bishopStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = bishopStub.isValidMove("a3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's blocked move, c1->a3 and b2 blocked
	public void testPlayer1BishopBlockedMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Bishop bishopStub = new Bishop(new ChessPlayer("John", 1), "c1");
		Bishop blockedStub = new Bishop(new ChessPlayer("John", 1), "b2");
		allChessPieces.add(bishopStub);
		allChessPieces.add(blockedStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = bishopStub.isValidMove("a3");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testPlayer1PrintBishop() {
		Bishop bishop = new Bishop(new ChessPlayer("John", 1), null);
		String stringResult = bishop.toString();
		assertEquals(stringResult, "B");
	}
	
	@Test
	public void testPlayer2PrintBishop() {
		Bishop bishop = new Bishop(new ChessPlayer("John", 2), null);
		String stringResult = bishop.toString();
		assertEquals(stringResult, "b");
	}
}
