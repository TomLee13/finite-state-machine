package edu.cmu.andrew.mingyan2.task1;

public class Transition {
	static int RIGHT = 1;
	char inChar;
	char outChar;
	int direction;
	int toState;

	public Transition(char inChar, char outChar, int direction, int toState) {
		this.inChar = inChar;
		this.outChar = outChar;
		this.direction = direction;
		this.toState = toState;
	}
}
