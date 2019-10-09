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
		System.out.println(hm);
		decode("-.-.-", "");
	}
	
	public static void loadMap(String[] alphabet, String[] morseCodes) {
		for(int i = 0; i < 36; i++) {
			hm.put(morseCodes[i], alphabet[i]);
		}
	}
	
	public static void decode(String input, String output) {
		String smallerInput = "";
		if(input.length()<1) {
			System.out.println(output);
			return;
		} 
		for(int i = 1; i <= input.length(); i++) {
			smallerInput=input.substring(0, i);
			if(hm.containsKey(smallerInput)) {
				decode(input.substring(i), output + hm.get(smallerInput));
			}
		}
	}

}
