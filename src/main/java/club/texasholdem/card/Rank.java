package club.texasholdem.card;

import club.texasholdem.texas.evaluation.GameMarshalException;

public enum Rank {

	ACE('A'),

	TWO('2'),

	THREE('3'),

	FOUR('4'),

	FIVE('5'),

	SIX('6'),

	SEVEN('7'),

	EIGHT('8'),

	NINE('9'),

	TEN('T'),

	JACK('J'),

	QUEEN('Q'),

	KING('K');

	private final char id;

	private Rank(final char id) {
		this.id = id;
	}

	public char getId() {
		return id;
	}

	public static Rank unmarshal(final char marshaledRank) {
		for (Rank rank : Rank.values()) {
			if (rank.getId() == marshaledRank) {
				return rank;
			}
		}
		throw new GameMarshalException("Unknown marshaled rank value: '" + marshaledRank + "'");
	}

}
