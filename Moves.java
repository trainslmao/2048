package game2048;

public class Moves {
	// declare variables
	Board board;
	boolean play;
	public Moves() {
		board = new Board();
		play = true;
	}
	
	// create starter board
	public void addSpot() {
		// create values to be put in the spot
		int random = (int) (Math.random() * 10) + 1;
		int valueOfSpot = (random != 9) ? 2 : 4;
		
		// add spots if there are empty ones
		if (anyValid()) {
			while (true) {
				int randomR = (int) (Math.random() * 4);
				int randomC = (int) (Math.random() * 4);
				if (board.getSpot(randomR, randomC) == 0) {
					board.setBoard(randomR, randomC, valueOfSpot);
					return;
				}
			}
		}
	}
	
	public boolean anyValid() {
		// iterate through board for empty spots
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 4; k++) {
				if (board.getSpot(i, k) == 0) {
					return true;
				}
			}
		}
		
		// return false if not and set play to false
		play = false;
		return false;
	}
	
	public void createBoard() {
		addSpot();
		addSpot();
	}
	
	// move
	public void moveUp() {
		// start from second row
		for (int i = 1; i < 4; i++) {
			// all columns
			for (int j = 0; j < 4; j++) {
				// make sure spot above is empty
				if (board.getSpot(i, j) != 0 && board.getSpot(i - 1, j) == 0) {
	                int k = i;
	                // move up as long as empty
	                while (k > 0 && board.getSpot(k - 1, j) == 0) { 
	                    board.setBoard(k - 1, j, board.getSpot(k, j));
	                    board.setBoard(k, j, 0);
	                    k--; 
	                }
				}
			}
		}
	}
	
	public void moveDown() {
		// start 3rd row
		for (int i = 2; i >= 0; i--) {
			// all columns
			for (int j = 0; j < 4; j++) {
				// make sure spot below is empty
				if (board.getSpot(i, j) != 0 && board.getSpot(i + 1, j) == 0) {
	                int k = i;
	                // move up as long as empty
	                while (k < 3 && board.getSpot(k + 1, j) == 0) { 
	                    board.setBoard(k + 1, j, board.getSpot(k, j));
	                    board.setBoard(k, j, 0);
	                    k++; 
	                }
				}
			}
		}
	}
	
	public void moveRight() {
		// start 3rd column
		for (int i = 2; i >= 0; i--) {
			// all rows
			for (int j = 0; j < 4; j++) {
				// make sure spot to the right is empty
				if (board.getSpot(j, i) != 0 && board.getSpot(j, i + 1) == 0) {
	                int k = i;
	                // move up as long as empty
	                while (k < 3 && board.getSpot(j, k + 1) == 0) { 
	                    board.setBoard(j, k + 1, board.getSpot(j, k));
	                    board.setBoard(j, k, 0);
	                    k++; 
	                }
				}
			}
		}
	}
	
	public void moveLeft() {
		// start from second column
		for (int i = 1; i < 4; i++) {
			// all rows
			for (int j = 0; j < 4; j++) {
				// make sure spot to left is empty
				if (board.getSpot(j, i) != 0 && board.getSpot(j, i - 1) == 0) {
	                int k = i;
	                // move left as long as empty
	                while (k > 0 && board.getSpot(j, k - 1) == 0) { 
	                    board.setBoard(j, k - 1, board.getSpot(j, k));
	                    board.setBoard(j, k, 0);
	                    k--; 
	                }
				}
			}
		}
	}
	
	// merge
	public void mergeUp() {
		// start from 2nd row
		for (int i = 1; i < 4; i++) {
			// all columns
			for (int j = 0; j < 4; j++) {
				if (board.getSpot(i, j) == board.getSpot(i - 1, j)) {
					board.setBoard(i - 1, j, 2 * board.getSpot(i, j));
					board.setBoard(i, j, 0);
				}
			}
		}
	}
	
	public void mergeDown() {
		// start from 3rd row
		for (int i = 2; i >= 0; i--) {
			// all columns
			for (int j = 0; j < 4; j++) {
				if (board.getSpot(i, j) == board.getSpot(i + 1, j)) {
					board.setBoard(i + 1, j, 2 * board.getSpot(i, j));
					board.setBoard(i, j, 0);
				}
			}
		}
	}
	
	public void mergeRight() {
		// start from 3rd column
		for (int i = 2; i >= 0; i--) {
			// all rows
			for (int j = 0; j < 4; j++) {
				if (board.getSpot(j, i) == board.getSpot(j, i + 1)) {
					board.setBoard(j, i + 1, 2 * board.getSpot(j, i));
					board.setBoard(j, i, 0);
				}
			}
		}
	}
	
	public void mergeLeft() {
		// start from 2nd row
		for (int i = 1; i < 4; i++) {
			// all columns
			for (int j = 0; j < 4; j++) {
				if (board.getSpot(j, i) == board.getSpot(j, i - 1)) {
					board.setBoard(j, i - 1, 2 * board.getSpot(j, i));
					board.setBoard(j, i, 0);
				}
			}
		}
	}
	
	// one turn
	public void turnUp() {
		moveUp();
		mergeUp();
		moveUp();
		addSpot();
		System.out.println(board.printBoard());
	}
	
	public void turnDown() {
		moveDown();
		mergeDown();
		moveDown();
		addSpot();
		System.out.println(board.printBoard());
	}
	
	public void turnLeft() {
		moveLeft();
		mergeLeft();
		moveLeft();
		addSpot();
		System.out.println(board.printBoard());
	}
	
	public void turnRight() {
		moveRight();
		mergeRight();
		moveRight();
		addSpot();
		System.out.println(board.printBoard());
	}
	
	// getters
	public boolean getPlay() {
		return play;
	}
}
