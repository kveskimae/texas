package club.texasholdem.card;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;

import org.junit.Test;

import club.texasholdem.texas.Board;
import club.texasholdem.texas.evaluation.GameMarshalException;

public class CardTest extends TestCase {

	@Test
	public void testRankIsReturned() {
		assertEquals(Card.NINE_OF_HEARTS.getRank(), Rank.NINE);
	}

	@Test
	public void testSuitIsReturned() {
		assertEquals(Card.FIVE_OF_CLUBS.getSuit(), Suit.CLUBS);
	}

	@Test
	public void testTotalOf52Cards() {
		assertEquals(Card.values().length, 52);
	}

	@Test
	public void testId() {
		assertEquals(Card.NINE_OF_HEARTS.getId(), "9h");
	}

	@Test
	public void testUnmarshalNull() {
		try {
			Card.unmarshal(null);
			fail("Must throw excpetion");
		} catch (GameMarshalException gme) {
			assertEquals(gme.getMessage(), "Expecting non-null marshaled card as parameter");
		}
	}

	@Test
	public void testUnmarshalWrongLength1() {
		try {
			Card.unmarshal("9");
			fail("Must throw excpetion");
		} catch (GameMarshalException gme) {
			assertEquals(gme.getMessage(), "Expecting marshaled card to consist of two characters: <9>");
		}
	}

	@Test
	public void testUnmarshalWrongLength3() {
		try {
			Card.unmarshal("9hh");
			fail("Must throw excpetion");
		} catch (GameMarshalException gme) {
			assertEquals(gme.getMessage(), "Expecting marshaled card to consist of two characters: <9hh>");
		}
	}

	@Test
	public void testUnmarshal() {
		assertEquals(Card.NINE_OF_HEARTS, Card.unmarshal("9h"));
	}

}
