//import java.util.Arrays;
import java.util.Scanner;
import java.awt.Point;
import java.util.ArrayList;
public class battleship {
int boat1row=0;
int boat1col=0;
char boat1dir=0;
int boat2row=0;
int boat2col=0;
char boat2dir=0;
int boat3row=0;
int boat3col=0;
char boat3dir=0;
int rowGuess=0;
int colGuess=0;
Scanner scan= new Scanner(System.in);
int numberofS = 0;
ArrayList<Point> guessList = new ArrayList<Point>();
//declarations

char [][] Board = { {' ','0','1','2','3','4','5','6'},
				   {'0','-','-','-','-','-','-','-',},
				   {'1','-','-','-','-','-','-','-',},
				   {'2','-','-','-','-','-','-','-',},
				   {'3','-','-','-','-','-','-','-',},
				   {'4','-','-','-','-','-','-','-',},
				   {'5','-','-','-','-','-','-','-',},
				   {'6','-','-','-','-','-','-','-',},
};
//gameboard

	public battleship() {
		fillBoard(Board);
		printBoard(Board);
		gamePlay(Board);
		//gameOver(Board);
//accesses the different methods used		
	}
	
	private void gameOver(char[][] board2) {
		numberofS = 0;
		for(int i=0; i<Board.length; i++)
		{
			for(int j=0; j<Board[i].length; j++)
			{
				if (Board[i][j] == 'S')
				{
				numberofS += 1;
				}
					
			}
		}
		if(numberofS ==0)
		{
			System.out.println("You won");
			System.out.println("Your Guesses:");
			for (Point p : guessList) {
			    System.out.println(p.x + "," + p.y);
			   
		} System.out.println("Number of guesses:" + guessList.size());
		}
		else
		{
		gamePlay(Board);
		}
	}
//used to when game is over. Prints out the number of guesses and also the coordinate guesses using the point class. (Which is really cool)
	private void gamePlay(char[][] board2) 
	{
		System.out.println("Please enter your guess for the row coordinate");
		rowGuess=scan.nextInt();
		System.out.println("Please enter your guess for the column coordinate");
		colGuess=scan.nextInt();
		Point coordinate = new Point(rowGuess,colGuess);
		guessList.add(coordinate);
		if(Board[rowGuess][colGuess]=='S')
		{
			Board[rowGuess][colGuess]='X';
			System.out.println("Hit!");
		}
		else {
			Board[rowGuess][colGuess] = 'm';
		System.out.println("Miss!");
		}
		printBoard(Board);
		gameOver(Board);
		
		
	}
	//determines what happens after the user inputs coordinates. ie. hit or miss

	private void fillBoard(char[][] board2) {
		
		System.out.println("Please enter the starting row for the first battleship with the length of 2");
		boat1row=scan.nextInt();
		System.out.println("Please enter the starting column for the first battleship with the length of 2");
		boat1col=scan.nextInt();
		System.out.println("Please enter the starting direction ('r' or 'd') for the first battleship with the length of 2");
		boat1dir = scan.next().charAt(0);
		//scan in the first ships location
		
		System.out.println("Please enter the starting row for the first battleship with the length of 3");
		boat2row=scan.nextInt();
		System.out.println("Please enter the starting column for the first battleship with the length of 3");
		boat2col=scan.nextInt();
		System.out.println("Please enter the starting direction ('r' or 'd') for the first battleship with the length of 3");
		boat2dir= scan.next().charAt(0);
		//scan in the second ships location
		
		System.out.println("Please enter the starting row for the third battleship with the length of 4");
		boat3row=scan.nextInt();
		System.out.println("Please enter the starting column for the third battleship with the length of 4");
		boat3col=scan.nextInt();
		System.out.println("Please enter the starting direction ('r' or 'd') for the third battleship with the length of 4");
		boat3dir=scan.next().charAt(0);
		
		Board[boat1row][boat1col]='S';
		Board[boat2row][boat2col]='S';
		Board[boat3row][boat3col]='S';
		if (boat1dir == 'r')
		{
		Board[boat1row][boat1col+1]='S';
		}
		else if (boat1dir == 'd')
		{ 
			Board[boat1row+1][boat1col] = 'S';
		}
		 if (boat2dir == 'r')
		{
		Board[boat2row][boat2col+1]='S';
		Board[boat2row][boat2col+2] = 'S';
		}
		else if (boat2dir == 'd')
		{ 
			Board[boat2row+1][boat2col] = 'S';
			Board[boat2row+2][boat2col] = 'S';
		}
		 if (boat3dir == 'r')
		{
		Board[boat3row][boat3col+1]='S';
		Board[boat3row][boat3col+2]='S';
		Board[boat3row][boat3col+3]='S';
		}
		else if (boat3dir == 'd')
		{ 
			Board[boat3row+1][boat3col] = 'S';
			Board[boat3row+2][boat3col] = 'S';
			Board[boat3row+3][boat3col] = 'S';
		}
	}
//fills the board and prompts the user to enter starting locations for each ship
	private void printBoard(char[][] board) {
		for(int i=0; i<board.length; i++){
			for (int j=0; j<board[i].length; j++){
				System.out.print(board[i][j]+ " ");
			}
		
		System.out.println();
		}
	}
//prints the board
}
