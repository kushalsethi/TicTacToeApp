package com.kushals.util;

import java.util.List;
/**
 * Enum class for patterns
 * Helps in iterating through patterns while predicting best place for the player
 * @author kushals
 *
 */
public enum PatternsEnum {
	PATTERN_ONE(Patterns.PATTERN_ONE), PATTERN_TWO(Patterns.PATTERN_TWO), PATTERN_THREE(
			Patterns.PATTERN_THREE), PATTERN_FOUR(Patterns.PATTERN_FOUR), PATTERN_FIVE(
			Patterns.PATTERN_FIVE), PATTERN_SIX(Patterns.PATTERN_SIX), PATTERN_SEVEN(
			Patterns.PATTERN_SEVEN), PATTERN_EIGHT(Patterns.PATTERN_EIGHT);

	private final List<String> patternArray;

	PatternsEnum(List<String> patternArray) {
		this.patternArray = patternArray;
	}

	public List<String> getPatternArray() {
		return this.patternArray;
	}

}
