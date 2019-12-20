package com.CodeChallenge;

import java.util.Stack;

public class BracketMatcher {
	
	Stack<Character> bracketStack = new Stack<Character>();
	public String isBalancedExpression;
	public int matchCount=0;
	public boolean checkEmptyStackWhilePoppingElements=true;
	
	public void findBalancedExpression(String inputString) {

		int i = 0, strLength = inputString.length();

		for (i = 0; i < strLength; i++) {
			char ch = inputString.charAt(i);
			if (ch == '(' || ch == '{' || ch == '<' || ch == '[') {
				bracketStack.push(ch);
			} else if (ch == ')') {
					popUpElementsFromStack('(');
			} else if (ch == '}') {
					popUpElementsFromStack('{');
			} else if (ch == '>') {
					popUpElementsFromStack('<');
			} else if (ch == ']') {
					popUpElementsFromStack('[');
			}
		}
		isBalancedExpression=(bracketStack.isEmpty() && checkEmptyStackWhilePoppingElements)?"Balanced":"Not Balanced";
	}
	
	public void popUpElementsFromStack(Character expectedCharacter) {
		if(bracketStack.isEmpty()) {
			checkEmptyStackWhilePoppingElements=false;
		}
		else {
			containsElement(expectedCharacter);
		}
	}
	
	public void containsElement(Character expectedCharacter) {
		if(bracketStack.contains(expectedCharacter)) { 
			bracketStack.remove(expectedCharacter);
			matchCount+=1;
		}
		else {
			checkEmptyStackWhilePoppingElements=false;
		}
	}
}
