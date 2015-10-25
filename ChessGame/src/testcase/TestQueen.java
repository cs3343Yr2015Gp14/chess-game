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
import chessGame.Queen;
import junit.framework.TestCase;

public class TestQueen extends TestCase{
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
	//Test case: test Player 1 for Queen's forward move, e1->e3
	public void testPlayer1QueenForwardMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Queen queenStub = new Queen(new ChessPlayer("John", 1), "e1");
		allChessPieces.add(queenStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = queenStub.isValidMove("e3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's backward move, e3->e1
	public void testPlayer1QueenBackwardMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Queen queenStub = new Queen(new ChessPlayer("John", 1), "e3");
		allChessPieces.add(queenStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = queenStub.isValidMove("e1");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's diagonal move to top left, e1->c3
	public void testPlayer1QueenTopLeftMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Queen queenStub = new Queen(new ChessPlayer("John", 1), "e1");
		allChessPieces.add(queenStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = queenStub.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's capturing enemy, e1->c3
	public void testPlayer1QueenCaptureEnemy() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Queen queenStub = new Queen(new ChessPlayer("John", 1), "e1");
		Queen captureStub = new Queen(new ChessPlayer("John", 2), "c3");
		allChessPieces.add(queenStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = queenStub.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's capturing own, e1->c3
	public void testPlayer1QueenCaptureOwn() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Queen queenStub = new Queen(new ChessPlayer("John", 1), "e1");
		Queen captureStub = new Queen(new ChessPlayer("John", 1), "c3");
		allChessPieces.add(queenStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = queenStub.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's capturing own, e1->c3 and d2 is blocked
	public void testPlayer1QueenBlockedMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Queen queenStub = new Queen(new ChessPlayer("John", 1), "e1");
		Queen captureStub = new Queen(new ChessPlayer("John", 1), "d2");
		allChessPieces.add(queenStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = queenStub.isValidMove("c3");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testPlayer1PrintQueen() {
		Queen queen = new Queen(new ChessPlayer("John", 1), null);
		String stringResult = queen.toString();
		assertEquals(stringResult, "Q");
	}
	
	@Test
	public void testPlayer2PrintQueen() {
		Queen queen = new Queen(new ChessPlayer("John", 2), null);
		String stringResult = queen.toString();
		assertEquals(stringResult, "q");
	}
}
