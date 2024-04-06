package game2048;

public class Board {
	// declare variables
	private static int[][] board;
	
	public Board() {
		board = new int[4][4];
	}
	
	public void setBoard(int r, int c, int value) {
		board[r][c] = value;
	}
	
	public int getSpot(int r, int c) {
		return board[r][c];
	}
	
	public int[][] getBoard() {
		return board;
	}
	// print out the board
	public String printBoard() {
	    StringBuilder boardStr = new StringBuilder("+-----+-----+-----+-----+\r\n");
	    for (int i = 0; i < 4; i++) {
	        boardStr.append("| ");
	        for (int j = 0; j < 4; j++) {
	            if (board[i][j] != 0) {
	                if(board[i][j] < 10)
	                    boardStr.append(" ").append(board[i][j]).append("  | ");
	                else if(board[i][j] < 100)
	                    boardStr.append(" ").append(board[i][j]).append(" | ");
	                else if(board[i][j] < 1000)
	                    boardStr.append(board[i][j]).append(" | ");
	                else
	                    boardStr.append(board[i][j]).append("| ");
	            } else {
	                boardStr.append("    | ");
	            }
	        }
	        boardStr.append("\r\n+-----+-----+-----+-----+\r\n");
	    }
	    return boardStr.toString();
	}
}
