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

	private Hand hand, straightHand, highStraightHand, lowStraightHand, straightWithRiverHighHand, straightWithRiverHand;

	private Board emptyBoard, highCardBoard, pairBoard, twoPairsBoard, threeOfAKindBoard, straightBoard, highStraightBoard, lowStraightBoard, straightWithRiverHighBoard, straightWithRiverBoard, fullHouseBoard, fourOfAKindBoard;

	@Before
	public void setUp() throws Exception {
		hand = new Hand(Card.EIGHT_OF_SPADES, Card.KING_OF_DIAMONDS);
		straightHand = new Hand(Card.EIGHT_OF_SPADES, Card.JACK_OF_SPADES);
		highStraightHand = new Hand(Card.QUEEN_OF_CLUBS, Card.JACK_OF_SPADES);
		lowStraightHand = new Hand(Card.THREE_OF_CLUBS, Card.FIVE_OF_DIAMONDS);
		straightWithRiverHighHand = new Hand(Card.KING_OF_HEARTS, Card.SIX_OF_HEARTS);
		straightWithRiverHand = new Hand(Card.KING_OF_HEARTS, Card.NINE_OF_DIAMONDS);
		emptyBoard = new Board();
		highCardBoard = Board.unmarshal("Jc,2c,Td");
		pairBoard = Board.unmarshal("8d,7h,2h");
		twoPairsBoard = Board.unmarshal("8d,7h,Ks");
		threeOfAKindBoard = Board.unmarshal("Kc,7h,Ks");
		straightBoard = Board.unmarshal("Ts,Qd,9c");
		highStraightBoard = Board.unmarshal("Ts,Ah,Kd");
		lowStraightBoard = Board.unmarshal("4h,Ac,2s");
		straightWithRiverHighBoard = Board.unmarshal("Jd,3c,Th,Ad,Qs"); // 3c,6h,9d,Th,Jd,Qs,Kh,Ad
		straightWithRiverBoard = Board.unmarshal("Jd,3c,Th,6d,Qs");
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

	// TODO two pairs comparison needs to take into account three pairs
	// situation
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

	@Test
	public void testStraight() {
		HandEvaluator evaluator = new HandEvaluator(straightHand, straightBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.STRAIGHT, handRank);
	}

	@Test
	public void testLowStraight() {
		HandEvaluator evaluator = new HandEvaluator(lowStraightHand, lowStraightBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.STRAIGHT, handRank);
	}

	@Test
	public void testHighStraight() {
		HandEvaluator evaluator = new HandEvaluator(highStraightHand, highStraightBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.STRAIGHT, handRank);
	}

	@Test
	public void testStraightWithRiverHigh() {
		HandEvaluator evaluator = new HandEvaluator(straightWithRiverHighHand, straightWithRiverHighBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.STRAIGHT, handRank);
	}

	@Test
	public void testStraightWithRiver() {
		HandEvaluator evaluator = new HandEvaluator(straightWithRiverHand, straightWithRiverBoard);
		HandCombination handRank = evaluator.getBestCombination();
		assertEquals(HandCombination.STRAIGHT, handRank);
	}

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
	 * ROYAL_FLUSH,
	 * 
	 * STRAIGHT_FLUSH,
	 * 
	 * FLUSH,
	 * 
	 * STRAIGHT,
	 */

}
