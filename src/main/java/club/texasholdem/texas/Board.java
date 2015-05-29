package club.texasholdem.texas;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import club.texasholdem.card.Card;
import club.texasholdem.texas.evaluation.GameMarshalException;

public class Board {

	private Card flop1, flop2, flop3, turn, river;

	public Board() {
	}

	public static Board unmarshal(final String marshaled) {
		return BoardUnmarshaler.unmarshal(marshaled);
	}

	public Card getFlop1() {
		return flop1;
	}

	public void setFlop1(Card flop1) {
		this.flop1 = flop1;
	}

	public Card getFlop2() {
		return flop2;
	}

	public void setFlop2(Card flop2) {
		this.flop2 = flop2;
	}

	public Card getFlop3() {
		return flop3;
	}

	public void setFlop3(Card flop3) {
		this.flop3 = flop3;
	}

	public Card getTurn() {
		return turn;
	}

	public void setTurn(Card turn) {
		this.turn = turn;
	}

	public Card getRiver() {
		return river;
	}

	public void setRiver(Card river) {
		this.river = river;
	}

}
