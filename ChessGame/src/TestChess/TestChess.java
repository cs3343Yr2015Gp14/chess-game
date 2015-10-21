package TestChess;

import static org.junit.Assert.*;

import org.junit.Test;

import chessGame.ChessMonitoringSystem;
import chessGame.ChessPlayer;
import chessGame.ClassicResult;
import chessGame.Result;

public class TestChess {

	@Test
	public void testKingMoveValid() {
		ChessPlayer player = new ChessPlayer("player", 0);
		ChessPlayer player2 = new ChessPlayer("player2", 0);
		Result result = new ClassicResult();
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
		cms.startGame(player, player2, result);
		for (int i = 0 ;i < 8 ; i++){
			for (int j = 0 ;j <2 ; j ++){
				int num = 97 + i;
				char c = (char)num;
				String position = c + Integer.toString(j+1);
				if (i != 3 && j != 0)
					cms.removeChessPiece(position);
			}
		}
		cms.showAllChessPiecesPosition();
		boolean end = cms.moveChessPiece(player, "d1", "e2");
		assertEquals(end, true);
	}
	
	@Test
	public void testKingMoveNotValid() {
		ChessPlayer player = new ChessPlayer("player", 0);
		ChessPlayer player2 = new ChessPlayer("player2", 0);
		Result result = new ClassicResult();
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
		cms.startGame(player, player2, result);
		for (int i = 0 ;i < 8 ; i++){
			for (int j = 0 ;j <2 ; j ++){
				int num = 97 + i;
				char c = (char)num;
				String position = c + Integer.toString(j+1);
				if (i != 3 && j != 0)
					cms.removeChessPiece(position);
			}
		}
		cms.showAllChessPiecesPosition();
		boolean end = cms.moveChessPiece(player, "d1", "f2");
		assertEquals(end, false);
	}
}
