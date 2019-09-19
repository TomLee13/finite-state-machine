package edu.cmu.andrew.mingyan2.task3;

import java.util.ArrayList;
import java.util.List;

public class Turing {
	// Initial state is 0 as indicated in the task
	int INITIAL_STATE = 0;
	int REJECT_STATE = 4;
	int ACCEPT_STATE = 5;
	int totalStates;
	int currentState;
	char[] tape = new char[100];
	List<State> states;

	// constructor
	public Turing(int statesCount) {
		totalStates = statesCount;
		for (int i = 0; i < 100; i++) {
			if (i == 0) {
				tape[i] = '0';
			}
			tape[i] = 'B';
		}
		states = new ArrayList<>();
	}

	void addState(State state) {
		if (states.size() < totalStates) {
			states.add(state);
		} else {
			System.out.println("States array is full.");
		}
	}

	String execute(String inTape) {
		// update tape with the String input
		for (int i = 0; i < inTape.length(); i++) {
			tape[i] = inTape.charAt(i);
		}

		// set current state to initial state.
		currentState = INITIAL_STATE;

		int index = 0;
		// StringBuilder outTape = new StringBuilder();
		// char[] outTape = new char[100];
		while (currentState != REJECT_STATE && currentState != ACCEPT_STATE) { // while current state is not halt state
			char currentChar = tape[index]; // read one char
			int deltaIndex = Character.getNumericValue(currentChar);
			if (deltaIndex == 0 || deltaIndex == 1) {
				tape[index] = states.get(currentState).delta[deltaIndex].outChar; // output
				// update index
				index += states.get(currentState).delta[deltaIndex].direction;
				// update current state
				currentState = states.get(currentState).delta[deltaIndex].toState;
			} else {
				if (currentChar == 'X') {
					tape[index] = states.get(currentState).delta[2].outChar; // output
					// update index
					index += states.get(currentState).delta[2].direction;
					// update state
					currentState = states.get(currentState).delta[2].toState;
				} else if (currentChar == 'Y') {
					tape[index] = states.get(currentState).delta[3].outChar; // output
					// update index
					index += states.get(currentState).delta[3].direction;
					// update state
					currentState = states.get(currentState).delta[3].toState;
				} else if (currentChar == 'B') {
					tape[index] = states.get(currentState).delta[4].outChar; // output
					// update index
					index += states.get(currentState).delta[4].direction;
					// update state
					currentState = states.get(currentState).delta[4].toState;
				}
			}
		} // end while

		// System.out.println("current state: " + currentState);

		// convert the char tape to a String,
		// indicating the final state.
		StringBuilder out = new StringBuilder();

		if (currentState == REJECT_STATE) {
			tape[0] = '0';
			for (int i = 1; i < tape.length; i++) {
				tape[i] = 'B';
			}
			for (int i = 0; i < tape.length; i++) {
				out.append(Character.toString(tape[i]));
			}
		} else if (currentState == ACCEPT_STATE) {
			tape[0] = '1';
			for (int i = 1; i < tape.length; i++) {
				tape[i] = 'B';
			}
			for (int i = 0; i < tape.length; i++) {
				out.append(Character.toString(tape[i]));
			}
		}

		return out.toString();
	}

}
