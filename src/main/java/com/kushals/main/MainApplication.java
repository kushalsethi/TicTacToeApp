package com.kushals.main;

import com.kushals.util.Processor;

public class MainApplication {

	public static void main(String[] args) {
		Processor processor = new Processor();
		System.out.println("**************************************************"
				+ "\nApplication Name: TicTacToe Game" + "\nVersion: 0.1"
				+ "\nAuthor: Kushal Sethi" + "\nAll rights reserved."
				+ "\n**************************************************");
		System.out
				.println("Rules for the game:"
						+ "\n**************************************************"
						+ "\nFor Player X- \'X\' will be the sign."
						+ "\nFor Player O- \'O\' will be the sign."
						+ "\nPlease enter the position for the board between 1 to 9 only."
						+ "\n**************************************************");
		processor.newGame();
	}
}
