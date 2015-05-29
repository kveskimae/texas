package club.texasholdem.texas;

import club.texasholdem.card.Card;
import club.texasholdem.texas.evaluation.GameLogicException;

public class Hand {
	
	private final Card card1, card2;
	
	public Hand(final Card card1, final Card card2) {
		if (card1 == null) {
			throw new GameLogicException("Card one was null");
		}
		if (card2 == null) {
			throw new GameLogicException("Card two was null");
		}
		this.card1 = card1;
		this.card2 = card2;
	}

	public Card getCard1() {
		return card1;
	}

	public Card getCard2() {
		return card2;
	}
	
	public boolean isSuited() {
		return getCard1().getSuit().equals(getCard2().getSuit());
	}
	
	public boolean isPair() {
		return getCard1().getRank().equals(getCard2().getRank());
	}

}
 