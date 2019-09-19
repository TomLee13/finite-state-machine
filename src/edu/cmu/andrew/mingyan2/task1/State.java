package edu.cmu.andrew.mingyan2.task1;

public class State {
	int stateNumber;

	// This is an array storing transition deltas
	// '0' | '1' | 'B'
	// '1', RIGHT | '0', RIGHT | 'B', RIGHT
	Out[] delta = new Out[3];

	// inner Out class to implement matrix approach for state transition.
	public class Out {
		char outChar;
		int toState;
		int direction;

		public Out(char outChar, int toState, int direction) {
			this.outChar = outChar;
			this.toState = toState;
			this.direction = direction;
		}

		public String toString() {
			return "outChar: " + outChar + " toState: " + toState + " direction: " + direction;
		}
	}

	public State(int stateNumber) {
		this.stateNumber = stateNumber;
	}

	void addTransition(Transition trans) {
		int index = Character.getNumericValue(trans.inChar);
		// System.out.println("trans.inChar: " + index);

		if (index == 0 || index == 1) {
			delta[index] = new Out(trans.outChar, trans.toState, trans.direction);
			// System.out.println("transition " + index + ": " + delta[index].toString());
		} else {
			delta[2] = new Out(trans.outChar, trans.toState, trans.direction);
			// System.out.println("transition " + 2 + ": " + delta[2].toString());
		}
	}
}
