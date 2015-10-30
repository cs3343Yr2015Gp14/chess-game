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
import chessGame.King;
import chessGame.Pawn;
import junit.framework.TestCase;

public class TestKing extends TestCase{
	private ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();

    /**
     * Sets up the ChessMonitoringSystem
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
	//Test case: test Player 1 for King's forward move, d1->d2
	public void testPlayer1KingForwardMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		King kingStub = new King(new ChessPlayer("John", 1), "d1");
		allChessPieces.add(kingStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = kingStub.isValidMove("d2");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 King's backward move, d2->d1
	public void testPlayer1KingBackwardMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		King kingStub = new King(new ChessPlayer("John", 1), "d2");
		allChessPieces.add(kingStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = kingStub.isValidMove("d1");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 King's diagonal move to top left, d1->c2
	public void testPlayer1KingTopLeftMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		King kingStub = new King(new ChessPlayer("John", 1), "d1");
		allChessPieces.add(kingStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = kingStub.isValidMove("c2");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 King's capturing enemy, d1->c2
	public void testPlayer1KingCaptureEnemy() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		King kingStub = new King(new ChessPlayer("John", 1), "d1");
		King captureStub = new King(new ChessPlayer("John", 2), "c2");
		allChessPieces.add(kingStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = kingStub.isValidMove("c2");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 King's capturing own, d1->c2
	public void testPlayer1KingCaptureOwn() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		King kingStub = new King(new ChessPlayer("John", 1), "d1");
		King captureStub = new King(new ChessPlayer("John", 1), "c2");
		allChessPieces.add(kingStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = kingStub.isValidMove("c2");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testPlayer1PrintKing() {
		King king = new King(new ChessPlayer("John", 1), null);
		String stringResult = king.toString();
		assertEquals(stringResult, "K");
	}
	
	@Test
	public void testPlayer2PrintKing() {
		King king = new King(new ChessPlayer("John", 2), null);
		String stringResult = king.toString();
		assertEquals(stringResult, "k");
	}
}