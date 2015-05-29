package club.texasholdem.card;

import club.texasholdem.texas.evaluation.GameMarshalException;

public enum Suit {
	
	CLUBS('c'), 
	
	DIAMONDS('d'), 
	
	HEARTS('h'), 
	
	SPADES('s');

	private final char id;

	private Suit(final char id) {
		this.id = id;
	}
	
	public char getId() {
		return id;
	}

	public static Suit unmarshal(final char marshaledSuit) {
		for (Suit suit : Suit.values()) {
			if (suit.getId() == marshaledSuit) {
				return suit;
			}
		}
		throw new GameMarshalException("Unknown marshaled suit value: '" + marshaledSuit + "'");
	}

}
