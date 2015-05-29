package club.texasholdem.texas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import club.texasholdem.card.Card;
import club.texasholdem.texas.evaluation.GameMarshalException;

class BoardUnmarshaler {

	static Board unmarshal(final String marshaled) {
		verifyMarshaled(marshaled);
		if (isEmptyBoard(marshaled)) {
			return new Board();
		}
		return unmarshalNonEmptyBoard(marshaled);
	}

	private static void verifyMarshaled(final String marshaled) {
		if (marshaled == null) {
			throw new GameMarshalException("Marshaled representation was null");
		}
		if (isEmptyBoard(marshaled)) {
			return;
		}
		String[] marshaledCards = marshaled.split(",");
		if (marshaledCards.length < 3) {
			throw new GameMarshalException("Marshaled board must be empty or contain at least 3 flop cards: '" + marshaled + "'");
		}
		if (marshaledCards.length > 5) {
			throw new GameMarshalException("Marshaled board cannot contain more than 5 cards: '" + marshaled + "'");
		}
	}

	private static boolean isEmptyBoard(String marshaled) {
		return StringUtils.isBlank(marshaled);
	}

	private static Board unmarshalNonEmptyBoard(final String marshaled) {
		List<Card> cards = umarshalCards(marshaled);
		Board board = createBoard(cards);
		return board;
	}

	private static List<Card> umarshalCards(final String marshaled) {
		List<Card> cards = new ArrayList<Card>();
		String[] marshaledCards = marshaled.split(",");
		for (String marshaledCard : marshaledCards) {
			try {
				Card card = Card.unmarshal(marshaledCard);
				cards.add(card);
			} catch (GameMarshalException me) {
				throw new GameMarshalException("A card had malformed presentation: '" + marshaled + "'", me);
			}
		}
		return cards;
	}

	private static Board createBoard(final List<Card> cards) {
		Board board = new Board();
		board.setFlop1(cards.get(0));
		board.setFlop2(cards.get(1));
		board.setFlop3(cards.get(2));
		if (cards.size() > 3) {
			board.setTurn(cards.get(3));
		}
		if (cards.size() > 4) {
			board.setRiver(cards.get(4));
		}
		return board;
	}

}
