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
import junit.framework.TestCase;

public class TestPawn extends TestCase{
	private ChessMonitoringSystem cms;
	
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() {
		cms = ChessMonitoringSystem.getInstance();
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	@Test
	//Test case: test for Player 1 pawn's special move, a2->a4
	public void testPlayer1PawnSpecialMove() {
		class PawnTestStub extends Pawn {
			public PawnTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		PawnTestStub pawnStub = new PawnTestStub(new PlayerTestStub("John", 1), "a2");
		allChessPieces.add(pawnStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("a4");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 pawn's normal move, a2->a3
	public void testPlayer1PawnForwardMove() {
		class PawnTestStub extends Pawn {
			public PawnTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		PawnTestStub pawnStub = new PawnTestStub(new PlayerTestStub("John", 1), "a2");
		allChessPieces.add(pawnStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("a3");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test for Player 1 pawn's capturing enemy, a2->b3
	public void testPlayer1PawnCaptureEnemy() {
		class PawnTestStub extends Pawn {
			public PawnTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		PawnTestStub pawnStub = new PawnTestStub(new PlayerTestStub("John", 1), "a2");
		PawnTestStub captureStub = new PawnTestStub(new PlayerTestStub("John", 2), "b3");
		allChessPieces.add(pawnStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("b3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 pawn's capturing own, a2->b3
	public void testPlayer1PawnCaptureOwn() {
		class PawnTestStub extends Pawn {
			public PawnTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		PawnTestStub pawnStub = new PawnTestStub(new PlayerTestStub("John", 1), "a2");
		PawnTestStub captureStub = new PawnTestStub(new PlayerTestStub("John", 1), "b3");
		allChessPieces.add(pawnStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("b3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's backward move, a4->b3
	public void testPlayer1PawnBackwardMove() {
		class PawnTestStub extends Pawn {
			public PawnTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		PawnTestStub pawnStub = new PawnTestStub(new PlayerTestStub("John", 1), "a4");
		allChessPieces.add(pawnStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("b3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's blocked move, a2->a3 and a3 blocked
	public void testPlayer1PawnBlockedMove() {
		class PawnTestStub extends Pawn {
			public PawnTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		PawnTestStub pawnStub = new PawnTestStub(new PlayerTestStub("John", 1), "a2");
		PawnTestStub blockStub = new PawnTestStub(new PlayerTestStub("John", 1), "a3");
		allChessPieces.add(pawnStub);
		allChessPieces.add(blockStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("a3");
		assertEquals(moveResult, false);
	}
}
