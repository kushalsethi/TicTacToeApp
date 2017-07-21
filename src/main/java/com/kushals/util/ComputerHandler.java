package com.kushals.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Handle for the computer's turn
 * 
 * @author kushals
 *
 */
public class ComputerHandler {
	private Board board;
	private String placeToOccupy = null;

	/**
	 * Returns the place with higher probability of winning the game. Assuming
	 * this is only the case when the opponent is user and current user is
	 * computer. Step 1: Look whether the next move can win the game for the
	 * computer. [DONE] Step 2: Look whether opponent's next move can win the
	 * game for himself. [DONE] Step 3: Look for the place that can make
	 * computer to win the game in next two moves. [TODO] Step 4: Look for the
	 * place that can make opponent to win the game in next two moves. [TODO]
	 * Step 5: Look for the random place to pick none of the above gives the
	 * best place. [DONE]
	 * 
	 * @param board
	 * @return
	 */
	public String getPlaceForComputer(Board board) {
		// TODO: Consider making both user as the computer
		this.board = board;
		List<String> remainingPlaces = new ArrayList<String>();
		for (String[] array : board.getBoard()) {
			remainingPlaces.addAll(Arrays.asList(array));
		}
		remainingPlaces.removeAll(Arrays.asList("X", "O"));
		String mostWinningPlace = null;
		String placeToWinNext = null;
		if ((mostWinningPlace = findMostWinningPlace(remainingPlaces)) != null) {
			return mostWinningPlace;
		} else if (isOpponentWinning() && null != placeToOccupy) {
			return placeToOccupy;
		} else if ((placeToWinNext = bestMoveForComputer(remainingPlaces)) != null) {
			return placeToWinNext;
		} else {
			return randomPlace(remainingPlaces);
		}
	}

	/**
	 * Returns most suitable place that has more chances of Computer's win
	 * 
	 * @param remainingPlaces
	 * @return
	 */
	private String findMostWinningPlace(List<String> remainingPlaces) {
		String winningPlace = null;
		if (null != board.getPlayerO() && !board.getPlayerO().isEmpty()) {
			for (PatternsEnum paEnum : PatternsEnum.values()) {
				List<String> tempList = new ArrayList<>(
						paEnum.getPatternArray());
				if (tempList.removeAll(board.getPlayerO())
						&& tempList.size() == 1) {
					if (remainingPlaces.contains(tempList.get(0))) {
						winningPlace = tempList.get(0);
						break;
					}
				}
			}
		}
		return winningPlace;
	}

	/**
	 * Checks if opponent winning or not If opponent is about win, picks that
	 * winning place
	 * 
	 * @return
	 */
	private boolean isOpponentWinning() {
		boolean isWinning = false;
		if (null != board.getPlayerX() && !board.getPlayerX().isEmpty()) {
			this.placeToOccupy = null;
			for (PatternsEnum paEnum : PatternsEnum.values()) {
				List<String> tempList = new ArrayList<>(
						paEnum.getPatternArray());
				if (tempList.removeAll(board.getPlayerX())
						&& tempList.size() == 1) {
					this.placeToOccupy = tempList.get(0);
					if (!board.getPlayerO().contains(placeToOccupy)) {
						isWinning = true;
						break;
					}
				}
			}
		}
		return isWinning;
	}

	/**
	 * Returns the place for the current move which gives very next move as a
	 * winning move for the computer
	 * 
	 * @return
	 */
	private String bestMoveForComputer(List<String> remainingPlaces) {
		if (null != board.getPlayerO() && !board.getPlayerO().isEmpty()) {
			for (PatternsEnum paEnum : PatternsEnum.values()) {
				List<String> tempList = new ArrayList<>(
						paEnum.getPatternArray());
				if (tempList.removeAll(board.getPlayerO())
						&& tempList.size() == 2) {
					if (remainingPlaces.containsAll(tempList)) {
						System.out.println("Inside inner if");
						return tempList.get(0);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the random place for the computer to pick. If this is the first
	 * turn for computer, then choose '5' (middle of the board) as the place for
	 * the computer [Random logic, need to improve]
	 * 
	 * @param remainingPlaces
	 * @return
	 */
	private String randomPlace(List<String> remainingPlaces) {
		if (board.getPlayerO() == null && remainingPlaces.contains("5")) {
			return "5";
		}
		if (board.getPlayerX() != null && board.getPlayerX().size() == 1
				&& board.getPlayerX().get(0).equals("5")) {
			return "3";
		}
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(remainingPlaces.size());
		return remainingPlaces.get(index);
	}

}
