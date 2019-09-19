package edu.cmu.andrew.mingyan2.task1;

import java.util.ArrayList;
import java.util.List;

public class Turing {
	// Initial state is 0 as indicated in the task
	int INITIAL_STATE = 0;
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
		StringBuilder outTape = new StringBuilder();
		while (currentState == INITIAL_STATE) { // while current state is not halt state
			char currentChar = tape[index]; // read one char
			int deltaIndex = Character.getNumericValue(currentChar);
			if (deltaIndex == 0 || deltaIndex == 1) {
				tape[index] = states.get(currentState).delta[deltaIndex].outChar; // flip
				outTape.append(Character.toString(tape[index])); // append this char to a stringbuilder
				// move the index to the next direction as delta says
				index += states.get(currentState).delta[deltaIndex].direction;
				// update current state
				currentState = states.get(currentState).delta[deltaIndex].toState;
			} else {
				tape[index] = states.get(currentState).delta[2].outChar; // flip
				outTape.append(Character.toString(tape[index]));
				// update curret state
				// now current state is 1 and we will break from this while loop
				currentState = states.get(currentState).delta[2].toState;
			}
		} // end while

		// append the remaining tape to the outTape
		for (int i = index + 1; i < tape.length; i++) {
			outTape.append(Character.toString(tape[i]));
		}

		return outTape.toString();
	}

}
