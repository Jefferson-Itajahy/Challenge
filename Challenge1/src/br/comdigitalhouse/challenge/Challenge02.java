package br.comdigitalhouse.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Challenge02 {

	public static String ArrayChallenge(String[] strArr) {

	    //my code starts here

	    String pattern = strArr[0];
	    String[] dictionaryWords = strArr[1].split(",");

	    Set<String> dictionaryWordSet = new HashSet<>(Arrays.asList(dictionaryWords));

	    String[] tempArr = new String[2];

	    for (int i = 0; i < pattern.length(); i++) {
	        String firstWord = pattern.substring(0, i);

	        if(dictionaryWordSet.contains(firstWord)) {
	            if(tempArr[0] == null) {
	                tempArr[0] = firstWord;
	            } else if(tempArr[0].length() < firstWord.length()) {
	                tempArr[0] = firstWord;
	            }
	        }

	        String lastWord = pattern.substring(i);

	        if(dictionaryWordSet.contains(lastWord)) {
	            tempArr[1] = lastWord;
	            break;
	        }
	    }

	    if(!pattern.equals(tempArr[0] + tempArr[1])) {
	        return "not possible";
	    }

	    strArr[0] = tempArr[0] + "," + tempArr[1];

	    //My code ends here

	    return strArr[0];
	}

	public static void main(String[] args) {
	    String[] arr = new String[] {"hellocat", "apple, bat, cat, goodbye, hello, yellow, why"};
		//Scanner s = new Scanner(System.in);
	    System.out.println(ArrayChallenge(arr));
	}
}