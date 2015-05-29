package club.texasholdem.texas;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import club.texasholdem.GameLogicException;
import club.texasholdem.card.Card;

public class HandTest extends TestCase {
	
	private final Card card1 = Card.FIVE_OF_CLUBS, card2 = Card.KING_OF_CLUBS;
	
	private Hand hand;
	
	@Before
	public void setUp() throws Exception {
		hand = new Hand(card1, card2);
	}

	@Test(expected=GameLogicException.class)
	public void testThrowsIfFirstCardNull() {
		try {
			new Hand(null, card2);
			fail("Must throw excpetion");
		} catch (Exception e) {
			assertThat(e, instanceOf(GameLogicException.class));
		}
	}

	@Test(expected=GameLogicException.class)
	public void testThrowsIfSecondCardNull() {
		try {
			new Hand(card1, null);
			fail("Must throw excpetion");
		} catch (Exception e) {
			assertThat(e, instanceOf(GameLogicException.class));
		}
	}

	@Test
	public void testCard1IsRight() {
		assertEquals(hand.getCard1(), Card.FIVE_OF_CLUBS);
	}

	@Test
	public void testCard2IsRight() {
		assertEquals(hand.getCard2(), Card.KING_OF_CLUBS);
	}
	
	@Test
	public void testIsSuitedWithNonSuited() {
		Hand hand = new Hand(Card.FIVE_OF_CLUBS, Card.SIX_OF_SPADES);
		assertFalse(hand.isSuited());
	}
	
	@Test
	public void testIsSuitedWithSuited() {
		Hand hand = new Hand(Card.FIVE_OF_CLUBS, Card.QUEEN_OF_CLUBS);
		assertTrue(hand.isSuited());
	}
	
	@Test
	public void testIsPairWithNonPair() {
		Hand hand = new Hand(Card.FIVE_OF_CLUBS, Card.QUEEN_OF_CLUBS);
		assertFalse(hand.isPair());
	}
	
	@Test
	public void testIsPairWithPair() {
		Hand hand = new Hand(Card.FIVE_OF_CLUBS, Card.FIVE_OF_HEARTS);
		assertTrue(hand.isPair());
	}

}
