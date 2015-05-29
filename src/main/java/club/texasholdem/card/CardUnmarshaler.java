package club.texasholdem.card;

import java.util.HashMap;
import java.util.Map;

import club.texasholdem.texas.evaluation.GameMarshalException;

class CardUnmarshaler {
	
	private static final Map<Suit, Map<Rank, Card>> accessMap;
	
	static {
		accessMap = new HashMap<Suit, Map<Rank,Card>>();
		for (Card card : Card.values()) {
			Suit cardSuit = card.getSuit();
			Rank cardRank = card.getRank();
			Map<Rank, Card> suitCards = accessMap.get(cardSuit);
			if (suitCards == null) {
				suitCards = new HashMap<Rank, Card>();
				accessMap.put(cardSuit, suitCards);	
			}
			suitCards.put(cardRank, card);
		}
	}

	static Card unmarshal(final String marshaledCard) {
		if (marshaledCard == null) {
			throw new GameMarshalException("Expecting non-null marshaled card as parameter");
		}
		if (marshaledCard.length() != 2) {
			throw new GameMarshalException("Expecting marshaled card to consist of two characters: <" + marshaledCard + ">");
		}
		char marshaledRank = marshaledCard.charAt(0);
		char marshaledSuit = marshaledCard.charAt(1);
		Rank rank = Rank.unmarshal(marshaledRank);
		Suit suit = Suit.unmarshal(marshaledSuit);
		Card card = getByRankAndSuit(rank, suit);
		return card;
	}

	private static Card getByRankAndSuit(final Rank rank, final Suit suit) {
		return accessMap.get(suit).get(rank);
	}

}
