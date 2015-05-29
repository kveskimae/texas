package club.texasholdem.texas.evaluation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import club.texasholdem.card.Card;
import club.texasholdem.texas.Board;
import club.texasholdem.texas.Hand;
import club.texasholdem.texas.HandCombination;

public class HandEvaluatorTest extends TestCase {

	private Hand hand;

	// FOUR_OF_A_KIND
	private Board emptyBoard, highCardBoard, pairBoard, twoPairsBoard, threeOfAKindBoard, fullHouseBoard, fourOfAKindBoard;

	@Before
	public void setUp() throws Exception {
		hand = new Hand(Card.EIGHT_OF_SPADES, Card.KING_OF_DIAMONDS);
		emptyBoard = new Board();
		highCardBoard = new Board();
		highCardBoard.setFlop1(Card.JACK_OF_CLUBS);
		highCardBoard.setFlop2(Card.TWO_OF_CLUBS);
		highCardBoard.setFlop3(Card.TEN_OF_DIAMONDS);
		pairBoard = new Board();
		pairBoard.setFlop1(Card.EIGHT_OF_DIAMONDS);
		pairBoard.setFlop2(Card.SEVEN_OF_HEARTS);
		pairBoard.setFlop3(Card.TWO_OF_HEARTS);
		twoPairsBoard = new Board();
		twoPairsBoard.setFlop1(Card.EIGHT_OF_DIAMONDS);
		twoPairsBoard.setFlop2(Card.SEVEN_OF_HEARTS);
		twoPairsBoard.setFlop3(Card.KING_OF_SPADES);
		threeOfAKindBoard = new Board();
		threeOfAKindBoard.setFlop1(Card.KING_OF_CLUBS);
		threeOfAKindBoard.setFlop2(Card.SEVEN_OF_HEARTS);
		threeOfAKindBoard.setFlop3(Card.KING_OF_SPADES);
		fullHouseBoard = new Board();
		fullHouseBoard.setFlop1(Card.KING_OF_CLUBS);
		fullHouseBoard.setFlop2(Card.EIGHT_OF_HEARTS);
		fullHouseBoard.setFlop3(Card.KING_OF_SPADES);
		fourOfAKindBoard = new Board();
		fourOfAKindBoard.setFlop1(Card.KING_OF_CLUBS);
		fourOfAKindBoard.setFlop2(Card.KING_OF_HEARTS);
		fourOfAKindBoard.setFlop3(Card.KING_OF_SPADES);
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
