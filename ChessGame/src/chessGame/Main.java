package chessGame;
import java.util.*;

public class Main {

	
	public void main(String[] args) {
		Scanner in=new Scanner(System.in);
		ChessMonitoringSystem chessMonitoringSystem=new ChessMonitoringSystem();
		
		int numOfPlayer=2;
		ChessPlayer[] players=new ChessPlayer[numOfPlayer];
		for (int i=0;i<numOfPlayer;i++){
			System.out.print("Player "+i+1+" name: ");
			String pName=in.nextLine();
			ChessPlayer player=new ChessPlayer(pName,i); //constructor : ChessPlayer(String playerName, int playerNumber)
			players[i]=player;
		}
		ChessMonitoringSystem.getInstance().initializeChessBoard();
		ChessMonitoringSystem.getInstance().initializeChessPieces();
		ChessMonitoringSystem.getInstance().showAllChessPiecesPosition();
		int j=0;
		do{
			System.out.println("ChessType: (K-King, Q-Queen, R-Rook, N-Knight, B-Bishop, P-Pawn)");
			System.out.println("Please enter action: e.g. P11, N76");
			String move=in.nextLine();
			ChessMonitoringSystem.getInstance().moveChessPieces(player[j],move);
			if (j==0)
				j++;
			else
				j--;
		}while(!ChessMonitoringSystem.getInstance().checkGameResult());   //boolean checkGameResult(): one player win/ draw->return true
		ChessMonitoringSystem.getInstance().getGameResult();  //void getGameResult(): println("Player 1/2 Win" / "Draw")
		
		in.close();
		
		
	}

}