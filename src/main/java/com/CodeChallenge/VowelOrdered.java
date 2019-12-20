package com.CodeChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class VowelOrdered {
	List<String> outputList = new ArrayList<String>();
	static HashMap<Integer, Integer> vowelCountOrderedWordsMap = new HashMap<Integer, Integer>();
	public static int vowelCount;
	public static String vowelStatus;

	public int testWord(String inputWord) {

		boolean value;

		value = areVowelsInOrder(inputWord);

		// check if string do not contain any vowel
		if (inputWord.matches("[^aeiouAEIOU]+")) {
			value = false;
			vowelStatus = "Not-Ordered";

		}
		// check if string contains all digits
		else if (inputWord.matches("[0-9]")) {
			value = false;
			vowelStatus = "Not-Ordered";

		}

		else if (value) {
			vowelStatus = "Ordered";
			// check vowel count is present in map as key ,if
			// present increment ordered word count by 1
			if (vowelCountOrderedWordsMap.containsKey(vowelCount)) {

				vowelCountOrderedWordsMap.put(vowelCount, vowelCountOrderedWordsMap.get(vowelCount) + 1);
			} // vowel count is not present in map as key ,then add
				// it as new key and add ordered word count as 1 for
				// that vowel
			else {
				vowelCountOrderedWordsMap.put(vowelCount, 1);
			}

		} else {
			vowelStatus = "Not-Ordered";
			// if characters in string contains vowel but not in
			// order

		}

		return vowelCount;
	}

	public boolean areVowelsInOrder(String word) {

		Boolean status = true;
		// reset vowel count for each string
		vowelCount = 0;
		int wordLength = word.length();

		// storing smallest character value variable
		char smallestCharacter = (char) 64;
		Character nextChar, previousChar;

		for (int i = 0; i <= wordLength - 1; i++) {

			// Check string contains ordered vowels
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u' || word.charAt(i) == 'A' || word.charAt(i) == 'E' || word.charAt(i) == 'I'
					|| word.charAt(i) == 'O' || word.charAt(i) == 'U') {

				++vowelCount;
				
				// assign values to c1, c2
				nextChar = new Character(Character.toLowerCase(word.charAt(i)));
				previousChar = new Character(Character.toLowerCase(smallestCharacter));

				int res = nextChar.compareTo(previousChar);

				// if character value is less then it is not ordered
				if (res < 0)
					status = false;
				// swap character with already stored smallest character
				else {

					smallestCharacter = word.charAt(i);

				}
				
				/*// if character value is less then it is not ordered
				if ((word.charAt(i) == 'A' || word.charAt(i) == 'a')
						&& (smallestCharacter == 'E' || smallestCharacter == 'e' || smallestCharacter == 'I'
								|| smallestCharacter == 'i' || smallestCharacter == 'O' || smallestCharacter == 'o'
								|| smallestCharacter == 'U' || smallestCharacter == 'u')) {
					status = false;
				} else if ((word.charAt(i) == 'E' || word.charAt(i) == 'e')
						&& (smallestCharacter == 'I' || smallestCharacter == 'i' || smallestCharacter == 'O'
								|| smallestCharacter == 'o' || smallestCharacter == 'U' || smallestCharacter == 'u')) {
					status = false;
				} else if ((word.charAt(i) == 'I' || word.charAt(i) == 'i') && (smallestCharacter == 'O'
						|| smallestCharacter == 'o' || smallestCharacter == 'U' || smallestCharacter == 'u')) {
					status = false;
				} else if ((word.charAt(i) == 'O' || word.charAt(i) == 'o')
						&& (smallestCharacter == 'U' || smallestCharacter == 'u')) {
					status = false;
				} else {

					smallestCharacter = word.charAt(i);

				}*/
			}

		}

		return status;

	}

	public static void getOutput() {
		// Getting all the values from map and adding it to array list of
		// ordered words for each vowel count
		ArrayList<Integer> orderWordCountArray = new ArrayList<Integer>();
		for (Entry<Integer, Integer> entry : vowelCountOrderedWordsMap.entrySet()) {
			orderWordCountArray.add(entry.getValue());

		}
		System.out.println("hashmap" + vowelCountOrderedWordsMap);
		System.out.println("Output Array as per vowel count" + orderWordCountArray);

	}

}
