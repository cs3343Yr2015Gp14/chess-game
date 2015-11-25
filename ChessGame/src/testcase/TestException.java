package testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import chessGame.ExEnemyChessSelected;
import chessGame.ExInvalidMove;
import chessGame.ExNullMovingChess;

public class TestException {

	@Test
	public void testExEnemyChessSelected() {
		ExEnemyChessSelected ex = new ExEnemyChessSelected();
		String result = ex.getLocalizedMessage();
		assertEquals("Selected piece does not belong to you!", result);
	}
	
	@Test
	public void testExInvalidMove() {
		ExInvalidMove ex = new ExInvalidMove();
		String result = ex.getLocalizedMessage();
		assertEquals("The move is invalid.", result);
	}
	
	@Test
	public void testExNullMovingChess() {
		ExNullMovingChess ex = new ExNullMovingChess();
		String result = ex.getLocalizedMessage();
		assertEquals("Chesspiece not found!", result);
	}

}
