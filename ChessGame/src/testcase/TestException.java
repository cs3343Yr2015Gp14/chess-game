package testcase;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import chessGame.ExEnemyChessSelected;
import chessGame.ExInvalidMove;
import chessGame.ExNullMovingChess;
import chessGame.ExOwnChessCaptured;

public class TestException {
	private ByteArrayOutputStream baos;
	private PrintStream ps;

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
	
	@Test
	public void testExOwnChessCaptured() {
		ExOwnChessCaptured ex = new ExOwnChessCaptured();
		String result = ex.getLocalizedMessage();
		assertEquals("You cannot capture your own chessPiece!", result);
	}

}
