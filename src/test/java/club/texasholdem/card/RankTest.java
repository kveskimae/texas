package club.texasholdem.card;

import junit.framework.TestCase;

import org.junit.Test;

import club.texasholdem.texas.evaluation.GameMarshalException;

public class RankTest extends TestCase {
	
	@Test
	public void testThirteenRanks() {
		assertEquals(13, Rank.values().length);
	}
	
	@Test
	public void testAceRank() {
		assertEquals(Rank.ACE.getId(), 'A');
		assertEquals(Rank.ACE, Rank.unmarshal('A'));
	}
	
	@Test
	public void testTwoRank() {
		assertEquals(Rank.TWO.getId(), '2');
		assertEquals(Rank.TWO, Rank.unmarshal('2'));
	}
	
	@Test
	public void testThreeRank() {
		assertEquals(Rank.THREE.getId(), '3');
		assertEquals(Rank.THREE, Rank.unmarshal('3'));
	}
	
	@Test
	public void testFourRank() {
		assertEquals(Rank.FOUR.getId(), '4');
		assertEquals(Rank.FOUR, Rank.unmarshal('4'));
	}
	
	@Test
	public void testFiveRank() {
		assertEquals(Rank.FIVE.getId(), '5');
		assertEquals(Rank.FIVE, Rank.unmarshal('5'));
	}
	
	@Test
	public void testSixRank() {
		assertEquals(Rank.SIX.getId(), '6');
		assertEquals(Rank.SIX, Rank.unmarshal('6'));
	}
	
	@Test
	public void testSevenRank() {
		assertEquals(Rank.SEVEN.getId(), '7');
		assertEquals(Rank.SEVEN, Rank.unmarshal('7'));
	}
	
	@Test
	public void testEightRank() {
		assertEquals(Rank.EIGHT.getId(), '8');
		assertEquals(Rank.EIGHT, Rank.unmarshal('8'));
	}
	
	@Test
	public void testNineRank() {
		assertEquals(Rank.NINE.getId(), '9');
		assertEquals(Rank.NINE, Rank.unmarshal('9'));
	}
	
	@Test
	public void testTenRank() {
		assertEquals(Rank.TEN.getId(), 'T');
		assertEquals(Rank.TEN, Rank.unmarshal('T'));
	}
	
	@Test
	public void testJackRank() {
		assertEquals(Rank.JACK.getId(), 'J');
		assertEquals(Rank.JACK, Rank.unmarshal('J'));
	}
	
	@Test
	public void testQueenRank() {
		assertEquals(Rank.QUEEN.getId(), 'Q');
		assertEquals(Rank.QUEEN, Rank.unmarshal('Q'));
	}
	
	@Test
	public void testKingRank() {
		assertEquals(Rank.KING.getId(), 'K');
		assertEquals(Rank.KING, Rank.unmarshal('K'));
	}
	
	@Test
	public void testUmarshalWithInvalid() {
		try {
			Rank.unmarshal('1');
			fail("Must throw excpetion");
		} catch (GameMarshalException me) {
			assertEquals("Unknown marshaled rank value: '1'", me.getMessage());
		}
	}
		
}
