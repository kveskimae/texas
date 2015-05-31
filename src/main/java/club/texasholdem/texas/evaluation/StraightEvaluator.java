package club.texasholdem.texas.evaluation;

import java.util.Iterator;
import java.util.TreeSet;

import club.texasholdem.card.Card;
import club.texasholdem.card.Rank;

public class StraightEvaluator {

	private StraightEvaluatorData straightData;

	public StraightEvaluator(final HandData data) {
		this.straightData = new StraightEvaluatorData(data);
	}

	public boolean isStraight() {
		return straightData.isStraight();
	}

}
