package club.texasholdem;

public abstract class GameException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final GameExceptionType type;

	public GameException(final String message, final GameExceptionType type) {
		this(message, null, type);
	}

	public GameException(final String message, final Exception e, final GameExceptionType type) {
		super(message, e);
		this.type = type;
	}
	
	public GameExceptionType getType() {
		return type;
	}

}
