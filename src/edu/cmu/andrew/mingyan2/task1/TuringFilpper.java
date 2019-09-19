package edu.cmu.andrew.mingyan2.task1;

public class TuringFilpper {
	public static void main(String[] args) {
		Turing machine1 = new Turing(2); // a two-state machine

		// create new state0
		// only s0 has transitions
		State s0 = new State(0);

		// add transitions
		s0.addTransition(new Transition('0', '1', Transition.RIGHT, 0));
		s0.addTransition(new Transition('1', '0', Transition.RIGHT, 0));
		s0.addTransition(new Transition('B', 'B', Transition.RIGHT, 1));

		// add the state to the machine
		machine1.addState(s0);

		String inTape = "0101010101010";

		System.out.println(inTape);

		String outTape = machine1.execute(inTape);
		System.out.println(outTape);
	}
}
