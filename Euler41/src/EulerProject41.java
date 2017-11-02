import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;

public class EulerProject41 {

	public static void main(String[] args) {
		//We shall say that an n-digit number is pandigital
		//if it makes use of all the digits 1 to n exactly once. 
		//For example, 2143 is a 4-digit pandigital and is also prime.
		
		//What is the largest n-digit pandigital prime that exists?
		
		//No need to check 8 becauase the sum of 1->8 is 36 so any number containing the digits 1-8
		//without repeats will be divisible by 3
		//Same holds true for 1-9		
		Collection<List<Character>> uniquePermutations = 
				  Collections2.orderedPermutations(Lists.charactersOf("1234567"));

		ArrayList<Long> primes = new ArrayList<Long>();
		for(List<Character> prime : uniquePermutations){
			char[] pArray = Chars.toArray(prime);
			long primeVal = Long.parseLong(new String(pArray));
			if(isPrime(primeVal)) {
				primes.add(primeVal);
			}
		}
		Collections.sort(primes);
		System.out.println(primes.get(primes.size()-1));
	}
	private static boolean isPrime(long value) {
		int end = (int)Math.floor(Math.sqrt(value));
		boolean isPrime = true;
		if(value % 2 != 0 && value % 3 != 0 && value % 5 != 0) {				
			for(int j=7;j<=end;j+=2) {
				if(value % j ==0) {
					isPrime =false;
					break;
				}
			}
		}
		else {
			isPrime =false;
		}
		return isPrime;
	}

}
