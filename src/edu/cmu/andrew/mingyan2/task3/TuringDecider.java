package edu.cmu.andrew.mingyan2.task3;

import java.util.Scanner;

public class TuringDecider {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// ask for user input
		boolean flag = true;
		String inTape = "";
		while (flag) {
			System.out.println("Enter a String:");
			inTape = scan.nextLine();
			if (!inTape.equals("")) {
				flag = false;
			}
		}
		// System.out.println(inTape);

		Turing machine3 = new Turing(6); // a 6-state machine

		// only state0 ~ state3 have transitions
		// state 4 is the reject state
		// state 5 is the accept state
		State s0 = new State(0);
		State s1 = new State(1);
		State s2 = new State(2);
		State s3 = new State(3);

		// add transitions
		s0.addTransition(new Transition('0', 'X', Transition.RIGHT, 1));
		s0.addTransition(new Transition('Y', 'Y', Transition.RIGHT, 3));
		s0.addTransition(new Transition('1', '1', Transition.RIGHT, 4));

		s1.addTransition(new Transition('0', '0', Transition.RIGHT, 1));
		s1.addTransition(new Transition('Y', 'Y', Transition.RIGHT, 1));
		s1.addTransition(new Transition('1', 'Y', Transition.LEFT, 2));
		s1.addTransition(new Transition('B', 'B', Transition.RIGHT, 4));

		s2.addTransition(new Transition('0', '0', Transition.LEFT, 2));
		s2.addTransition(new Transition('Y', 'Y', Transition.LEFT, 2));
		s2.addTransition(new Transition('X', 'X', Transition.RIGHT, 0));

		s3.addTransition(new Transition('Y', 'Y', Transition.RIGHT, 3));
		s3.addTransition(new Transition('B', 'B', Transition.RIGHT, 5));
		s3.addTransition(new Transition('1', '1', Transition.RIGHT, 4));

		// add state to the machine3
		machine3.addState(s0);
		machine3.addState(s1);
		machine3.addState(s2);
		machine3.addState(s3);

		String outTape = machine3.execute(inTape);
		System.out.println(outTape);

		scan.close();
	}
}
