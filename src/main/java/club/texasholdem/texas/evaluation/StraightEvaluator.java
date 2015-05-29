package club.texasholdem.texas.evaluation;

import club.texasholdem.card.Rank;

public class StraightEvaluator {

	private EvaluationData data;

	private Boolean threeOfAKind = false;
	
	private Rank highestStraightCard;

	public StraightEvaluator(final EvaluationData data) {
		this.data = data;
		checkStraight();
	}
	
	public EvaluationData getData() {
		return data;
	}

	private void checkStraight() {
		getData().getOrderedCards();
	}

}
