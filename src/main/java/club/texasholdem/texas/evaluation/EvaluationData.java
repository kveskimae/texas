package club.texasholdem.texas.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import club.texasholdem.GameLogicException;
import club.texasholdem.card.Card;
import club.texasholdem.card.Rank;
import club.texasholdem.texas.Board;
import club.texasholdem.texas.Hand;

public class EvaluationData {

	private final Hand hand;
	private final Board board;
	private final TreeSet<Card> orderedCards;
	private final Map<Rank, Integer> ranksCounter = new HashMap<Rank, Integer>();

	public EvaluationData(final Hand hand, final Board board) {
		this.hand = hand;
		this.board = board;
		orderedCards = new TreeSet<Card>();
		verifyHandArgument(hand);
		verifyBoardArgument(board);
		initializeCards();
		initializeRankCounter();
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

}
