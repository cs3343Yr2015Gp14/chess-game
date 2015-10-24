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
	//Test case: test for Player 1 bishop's diagonal move, c1->a3
	public void testPlayer1BishopNormalMove() {
		class BishopTestStub extends Bishop {
			public BishopTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		BishopTestStub bishopStub = new BishopTestStub(new PlayerTestStub("John", 1), "c1");
		allChessPieces.add(bishopStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = bishopStub.isValidMove("a3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's blocked move, c1->a3 and b2 blocked
	public void testPlayer1BishopBlockedMove() {
		class BishopTestStub extends Bishop {
			public BishopTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		BishopTestStub bishopStub = new BishopTestStub(new PlayerTestStub("John", 1), "c1");
		BishopTestStub blockedStub = new BishopTestStub(new PlayerTestStub("John", 1), "b2");
		allChessPieces.add(bishopStub);
		allChessPieces.add(blockedStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = bishopStub.isValidMove("a3");
		assertEquals(moveResult, false);
	}
	
}
