package club.texasholdem.texas.evaluation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import club.texasholdem.card.Card;
import club.texasholdem.card.Rank;

class StraightEvaluatorData {
	
	private Integer lastRank = null;
	private int inRowCounter = 1;
	private boolean straight = false;
	private boolean broadWay;
	private TreeSet<Card> orderedCards;
	
	StraightEvaluatorData(final HandData data) {
		this(data.getOrderedCards());
	}

	public StraightEvaluatorData(final TreeSet<Card> orderedCards) {
		this.orderedCards = orderedCards;
		checkStraight();
	}

	private void checkStraight() {
		Iterator<Card> orderedIterator = orderedCards.descendingIterator();
		if (isBroadwayStraight()) {
			broadWay = true;
			straight = true;
		} else {
			while (orderedIterator.hasNext() && !straight) {
				Card card = orderedIterator.next();
				straight = completesStraight(card);
			}
		}
	}

	private boolean isBroadwayStraight() {
		List<Rank> ranks = new ArrayList<Rank>();
		for (Card card : orderedCards) {
			ranks.add(card.getRank());
		}
		if (ranks.contains(Rank.ACE) && ranks.contains(Rank.KING) && ranks.contains(Rank.QUEEN) && ranks.contains(Rank.JACK) && ranks.contains(Rank.TEN)) {
			return true;
		}
		return false;
	}

	boolean completesStraight(final Card card) {
		boolean ret = false;
		if (isLastRankSet()) {
			ret = isStraightComplete(card);
		}
		setLastRank(card);
		return ret;
	}
	
	private boolean isStraightComplete(final Card card) {
		if (isDifferentThanLast(card)) {
			return checkResult(card);
		}
		return false;
	}

	private boolean checkResult(final Card card) {
		if (isNextCardInStraight(card)) {
			inRowCounter++;
			return inRowCounter >= 5;
		}
		resetInRowCounter();
		return false;
	}

	private void resetInRowCounter() {
		inRowCounter = 1;
	}

	private boolean isNextCardInStraight(final Card card) {
		return lastRank - card.getRank().ordinal() == 1;
	}

	private boolean isDifferentThanLast(final Card card) {
		return card.getRank().ordinal() != lastRank;
	}

	private void setLastRank(final Card card) {
		lastRank = card.getRank().ordinal();
	}

	private boolean isLastRankSet() {
		return lastRank != null;
	}
	
	boolean isStraight() {
		return straight;
	}
	
	public boolean isBroadWay() {
		return broadWay;
	}

}
