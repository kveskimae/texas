package club.texasholdem.texas.evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import club.texasholdem.GameLogicException;
import club.texasholdem.card.Card;
import club.texasholdem.card.Rank;
import club.texasholdem.card.Suit;
import club.texasholdem.texas.Board;
import club.texasholdem.texas.Hand;

public class HandData {

	private final Hand hand;
	private final Board board;
	private final TreeSet<Card> orderedCards;
	private final Map<Suit, TreeSet<Card>> flushCards = new HashMap<Suit, TreeSet<Card>>();
	private final Map<Rank, Integer> ranksCounter = new HashMap<Rank, Integer>();
	private final Map<Suit, Integer> suitsCounter = new HashMap<Suit, Integer>();

	public HandData(final Hand hand, final Board board) {
		this.hand = hand;
		this.board = board;
		orderedCards = new TreeSet<Card>();
		verifyHandArgument(hand);
		verifyBoardArgument(board);
		initializeCards();
		initializeRankCounter();
		initializeSuitsCounter();
		initializeFlushCards();
	}

	private void initializeFlushCards() {
		flushCards.clear();
		for (Card card : orderedCards) {
			Suit suit = card.getSuit();
			TreeSet<Card> sameSuitCards = flushCards.get(suit);
			if (sameSuitCards == null) {
				sameSuitCards = new TreeSet<Card>();
			}
			sameSuitCards.add(card);
			flushCards.put(suit, sameSuitCards);
		}
	}

	private static void verifyHandArgument(final Hand hand) {
		if (hand == null) {
			throw new GameLogicException("Hand cannot be null");
		}
	}

	private static void verifyBoardArgument(final Board board) {
		if (board == null) {
			throw new GameLogicException("Board cannot be null");
		}
		if (board.getFlop1() == null || board.getFlop2() == null || board.getFlop3() == null) {
			throw new GameLogicException("Flop must be dealt");
		}
	}

	private void initializeRankCounter() {
		ranksCounter.clear();
		for (Card card : orderedCards) {
			Rank rank = card.getRank();
			Integer rankCount = ranksCounter.get(rank);
			if (rankCount == null) {
				rankCount = 0;
			}
			rankCount++;
			ranksCounter.put(rank, rankCount);
		}
	}

	private void initializeSuitsCounter() {
		suitsCounter.clear();
		for (Card card : orderedCards) {
			Suit suit = card.getSuit();
			Integer suitCount = suitsCounter.get(suit);
			if (suitCount == null) {
				suitCount = 0;
			}
			suitCount++;
			suitsCounter.put(suit, suitCount);
		}
	}

	private void initializeCards() {
		orderedCards.clear();
		orderedCards.add(hand.getCard1());
		orderedCards.add(hand.getCard2());
		orderedCards.add(board.getFlop1());
		orderedCards.add(board.getFlop2());
		orderedCards.add(board.getFlop3());
		if (board.getTurn() != null) {
			orderedCards.add(board.getTurn());
		}
		if (board.getRiver() != null) {
			orderedCards.add(board.getRiver());
		}
	}

	public TreeSet<Card> getOrderedCards() {
		return orderedCards;
	}

	public Map<Rank, Integer> getRanksCounter() {
		return ranksCounter;
	}

	public Map<Suit, Integer> flushCardsCounter() {
		return suitsCounter;
	}
	
	public Map<Suit, TreeSet<Card>> getFlushCards() {
		return flushCards;
	}

}
