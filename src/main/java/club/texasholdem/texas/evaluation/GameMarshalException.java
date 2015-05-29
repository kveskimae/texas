package club.texasholdem.texas.evaluation;

import club.texasholdem.GameException;
import club.texasholdem.GameExceptionType;

public class GameMarshalException extends GameException {
	
	private static final long serialVersionUID = 1L;

	public GameMarshalException(final String message) {
		this(message, null);
	}

	public GameMarshalException(final String message, final Exception e) {
		super(message, e, GameExceptionType.MARSHAL_FAILURE);
	}

}
