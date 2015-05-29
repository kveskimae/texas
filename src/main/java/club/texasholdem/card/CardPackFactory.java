package club.texasholdem.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardPackFactory {
	
	public CardPackFactory() {
	}
	
	public static CardPack createShuffledPack() {
		List<Card> cards = new ArrayList<Card>();
		cards.addAll(Arrays.asList(Card.values()));
		Collections.shuffle(cards);
		CardPack pack = new CardPack(cards);
		return pack;
	}

}
