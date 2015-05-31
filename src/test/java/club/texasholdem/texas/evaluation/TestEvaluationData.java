package club.texasholdem.texas.evaluation;

import java.util.Iterator;

import junit.framework.TestCase;

import org.junit.Test;

import club.texasholdem.card.Card;
import club.texasholdem.card.Rank;
import club.texasholdem.texas.Board;
import club.texasholdem.texas.Hand;

public class TestEvaluationData extends TestCase {

	private final Card card1 = Card.SIX_OF_DIAMONDS, card2 = Card.TWO_OF_HEARTS;
	private final Hand hand = new Hand(card1, card2);

	@Test
	public void testFlopCardsAreOrdered() {
		Board board = Board.unmarshal("Td,2c,Ah");
		HandData data = new HandData(hand, board);
		Iterator<Card> cards = data.getOrderedCards().iterator();
		assertEquals(Card.ACE_OF_HEARTS, cards.next());
		assertEquals(Rank.TWO, cards.next().getRank());
		assertEquals(Rank.TWO, cards.next().getRank());
		assertEquals(Card.SIX_OF_DIAMONDS, cards.next());
		assertEquals(Card.TEN_OF_DIAMONDS, cards.next());
	}

	@Test
	public void testCardsAreOrderedWithTurn() {
		Card card1 = Card.SIX_OF_DIAMONDS;
		Card card2 = Card.TWO_OF_HEARTS;
		Hand hand = new Hand(card1, card2);
		Board board = Board.unmarshal("Td,Ks,2c,Ah");
		HandData data = new HandData(hand, board);
		Iterator<Card> cards = data.getOrderedCards().iterator();
		assertEquals(Card.ACE_OF_HEARTS, cards.next());
		assertEquals(Rank.TWO, cards.next().getRank());
		assertEquals(Rank.TWO, cards.next().getRank());
		assertEquals(Card.SIX_OF_DIAMONDS, cards.next());
		assertEquals(Card.TEN_OF_DIAMONDS, cards.next());
		assertEquals(Card.KING_OF_SPADES, cards.next());
	}

	@Test
	public void testCardsAreOrderedWithRiver() {
		Card card1 = Card.SIX_OF_DIAMONDS;
		Card card2 = Card.TWO_OF_HEARTS;
		Hand hand = new Hand(card1, card2);
		Board board = Board.unmarshal("8c,Td,Ks,2c,Ah");
		HandData data = new HandData(hand, board);
		Iterator<Card> cards = data.getOrderedCards().iterator();
		assertEquals(Card.ACE_OF_HEARTS, cards.next());
		assertEquals(Rank.TWO, cards.next().getRank());
		assertEquals(Rank.TWO, cards.next().getRank());
		assertEquals(Card.SIX_OF_DIAMONDS, cards.next());
		assertEquals(Card.EIGHT_OF_CLUBS, cards.next());
		assertEquals(Card.TEN_OF_DIAMONDS, cards.next());
		assertEquals(Card.KING_OF_SPADES, cards.next());
	}

}
