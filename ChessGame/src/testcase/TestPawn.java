/**
 * @author PP
 *
 */
package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chessGame.Bishop;
import chessGame.ChessMonitoringSystem;
import chessGame.ChessPiece;
import chessGame.ChessPlayer;
import chessGame.Pawn;
import chessGame.Rook;
import junit.framework.TestCase;

public class TestPawn extends TestCase{
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
	//Test case: test for Player 1 pawn move to current position, a2->a4
	public void testPlayer1PawnMoveToCurrentPos() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a2");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's special move, a2->a4
	public void testPlayer1PawnSpecialMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a4");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 pawn's normal move, a2->a3
	public void testPlayer1PawnForwardMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a3");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test for Player 1 pawn's capturing enemy, a6->b7
	public void testPlayer1PawnCaptureEnemy() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);

		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		pawnAta2.updatePosition("a6");
		
		boolean moveResult = pawnAta2.isValidMove("b7");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 pawn's capturing own, pawn b2->b3, pawn a2->b3
	public void testPlayer1PawnCaptureOwn() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece ownPiece = cms.getChessPiece("b2");
		ownPiece.updatePosition("b3");
		
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("b3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's backward move, rook a1->a3, a2->a1
	public void testPlayer1PawnBackwardMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a3");
		
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's backward move, a2->h6
	public void testPlayer1PawnInvalidMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);

		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("h6");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's blocked move, pawn a2->a3 and a3 blocked
	public void testPlayer1PawnBlockedMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a3");
		
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a3");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testPawnGetScore() {
		Pawn pawn = new Pawn(new ChessPlayer("John", 1), null);
		int score = pawn.getScore();
		assertEquals(score, 10);
	}
	
	@Test
	public void testPlayer1PrintPawn() {
		Pawn pawn = new Pawn(new ChessPlayer("John", 1), null);
		String stringResult = pawn.toString();
		assertEquals(stringResult, "P");
	}
	
	@Test
	public void testPlayer2PrintPawn() {
		Pawn pawn = new Pawn(new ChessPlayer("John", 2), null);
		String stringResult = pawn.toString();
		assertEquals(stringResult, "p");
	}
}
