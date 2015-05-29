package club.texasholdem.texas;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import club.texasholdem.card.Card;
import club.texasholdem.texas.evaluation.GameMarshalException;
import junit.framework.TestCase;

public class BoardTest extends TestCase {

	@Test
	public void testUnmarshalNull() {
		try {
			Board.unmarshal(null);
			fail("Must throw excpetion");
		} catch (GameMarshalException e) {
		}
	}

	@Test
	public void testUnmarshalEmpty() {
		Board unmarshaled = Board.unmarshal("");
		assertNull(unmarshaled.getFlop1());
		assertNull(unmarshaled.getFlop2());
		assertNull(unmarshaled.getFlop3());
		assertNull(unmarshaled.getTurn());
		assertNull(unmarshaled.getRiver());
	}

	@Test
	public void testUnmarshalPartialFlop() {
		try {
			Board.unmarshal("Kc,8s");
			fail("Must throw excpetion");
		} catch (GameMarshalException e) {
		}
	}

	@Test
	public void testUnmarshal6Cards() {
		try {
			Board.unmarshal("Kc,8s,Td,4s,Kh,6c");
			fail("Must throw excpetion");
		} catch (GameMarshalException e) {
		}
	}

	@Test
	public void testUnmarshalWholeBoard() {
		Board board = Board.unmarshal("Kc,8s,Td,4s,Kh");
		assertEquals(Card.KING_OF_CLUBS, board.getFlop1());
		assertEquals(Card.EIGHT_OF_SPADES, board.getFlop2());
		assertEquals(Card.TEN_OF_DIAMONDS, board.getFlop3());
		assertEquals(Card.FOUR_OF_SPADES, board.getTurn());
		assertEquals(Card.KING_OF_HEARTS, board.getRiver());
	}

	@Test
	public void testUnmarshalTurn() {
		Board board = Board.unmarshal("Kc,8s,Td,4s");
		assertEquals(Card.KING_OF_CLUBS, board.getFlop1());
		assertEquals(Card.EIGHT_OF_SPADES, board.getFlop2());
		assertEquals(Card.TEN_OF_DIAMONDS, board.getFlop3());
		assertEquals(Card.FOUR_OF_SPADES, board.getTurn());
	}

	@Test
	public void testUnmarshalFlop() {
		Board board = Board.unmarshal("Kc,8s,Td");
		assertEquals(Card.KING_OF_CLUBS, board.getFlop1());
		assertEquals(Card.EIGHT_OF_SPADES, board.getFlop2());
		assertEquals(Card.TEN_OF_DIAMONDS, board.getFlop3());
	}

}
