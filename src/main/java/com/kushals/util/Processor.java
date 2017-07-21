package com.kushals.util;

import java.util.Scanner;
/**
 * Processor class to start the new game and 
 * to process the turn for the player
 * @author kushals
 *
 */
public class Processor {
	private Board boardObj;
	private ComputerHandler compHandler;
	private static int counter = 9;
	private Scanner sc;
	private String currentPlayer;
	boolean isComputerPlaying = false;
	private String playingOption;
	private boolean playerWin = false;
	boolean flag = true;

	public Processor() {
		boardObj = new Board();
	}

	public Board getBoard() {
		return boardObj;
	}

	public void setBoard(Board board) {
		this.boardObj = board;
	}

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(String currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/***
	 * Starts a new game with basic configuration 
	 */
	public void newGame() {
		sc = new Scanner(System.in);
		System.out.println("Do you want to play against Computer?(Y/N)");
		playingOption = sc.next();
		if (playingOption.equalsIgnoreCase("y")) {
			compHandler = new ComputerHandler();
			isComputerPlaying = true;
			System.out
					.println("Good! You[as \'X\'] will be the first to pick the place. All the best!");
		} else {
			System.out
					.println("Alright, let's see who is better among both of you guys");
		}
		while (counter != 0 && !playerWin) {
			processNextMove();
		}
		showResults();
		sc.close();
	}

	
	/**
	 *  Processes the next move for the player
	 *  'X' sign for the first player 
	 *  'O' sign for the second player [Computer, if playing against computer] 
	 */
	private void processNextMove() {
		String place = null;
		if (isComputerPlaying && !flag) {
			currentPlayer = flag ? "X" : "O";
			System.out.println("Current Player: " + currentPlayer
					+ " [Computer]");
			place = compHandler.getPlaceForComputer(boardObj);
		} else {
			currentPlayer = flag ? "X" : "O";
			System.out.println("Current Player: " + currentPlayer);
			System.out
					.println("Enter the number between 1 to 9 for the place you want to choose: ");
			place = sc.next();
		}
		System.out.println("Place choosen:" + place);
		int placeNumber = Integer.parseInt(place);
		if (placeNumber >= 1 && placeNumber <= 9) {
			if (processRequest(place, currentPlayer)) {
				displayBoard();
				flag = flag ? false : true;
				counter--;
				if (boardObj.checkBoard(currentPlayer)) {
					playerWin = true;
				}
			} else {
				System.out
						.println("Oops! Wrong place choosen, already occupied."
								+ "\nPlease enter correct position for the place you want to choose.");
			}
		} else {
			System.out
					.println("Oops! Looks like you have entered wrong number for the place."
							+ "\nPlease enter correct number for the place you want to choose (between 1 to 9 only ).");
		}
	}

	/**
	 * Shows the result of the game on console 
	 */
	private void showResults() {
		if (playerWin) {
			System.out
					.println("Player \'" + currentPlayer
							+ "\' won the game, Congratulations!!! "
							+ "\nGame over..!");
		} else {
			System.out.println("Game draw!!!");
		}
		setUpEnvironemnt();
	}

	/**
	 * Sets up the environment for starting new game
	 * Resets board, player turn, counter for turns, flag for the win state
	 */
	private void setUpEnvironemnt() {
		System.out.println("Do you want to play again?(Y/N)");
		String decision = sc.next();
		if (decision.equalsIgnoreCase("y")) {
			this.boardObj = new Board();
			flag = true;
			playerWin=false;
			counter = 9;
			newGame();
		} else {
			System.out.println("See you again, Bye!");
		}
	}

	/**
	 * Displays the board status on the console
	 */
	private void displayBoard() {
		System.out.println("Board Updated..!");
		System.out.println("Board status: ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(boardObj.getBoard()[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	/**
	 * Processes the turn for the player
	 * Requires place to be occupied and name of the current player
	 * @param place
	 * @param currentPlayer
	 * @return
	 */
	public boolean processRequest(String place, String currentPlayer) {
		if (boardObj.checkForPlace(place)) {
			return boardObj.updateBoard(place, currentPlayer);
		}
		return false;
	}
}
