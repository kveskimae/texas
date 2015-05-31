package club.texasholdem.texas.evaluation;

import java.util.Map;

import club.texasholdem.card.Rank;

public class SameRankedEvaluator {

	private HandData data;

	private Integer numberOfPairs = 0;

	private Boolean threeOfAKind = false;

	private Boolean fourOfAKind = false;

	public SameRankedEvaluator(final HandData data) {
		this.data = data;
		for (Integer sameRankedCount : counter().values()) {
			addToCountIfPair(sameRankedCount);
			checkThreeOfAKind(sameRankedCount);
			checkFourOfAKind(sameRankedCount);
		}
	}

	private void checkFourOfAKind(final int count) {
		if (count >= 4) {
			fourOfAKind = true;
		}
	}

	private void checkThreeOfAKind(final int count) {
		if (count >= 3) {
			threeOfAKind = true;
		}
	}

	private void addToCountIfPair(final int count) {
		if (count >= 2) {
			numberOfPairs++;
		}
	}

	private Map<Rank, Integer> counter() {
		return data.getRanksCounter();
	}

	public boolean isFourOfAKind() {
		return fourOfAKind;
	}

	public boolean isFullHouse() {
		return threeOfAKind && numberOfPairs > 1;
	}

	public boolean isThreeOfAKind() {
		return threeOfAKind;
	}

	public boolean isTwoPairs() {
		if (numberOfPairs > 1) {
			return true;
		}
		return false;
	}

	public boolean isPair() {
		if (numberOfPairs > 0) {
			return true;
		}
		return false;
	}

}
