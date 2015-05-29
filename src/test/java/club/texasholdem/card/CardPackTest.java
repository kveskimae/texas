package club.texasholdem.card;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import club.texasholdem.texas.evaluation.GameLogicException;

public class CardPackTest extends TestCase {

	private CardPack pack;
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		List<Card> cards = new ArrayList<Card>();
		cards.add(Card.EIGHT_OF_CLUBS);
		cards.add(Card.JACK_OF_DIAMONDS);
		cards.add(Card.THREE_OF_CLUBS);
		pack = new CardPack(cards);
	}

	@Test
	public void testIsMoreCardsWhenIsMore() {
		assertTrue(pack.isMoreCards());
	}

	@Test
	public void testNoMoreCardsWhenEmpty() {
		pack.dealOne();
		pack.dealOne();
		pack.dealOne();
		assertFalse(pack.isMoreCards());
	}

	@Test
	public void testDealThrowsWhenEmpty() {
		pack.dealOne();
		pack.dealOne();
		pack.dealOne();
		try {
			pack.dealOne();
			fail("Must throw excpetion");
		} catch (GameLogicException ce) {
			assertEquals("Trying to remove a card from empty pack", ce.getMessage());
		}
	}

	@Test
	public void testToString() {
		assertEquals(pack.toString(), "CardPack[8c, Jd, 3c]");
	}
	
}
