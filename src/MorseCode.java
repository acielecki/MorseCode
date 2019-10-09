/**
* MorseCode is a program that takes any given combination of
* Morse code characters, without spaces, and outputs a 
* list of all possible alphanumeric translations using 
* a recursive algorithm.
* 
* @author  Alissa Cielecki
* @version 1.0
* @since   2019-10-09
*/
import java.util.HashMap;
public class MorseCode {
	public static HashMap<String, String> hm = new HashMap<String, String>();
	public static void main(String[] args) {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "0"};

		String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
				"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
				"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--..", ".----", "..---", "...--", "....-", ".....",
				"-....", "--...", "---..", "----.", "-----"};
		
		loadMap(alphabet, morseCodes);
		//System.out.println(hm); //shows the full map of alphabet and Morse code equivalencies
		decode("-.-.-", "");
	}
	
	//loadMap puts the Morse code and alphabet arrays into a HashMap, with Morse codes as the key
	public static void loadMap(String[] alphabet, String[] morseCodes) {
		for(int i = 0; i < 36; i++) {
			hm.put(morseCodes[i], alphabet[i]);
		}
	}
	
	//decode takes in two inputs: the Morse code to be decoded and the string that the output is constructed on
	//it returns no value but outputs each possible translation of the code on a separate line, using recursion
	public static void decode(String input, String output) {
		String smallerInput = "";
		//once the input is at its smallest point, prints output
		if(input.length()==0) {
			System.out.println(output);
			return;
		} 
		//loops through the length of the input, starting at 1
		for(int i = 1; i <= input.length(); i++) {
			//sets smallerInput to a substring of input in each iteration 
			smallerInput=input.substring(0, i);
			//if the substring is in the HashMap, call decode with substring of input
			//and adds output to itself in recursive call, constructing string
			if(hm.containsKey(smallerInput)) {
				decode(input.substring(i), output + hm.get(smallerInput));
			}
		}
	}

}
