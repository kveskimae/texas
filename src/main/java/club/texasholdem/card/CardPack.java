package club.texasholdem.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import club.texasholdem.texas.evaluation.GameLogicException;

public class CardPack {
	
	private final List<Card> cards;
	
	public CardPack(final List<Card> cards) {
		this.cards = cards;
	}
	
	public Card dealOne() {
		checkNotEmpty();
		return cards.remove(cards.size() - 1);
	}
	
	public boolean isMoreCards() {
		return !cards.isEmpty();
	}

	private void checkNotEmpty() {
		if (cards.isEmpty()) {
			throw new GameLogicException("Trying to remove a card from empty pack");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CardPack[");
		String cardsPart = getCardsString();
		sb.append(cardsPart);
		sb.append("]");
		return sb.toString();
	}

	private String getCardsString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Card> it = cards.iterator();
		while (it.hasNext()) {
			Card card = it.next();
			sb.append(card.getId());
			addCardsSeparator(it, sb);
		}
		return sb.toString();
	}

	// Modifies parameter string builder
	private void addCardsSeparator(final Iterator<Card> it, final StringBuilder sb) {
		if (it.hasNext()) {
			sb.append(", ");
		}
	}

}
