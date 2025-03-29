package tic_tac_toe.board;

public enum Symbol {

	X, O;

	public static Symbol fromString(String value) {
		try {
			return Symbol.valueOf(value.toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public Symbol getOpposite() {
		return (this == X) ? O : X;
	}
}
