package chessGame;
import java.util.*;

public class Main {

	
	public void main(String[] args) {
		Scanner in=new Scanner(System.in);
		ChessMonitoringSystem chessMonitoringSystem=new ChessMonitoringSystem();

                System.out.println("Please choose a mode (1- Classic 2- Scoring): ");
                int mode=in.nextInt();
                in.nextLine();
		
		int numOfPlayer=2;
		ChessPlayer[] players=new ChessPlayer[numOfPlayer];
		for (int i=0;i<numOfPlayer;i++){
			System.out.print("Player "+i+1+" name: ");
			String pName=in.nextLine();
			ChessPlayer player=new ChessPlayer(pName); //constructor : ChessPlayer(String playerName)
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
                        ChessMonitoringSystem.getInstance().showAllChessPiecesPosition();
			if (j==0)
				j++;
			else
				j--;
		}while(!ChessMonitoringSystem.getInstance().isKingCaptured());   //Check if King is captured
		ChessMonitoringSystem.getInstance().getGameResult(mode);
		
		in.close();
		
		
	}

}
