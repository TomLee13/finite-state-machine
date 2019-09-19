package edu.cmu.andrew.mingyan2.task3;

public class State {
	int stateNumber;

	// This is an array storing transition deltas
	// '0' | '1' | 'X' | 'Y' | 'B'
	Out[] delta = new Out[5];

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
			if (trans.inChar == 'X') {
				delta[2] = new Out(trans.outChar, trans.toState, trans.direction);
				// System.out.println("transition " + 2 + ": " + delta[2].toString());
			} else if (trans.inChar == 'Y') {
				delta[3] = new Out(trans.outChar, trans.toState, trans.direction);
			} else if (trans.inChar == 'B') {
				delta[4] = new Out(trans.outChar, trans.toState, trans.direction);
			}
		}
	}
}
