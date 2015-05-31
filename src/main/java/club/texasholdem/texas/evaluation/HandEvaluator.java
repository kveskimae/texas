package club.texasholdem.texas.evaluation;

import java.util.Map;

import club.texasholdem.card.Rank;
import club.texasholdem.texas.Board;
import club.texasholdem.texas.Hand;
import club.texasholdem.texas.HandCombination;

public class HandEvaluator {

	private final HandData data;
	
	private SameRankedEvaluator rankEvaluator;
	
	private StraightEvaluator straightEvaluator;
	
	private FlushEvaluator flushEvaluator;
	
	private StraightFlushEvaluator straightFlushEvaluator;

	private HandCombination bestCombination;

	public HandEvaluator(final Hand hand, final Board board) {
		this.data = new HandData(hand, board);
		this.rankEvaluator = new SameRankedEvaluator(this.data);
		this.straightEvaluator = new StraightEvaluator(this.data);
		this.flushEvaluator = new FlushEvaluator(this.data);
		this.straightFlushEvaluator = new StraightFlushEvaluator(this.data);
	}

	public HandCombination getBestCombination() {
		if (this.bestCombination == null) {
			this.bestCombination = findBestCombination();
		}
		return bestCombination;
	}

	private HandCombination findBestCombination() {
		if (this.straightFlushEvaluator.isRoyalFlush()) {
			return HandCombination.ROYAL_FLUSH;
		}
		if (this.straightFlushEvaluator.isStraightFlush()) {
			return HandCombination.STRAIGHT_FLUSH;
		}
		if (this.rankEvaluator.isFourOfAKind()) {
			return HandCombination.FOUR_OF_A_KIND;
		}
		if (this.rankEvaluator.isFullHouse()) {
			return HandCombination.FULL_HOUSE;
		}
		if (this.flushEvaluator.isFlush()) {
			return HandCombination.FLUSH;
		}
		if (this.straightEvaluator.isStraight()) {
			return HandCombination.STRAIGHT;
		}
		if (this.rankEvaluator.isThreeOfAKind()) {
			return HandCombination.THREE_OF_A_KIND;
		}
		if (this.rankEvaluator.isTwoPairs()) {
			return HandCombination.TWO_PAIRS;
		}
		if (this.rankEvaluator.isPair()) {
			return HandCombination.PAIR;
		}
		return HandCombination.HIGH_CARD;
	}

}
