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
import chessGame.Rook;
import junit.framework.TestCase;

public class TestRook extends TestCase{
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
	//Test case: test for Player 1 rook's vertical move, a1->a3
	public void testPlayer1RookVerticalMove() {
		class RookTestStub extends Rook {
			public RookTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		RookTestStub rookStub = new RookTestStub(new PlayerTestStub("John", 1), "a1");
		allChessPieces.add(rookStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = rookStub.isValidMove("a3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's horizontal move, a1->d1
	public void testPlayer1RookHorizontalMove() {
		class RookTestStub extends Rook {
			public RookTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		RookTestStub rookStub = new RookTestStub(new PlayerTestStub("John", 1), "a1");
		allChessPieces.add(rookStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = rookStub.isValidMove("d1");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's blocked move, a1->d1 and c1 blocked
	public void testPlayer1RookBlockedMove() {
		class RookTestStub extends Rook {
			public RookTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		RookTestStub rookStub = new RookTestStub(new PlayerTestStub("John", 1), "a1");
		RookTestStub blockStub = new RookTestStub(new PlayerTestStub("John", 1), "c1");
		allChessPieces.add(rookStub);
		allChessPieces.add(blockStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = rookStub.isValidMove("d1");
		assertEquals(moveResult, false);
	}
}
