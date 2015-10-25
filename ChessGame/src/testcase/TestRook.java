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
import chessGame.Pawn;
import chessGame.Rook;
import junit.framework.TestCase;

public class TestRook extends TestCase{
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
	//Test case: test for Player 1 rook's vertical move, a1->a3
	public void testPlayer1RookVerticalMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Rook rookStub = new Rook(new ChessPlayer("John", 1), "a1");
		allChessPieces.add(rookStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = rookStub.isValidMove("a3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's horizontal move, a1->d1
	public void testPlayer1RookHorizontalMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Rook rookStub = new Rook(new ChessPlayer("John", 1), "a1");
		allChessPieces.add(rookStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = rookStub.isValidMove("d1");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's blocked move, a1->d1 and c1 blocked
	public void testPlayer1RookBlockedMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Rook rookStub = new Rook(new ChessPlayer("John", 1), "a1");
		Rook blockStub = new Rook(new ChessPlayer("John", 1), "c1");
		allChessPieces.add(rookStub);
		allChessPieces.add(blockStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = rookStub.isValidMove("d1");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testPlayer1PrintRook() {
		Rook rook = new Rook(new ChessPlayer("John", 1), null);
		String stringResult = rook.toString();
		assertEquals(stringResult, "R");
	}
	
	@Test
	public void testPlayer2PrintRook() {
		Rook rook = new Rook(new ChessPlayer("John", 2), null);
		String stringResult = rook.toString();
		assertEquals(stringResult, "r");
	}
}
