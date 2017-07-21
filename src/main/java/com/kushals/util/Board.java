package com.kushals.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents board for the game
 * @author kushals
 *
 */
public class Board {
	private String board[][] = { { "1", "2", "3" }, { "4", "5", "6" },
			{ "7", "8", "9" } };
	private List<String> playerX;
	private List<String> playerO;

	Board() {
		playerX = new ArrayList<>();
		playerO = new ArrayList<>();
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

	public List<String> getPlayerX() {
		return playerX;
	}

	public void setPlayerX(List<String> playerX) {
		this.playerX = playerX;
	}

	public List<String> getPlayerO() {
		return playerO;
	}

	public void setPlayerO(List<String> playerO) {
		this.playerO = playerO;
	}

	/**
	 * Checks whether the chosen place is already occupied or not
	 * @param place
	 * @return
	 */
	public boolean checkForPlace(String place) {
		if ((null != playerX && !playerX.isEmpty())
				|| (null != playerO && !playerO.isEmpty()))
			for (String cur_item : playerX) {
				if (cur_item.equalsIgnoreCase(place)) {
					return false;
				}
			}
		for (String cur_item : playerO) {
			if (cur_item.equalsIgnoreCase(place)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Updates the board with chosen place by the current player
	 * @param placeChoosen
	 * @param currentPlayer
	 * @return
	 */
	public boolean updateBoard(String placeChoosen, String currentPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].equalsIgnoreCase(placeChoosen)) {
					board[i][j] = currentPlayer;
					if (currentPlayer.equalsIgnoreCase("x")) {
						playerX.add(placeChoosen);
					} else {
						playerO.add(placeChoosen);
					}
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks for whether current player is winning or not
	 * @param currentPlayer
	 * @return
	 */
	public boolean checkBoard(String currentPlayer) {
		if (currentPlayer.equalsIgnoreCase("x")) {
			if (playerX.containsAll(Patterns.PATTERN_ONE)
					|| playerX.containsAll(Patterns.PATTERN_TWO)
					|| playerX.containsAll(Patterns.PATTERN_THREE)
					|| playerX.containsAll(Patterns.PATTERN_FOUR)
					|| playerX.containsAll(Patterns.PATTERN_FIVE)
					|| playerX.containsAll(Patterns.PATTERN_SIX)
					|| playerX.containsAll(Patterns.PATTERN_SEVEN)
					|| playerX.containsAll(Patterns.PATTERN_EIGHT)) {
				return true;
			}
		} else if (currentPlayer.equalsIgnoreCase("o")) {
			if (playerO.containsAll(Patterns.PATTERN_ONE)
					|| playerO.containsAll(Patterns.PATTERN_TWO)
					|| playerO.containsAll(Patterns.PATTERN_THREE)
					|| playerO.containsAll(Patterns.PATTERN_FOUR)
					|| playerO.containsAll(Patterns.PATTERN_FIVE)
					|| playerO.containsAll(Patterns.PATTERN_SIX)
					|| playerO.containsAll(Patterns.PATTERN_SEVEN)
					|| playerO.containsAll(Patterns.PATTERN_EIGHT)) {
				return true;
			}
		}
		return false;
	}

}
