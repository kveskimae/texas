package club.texasholdem.texas.evaluation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import club.texasholdem.GameLogicException;
import club.texasholdem.card.Card;
import club.texasholdem.texas.Board;
import club.texasholdem.texas.Hand;
import club.texasholdem.texas.HandCombination;

public class HandEvaluatorTest extends TestCase {

	private Hand hand, straightHand;

	private Board emptyBoard, highCardBoard, pairBoard, twoPairsBoard, threeOfAKindBoard, straightBoard, fullHouseBoard, fourOfAKindBoard;

	@Before
	public void setUp() throws Exception {
		hand = new Hand(Card.EIGHT_OF_SPADES, Card.KING_OF_DIAMONDS);
		straightHand = new Hand(Card.EIGHT_OF_SPADES, Card.JACK_OF_SPADES);
		emptyBoard = new Board();
		highCardBoard = Board.unmarshal("Jc,2c,Td");
		pairBoard = Board.unmarshal("8d,7h,2h");
		twoPairsBoard = Board.unmarshal("8d,7h,Ks");
		threeOfAKindBoard = Board.unmarshal("Kc,7h,Ks");
		straightBoard = Board.unmarshal("Ts,Qd,9c");
		fullHouseBoard = Board.unmarshal("Kc,8h,Ks");
		fourOfAKindBoard = Board.unmarshal("Kc,Kh,Ks");
	}

	@Test
	public void testThrowsWithNullHand() {
		try {
			new HandEvaluator(null, highCardBoard);
			fail("Must throw excpetion");
		} catch (Exception e) {
			assertThat(e, instanceOf(GameLogicException.class));
		}
	}

	@Test
	public void testThrowsWithNullBoard() {
		try {
			new HandEvaluator(hand, null);
			fail("Must throw excpetion");
		} catch (Exception e) {
			assertThat(e, instanceOf(GameLogicException.class));
		}
	}

	@Test
	public void testThrowsIfFlopNotDealt() {
		try {
			new HandEvaluator(hand, emptyBoard);
			fail("Must throw excpetion");
		} catch (Exception e) {
			assertThat(e, instanceOf(GameLogicException.class));
		}
	}

	@Test
	public void testHighCard() {
		HandEvaluator evaluator = new HandEvaluator(hand, highCardBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.HIGH_CARD, handRank);
	}

	@Test
	public void testPair() {
		HandEvaluator evaluator = new HandEvaluator(hand, pairBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.PAIR, handRank);
	}

	// TODO two pairs comparison needs to take into account three pairs situation 
	@Test
	public void testTwoPairs() {
		HandEvaluator evaluator = new HandEvaluator(hand, twoPairsBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.TWO_PAIRS, handRank);
	}

	@Test
	public void testThreeOfAKind() {
		HandEvaluator evaluator = new HandEvaluator(hand, threeOfAKindBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.THREE_OF_A_KIND, handRank);
	}

	// TODO
	/*
	@Test
	public void testStraight() {
		HandEvaluator evaluator = new HandEvaluator(straightHand, straightBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.STRAIGHT, handRank);
	}*/

	@Test
	public void testFullHouse() {
		HandEvaluator evaluator = new HandEvaluator(hand, fullHouseBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.FULL_HOUSE, handRank);
	}

	@Test
	public void testFourOfAKindBoard() {
		HandEvaluator evaluator = new HandEvaluator(hand, fourOfAKindBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.FOUR_OF_A_KIND, handRank);
	}
	
	
	
	/*
	 * 	ROYAL_FLUSH, 
	
	STRAIGHT_FLUSH, 
	
	FULL_HOUSE,
	
	FLUSH,
	
	STRAIGHT,
	
	
	 * */

}
