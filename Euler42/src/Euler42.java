import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashSet;

public class Euler42 {

	public static void main(String[] args) throws IOException {
		/* The nth term of the sequence of triangle numbers is given by,
		 * tn = ½n(n+1); so the first ten triangle numbers are:
		 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
		 * By converting each letter in a word to a number corresponding to its
		 * alphabetical position and adding these values we form a word value. 
		 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
		 * If the word value is a triangle number then we shall call the word a triangle word.
		 */ 


		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		File wordsFile = new File("p042_words.txt");
		List<String> wordsList = new ArrayList<String>();
		String line = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(wordsFile))){
			while ((line = br.readLine()) != null) {

				// use comma as separator
				wordsList.addAll(Arrays.asList(line.split(",")));          

			}
		}
		Set<Integer> triNums = new HashSet<Integer>();
		//30 is an arbitrary stopping point but this covers all
		//words up to 19 characters long
		for(int i=1;i<30;i++){
			int val = (i*(i+1)/2);
			triNums.add(val);

		}
		int triCounter = 0;
		for(String word : wordsList){
			char[] letters = word.toLowerCase().toCharArray();
			int wordVal=0; 
			for(char letter : letters){
				int value = alphabet.indexOf(letter)+1;
				wordVal += value;
			}
			if(triNums.contains(wordVal)){
				triCounter++;
			}
		}
		System.out.println(triCounter);

	}

}
