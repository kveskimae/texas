package club.texasholdem.texas;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import club.texasholdem.card.Card;
import club.texasholdem.texas.evaluation.GameMarshalException;

public class Board {

	private Card flop1, flop2, flop3, turn, river;

	public Board() {
	}

	public static Board unmarshal(final String marshaled) {
		if (marshaled == null) {
			throw new GameMarshalException("Marshaled representation was null");
		}
		if (StringUtils.isBlank(marshaled)) {
			return new Board();
		}
		String[] marshaledCards = marshaled.split(",");
		if (marshaledCards.length < 3) {
			throw new GameMarshalException("Marshaled board must be empty or contain at least 3 flop cards: '" + marshaled + "'");
		}
		if (marshaledCards.length > 5) {
			throw new GameMarshalException("Marshaled board cannot contain more than 5 cards: '" + marshaled + "'");
		}
		List<Card> cards = new ArrayList<Card>();
		for (String marshaledCard : marshaledCards) {
			try {
				Card card = Card.unmarshal(marshaledCard);
				cards.add(card);
			} catch (GameMarshalException me) {
				throw new GameMarshalException("A card had malformed presentation: '" + marshaled + "'", me);
			}
		}
		Board board = new Board();
		board.flop1 = cards.get(0);
		board.flop2 = cards.get(1);
		board.flop3 = cards.get(2);
		if (cards.size() > 3) {
			board.turn = cards.get(3);
		}
		if (cards.size() > 4) {
			board.river = cards.get(4);
		}
		return board;
	}

	public Card getFlop1() {
		return flop1;
	}

	public void setFlop1(Card flop1) {
		this.flop1 = flop1;
	}

	public Card getFlop2() {
		return flop2;
	}

	public void setFlop2(Card flop2) {
		this.flop2 = flop2;
	}

	public Card getFlop3() {
		return flop3;
	}

	public void setFlop3(Card flop3) {
		this.flop3 = flop3;
	}

	public Card getTurn() {
		return turn;
	}

	public void setTurn(Card turn) {
		this.turn = turn;
	}

	public Card getRiver() {
		return river;
	}

	public void setRiver(Card river) {
		this.river = river;
	}

}
