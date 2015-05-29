package club.texasholdem.card;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import club.texasholdem.texas.evaluation.GameMarshalException;

public class SuitTest extends TestCase {
	
	private static List<Suit> suits = Arrays.asList(Suit.values());
	
	@Test
	public void testFourSuits() {
		assertEquals(4, Suit.values().length);
	}
	
	@Test
	public void testClubsSuit() {
		assertThat(suits, hasItem(Suit.CLUBS));
		assertEquals(Suit.CLUBS.getId(), 'c');
		assertEquals(Suit.unmarshal('c'), Suit.CLUBS);
	}
	
	@Test
	public void testDiamondsSuit() {
		assertThat(suits, hasItem(Suit.DIAMONDS));
		assertEquals(Suit.DIAMONDS.getId(), 'd');
		assertEquals(Suit.unmarshal('d'), Suit.DIAMONDS);
	}
	
	@Test
	public void testHeartsSuit() {
		assertThat(suits, hasItem(Suit.HEARTS));
		assertEquals(Suit.HEARTS.getId(), 'h');
		assertEquals(Suit.unmarshal('h'), Suit.HEARTS);
	}
	
	@Test
	public void testSpadesSuit() {
		assertThat(suits, hasItem(Suit.SPADES));
		assertEquals(Suit.SPADES.getId(), 's');
		assertEquals(Suit.unmarshal('s'), Suit.SPADES);
	}
	
	@Test
	public void testUmarshalWithInvalid() {
		try {
			Suit.unmarshal('1');
			fail("Must throw excpetion");
		} catch (GameMarshalException gme) {
			assertEquals("Unknown marshaled suit value: '1'", gme.getMessage());
		}
	}
	
}
