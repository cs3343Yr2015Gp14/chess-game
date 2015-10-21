package chessGame;

public class Invoker {
	public Command cmd;
	public void callCmd(Command cmd){
		this.cmd = cmd;
	}
	public boolean execute(ChessPlayer player1, ChessPlayer player2, String related){
		return this.cmd.execute(player1,player2, related);
	}
}
