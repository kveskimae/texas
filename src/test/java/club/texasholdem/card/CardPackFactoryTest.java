package club.texasholdem.card;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class CardPackFactoryTest extends TestCase {

	private CardPack pack;

	@Before
	public void setUp() throws Exception {
		pack = (new CardPackFactory()).createShuffledPack();
	}

	@Test
	public void testIsMoreCardsWhenIsMore() {
		assertTrue(pack.isMoreCards());
	}

	@Test
	public void testDeal() {
		pack.dealOne();
	}

	@Test
	public void testTotalOf52Cards() {
		for (int i = 0; i < 52; i++) {
			pack.dealOne();
		}
		assertFalse(pack.isMoreCards());
	}
	
}
