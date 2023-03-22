package ticTactoe;

import java.util.Scanner; 

public class Model 
{
	
	
	private char[][] arr = new char[3][3];
	private int numOfTurns = 1;
	private int numOfPlays = 0;
	

	public Model()
	{
		this.arr = arr;
		this.numOfTurns =  numOfTurns;
		this.numOfPlays = numOfPlays;
	}
	public void startGame() 
	{
		if(this.numOfPlays == 0)
		{
			int i,j;
			for (i = 0; i < 3; ++i) 
			{
				for (j = 0; j < 3; ++j) 
				{	
					this.arr[i][j] = ' ';
				}
			}
		}	
		else
		{
			event();
		}
		
		
	}

	public String endGame() 
	{
		//function checks if 'X' player or 'O' player win, or its a draw
		String msg;
		
		if(this.numOfTurns == 9)
		{
			
			msg = "draw, game over";
			this.numOfTurns = 0;
			return msg;
		}
		if ((this.arr[0][0] == this.arr[0][1] && this.arr[0][0] == this.arr[0][2]) && this.arr[0][0] != ' ') 
		{
			
			msg = "the winner is player:" + this.arr[0][0];
			
			return msg ;
			
		}
		if ((this.arr[1][0] == this.arr[1][1] && this.arr[1][0] == this.arr[1][2]) && this.arr[1][0] != ' ') 
		{
	
			msg = "the winner is player:" + this.arr[1][0];
			
			return msg ;
		}
		if ((this.arr[2][0] == this.arr[2][1] && this.arr[2][0] == this.arr[2][2]) && this.arr[2][0] != ' ') 
		{
			
			msg = "the winner is player:" + this.arr[2][0];
			
			return msg ;
		}
		if ((this.arr[0][0] == this.arr[1][1] && this.arr[0][0] == this.arr[2][2]) && this.arr[0][0] != ' ') 
		{
			
			msg = "the winner is player:" + this.arr[0][0];
			
			return msg ;
		}
		if ((this.arr[2][0] == this.arr[1][1] && this.arr[0][0] == this.arr[0][2]) && this.arr[2][0] != ' ') 
		{
			
			msg = "the winner is player:" + this.arr[2][0];
		
			return msg ;
		}
		if ((this.arr[0][0] == this.arr[1][0] && this.arr[0][0] == this.arr[2][0]) && this.arr[0][0] != ' ') 
		{
			
			msg = "the winner is player:" + this.arr[0][0];
			
			return msg ;
		}
		if ((this.arr[0][1] == this.arr[1][1] && this.arr[0][1] == this.arr[2][1]) && this.arr[0][1] != ' ') 
		{
			
			msg = "the winner is player:" + this.arr[0][1];
			
			return msg ;
		}
		if ((this.arr[0][2] == this.arr[1][2] && this.arr[0][2] == this.arr[2][2]) && this.arr[0][2] != ' ') 
		{
			
			msg = "the winner is player:" + this.arr[0][2];
			
			return msg ;
		}
		
		msg = "next player";
		return msg;
	

	}

	public int[] event() 
	{
		int a[] = new int[3];
		boolean ifProper = false;
		
		if (this.numOfTurns % 2 == 1) 
		{
			System.out.println("enter row number");
			Scanner s = new Scanner(System.in);
			int row = s.nextInt();
		
			System.out.println("enter column number");
			Scanner s1 = new Scanner(System.in);
			int column = s1.nextInt();
			
			ifProper = this.checkMove(row, column);
			
			if (ifProper) 
			{
				this.numOfTurns++;
			}
			else
			{
				System.out.println("Invalid move, try again");
				a[0] = row;
				a[1] = column;
				a[2] = 2;
				return a;
			}
			
			this.arr[row][column] = 'X';
			a[0] = row;
			a[1] = column;
			a[2] = 0;
			return a;
		}
		else
		{
			a = findBestMove();
			this.arr[a[0]][a[1]] = 'O';
			a[2] = 1;
			this.numOfTurns++;
			return a;
		}
		
		
			
	}

	public boolean checkMove(int row, int column)
	{
		//function check if the input is valid
		if (row > 2 || column > 2) 
		{
			return false;
		}
		if(this.arr[row][column] != ' ')
		{
			return false;
		}
		
		return true;
		
	}
	
	
	public void resetArr()
	{
		int i,j;
		for (i = 0; i < 3; ++i) 
		{
			for (j = 0; j < 3; ++j) 
			{
				this.arr[i][j] = ' ';
			}

			
		}
	}
	
	public void upNumOfPlays()
	{
		this.numOfPlays++;
	}
	
	
	 public int[] findBestMove()
	 {
		 	char [][] arrBoard = this.arr;
		 	int bestScore = Integer.MIN_VALUE;
	        int[] bestMove = new int[3];

	        // Try all possible moves and choose the best one
	        for (int row = 0; row < 3; row++) {
	            for (int col = 0; col < 3; col++) {
	                if (arrBoard[row][col] == ' ') {
	                	arrBoard[row][col] = 'O';
	                    int score = minimax(arrBoard, this.numOfTurns-1, true);
	                    arrBoard[row][col] = ' ';

	                    if (score > bestScore) {
	                        bestScore = score;
	                        bestMove[0] = row;
	                        bestMove[1] = col;
	                        bestMove[2] = 1;
	                    }
	                }
	            }
	        }

	        return bestMove;
	    }
	 
	 
	 private int minimax(char[][] board, int depth, boolean isMaximizingPlayer) 
	 {
		 int score = evaluate(board);

	        // Check if the game is over or depth limit reached
	        if (score == 10 || score == -10 || depth == 10) {
	            return score;
	        }

	        if (isMaximizingPlayer) {
	            int bestScore = Integer.MIN_VALUE;

	            // Try all possible moves and choose the best one
	            for (int row = 0; row < 3; row++) {
	                for (int col = 0; col < 3; col++) {
	                    if (board[row][col] == ' ') {
	                        board[row][col] = 'X';
	                        int currentScore = minimax(board, depth + 1, false);
	                        board[row][col] = ' ';

	                        bestScore = Math.max(bestScore, currentScore);
	                    }
	                }
	            }

	            return bestScore;
	        } else {
	            int bestScore = Integer.MAX_VALUE;

	            // Try all possible moves and choose the best one
	            for (int row = 0; row < 3; row++) {
	                for (int col = 0; col < 3; col++) {
	                    if (board[row][col] == ' ') {
	                        board[row][col] = 'O';
	                        int currentScore = minimax(board, depth + 1, true);
	                        board[row][col] = ' ';

	                        bestScore = Math.min(bestScore, currentScore);
	                    }
	                }
	            }

	            return bestScore;
	        }
	    }
	 
	 private int evaluate(char[][] board) 
	 {
		 
		// Check rows
	        for (int row = 0; row < 3; row++) {
	            if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
	                if (board[row][0] == 'O') {
	                    return 10;
	                } else if (board[row][0] == 'X') {
	                    return -10;
	                }
	            }
	        }

	        // Check columns
	        for (int col = 0; col < 3; col++) {
	            if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
	                if (board[0][col] == 'O') {
	                    return 10;
	                } else if (board[0][col] == 'X') {
	                    return -10;
	                }
	            }
	        }
	     // Check diagonals
	        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
	            if (board[0][0] == 'O') {
	                return 10;
	            } else if (board[0][0] == 'X') {
	                return -10;
	            }
	        }

	        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
	            if (board[0][2] == 'O') {
	                return 10;
	            } else if (board[0][2] == 'X') {
	                return -10;
	            }
	        }

	        // No winner yet
	        return 0;
	    }
}

