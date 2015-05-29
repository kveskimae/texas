package club.texasholdem;


public class GameLogicException extends GameException {

	private static final long serialVersionUID = 1L;

	public GameLogicException(final String message) {
		super(message, GameExceptionType.LOGIC_FAILURE);
	}

}
