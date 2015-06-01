package club.texasholdem;

import java.util.HashMap;
import java.util.Map;

import club.texasholdem.card.CardPack;
import club.texasholdem.card.CardPackFactory;
import club.texasholdem.texas.Board;
import club.texasholdem.texas.Hand;
import club.texasholdem.texas.HandCombination;
import club.texasholdem.texas.evaluation.HandEvaluator;

/**
 * 
 * Following is benchmark history for the speed of evaluating hand combinations.
 * <p>
 * Measured as the number of hands generated and valued on i7 machine with 2.5 GHz processor:
 * <ul>
 * <li>May 31, 2015: <b>1M/2926ms</b></li>
 * <li>...</li>
 * <li>TARGET: 10M/s</li>
 * </ul>
 * 
 * @see To verify occurrence probabilities in sanity check use <a href="http://wizardofodds.com/games/poker/">Wizard of Odds Seven-Card Stud probabilities</a>
 * 
 * @author kristjanveskimae
 *
 */
public class BenchmarkRunner {
	
	public static final int HANDS = 1000000;

	private long start, end, total;
	
	private CardPackFactory packFactory = new CardPackFactory();
	private Map<HandCombination, Integer> occurrences = new HashMap<HandCombination, Integer>();
	
	public BenchmarkRunner() {
	}
	
	public static void main(String[] args) {
		BenchmarkRunner runner = new BenchmarkRunner();
		runner.runBenchmarkTest();
		runner.printBenchMark();
	}

	private void printBenchMark() {
		System.out.println("------------------------------------------------------------");
		System.out.println("-- Total time for " + HANDS + " hands was " + total + "ms");
		System.out.println("-- Occurrences for sanity check:");
		for (HandCombination combination : HandCombination.values()) {
			Integer combinationTimes = occurrences.get(combination);
			if (combinationTimes == null) {
				combinationTimes = 0;
			}
			System.out.println(combination + " : " + combinationTimes);
		}
		System.out.println("------------------------------------------------------------");
	}

	private void runBenchmarkTest() {
		start = System.currentTimeMillis();
		int onePercent = HANDS / 100;
		System.out.print("Done ");
		for (int i = 0; i < HANDS; i++) {
			HandEvaluator evaluator = createRandomHandEvaluator();
			increaseOccurrence(evaluator.getBestCombination());
			if (i % onePercent == 0) {
				int percent = i / onePercent;
				System.out.print("" + percent + "% ");
				if (i != 0 && percent % 20 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println("100%");
		end = System.currentTimeMillis();
		total = end - start;
	}

	private void increaseOccurrence(HandCombination bestCombination) {
		Integer timesOccurred = occurrences.get(bestCombination);
		if (timesOccurred == null) {
			timesOccurred = 0;
		}
		timesOccurred++;
		occurrences.put(bestCombination, timesOccurred);
	}

	private HandEvaluator createRandomHandEvaluator() {
		CardPack pack = packFactory.createShuffledPack();
		Hand hand = new Hand(pack.dealOne(), pack.dealOne());
		Board board = new Board();
		board.setFlop1(pack.dealOne());
		board.setFlop2(pack.dealOne());
		board.setFlop3(pack.dealOne());
		board.setTurn(pack.dealOne());
		board.setRiver(pack.dealOne());
		HandEvaluator evaluator = new HandEvaluator(hand, board);
		return evaluator;
	}

}
