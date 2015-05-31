package club.texasholdem.texas.evaluation;

import java.util.TreeSet;

import club.texasholdem.card.Card;

public class StraightFlushEvaluator {

	private final HandData data;

	private boolean straightFlush = false;

	private boolean royalFlush = false;

	public StraightFlushEvaluator(final HandData data) {
		this.data = data;
		for (TreeSet<Card> oneFlushCards : data.getFlushCards().values()) {
			checkFlushForStraightFlush(oneFlushCards);
		}
	}

	private void checkFlushForStraightFlush(final TreeSet<Card> oneFlushCards) {
		StraightEvaluatorData straightData = new StraightEvaluatorData(oneFlushCards);
		if (straightData.isStraight()) {
			straightFlush = true;
			if (straightData.isBroadWay()) {
				royalFlush = true;
			}
		}
	}
	
	public boolean isStraightFlush() {
		return straightFlush;
	}
	
	public boolean isRoyalFlush() {
		return royalFlush;
	}

}
