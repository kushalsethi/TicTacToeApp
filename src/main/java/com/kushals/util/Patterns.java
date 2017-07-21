package com.kushals.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Patterns constant class
 * Contains all the eight possibilities for the winning state
 * @author kushals
 *
 */
public class Patterns {
	public static final List<String> PATTERN_ONE = new ArrayList<>(Arrays.asList("1", "2", "3"));
	public static final List<String> PATTERN_TWO = new ArrayList<>(Arrays.asList("4", "5", "6"));
	public static final List<String> PATTERN_THREE = new ArrayList<>(Arrays.asList("7", "8", "9"));
	public static final List<String> PATTERN_FOUR = new ArrayList<>(Arrays.asList("1", "4", "7"));
	public static final List<String> PATTERN_FIVE = new ArrayList<>(Arrays.asList("2", "5", "8"));
	public static final List<String> PATTERN_SIX = new ArrayList<>(Arrays.asList("3", "6", "9"));
	public static final List<String> PATTERN_SEVEN = new ArrayList<>(Arrays.asList("1", "5", "9"));
	public static final List<String> PATTERN_EIGHT = new ArrayList<>(Arrays.asList("3", "5", "7"));			
}
