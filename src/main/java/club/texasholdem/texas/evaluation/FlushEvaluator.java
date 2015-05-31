package club.texasholdem.texas.evaluation;

public class FlushEvaluator {

	private final HandData data;

	private boolean flush = false;

	public FlushEvaluator(final HandData data) {
		this.data = data;
		for (Integer sameRankedCount : this.data.flushCardsCounter().values()) {
			checkFlush(sameRankedCount);
		}
	}

	private void checkFlush(final int count) {
		if (count >= 5) {
			flush = true;
		}
	}
	
	public boolean isFlush() {
		return flush;
	}

}
