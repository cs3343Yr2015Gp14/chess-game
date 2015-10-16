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
			System.out.println("Please enter the position of the chess pience you want to move: ");
			String oldPos=in.nextLine();
			System.out.println("Please enter the new position: ");
			String newPos=in.nextLine();
			ChessMonitoringSystem.getInstance().moveChessPieces(player[i],oldPos,newPos);
			if (j==0)
				j++;
			else
				j--;
		}while(!ChessMonitoringSystem.getInstance().checkGameResult());   //boolean checkGameResult(): one player win/ draw->return true
		ChessMonitoringSystem.getInstance().getGameResult();  //void getGameResult(): println("Player 1/2 Win" / "Draw")
		
		in.close();
		
		
	}

}
