import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//You work in a company that's main product is a search engine. You have noticed that users make a lot of mistakes while typing :) And that the most common mistake is that they type a very similar word instead of the one they are looking for. So what you have decided is to make suggestions to the users while they are typing. You want to suggest valid words from the dictionary that contain the same letters (and the same number of each letter) but in different orders.
//
//For example, a user types "act", you might want to suggest "cat". In the same way, if user types "elvis", your suggestion should be "lives".
//
//Your goal is to find all possible suggestions for a set of words and a given dictionary. Assume that all the words in the dictionary are correct.


public class DidYouMean {

	public static void main(String[] args) {
		
		new DidYouMean().run();
	}
	
	public void run(){
		
		BufferedReader br = null;
		try {
			 
			String sCurrentLine; 
			br = new BufferedReader(new FileReader("input.in"));				
			br.readLine();
			
			String dictionaryName = br.readLine();
			BufferedReader br2 = new BufferedReader(new FileReader(dictionaryName));
			br.readLine();
			
			int numberOfWords = Integer.parseInt(br.readLine());
			br.readLine();
			
			for(int i=0; i<numberOfWords;i++){
				String word = br.readLine();
				int[] firstWordChecker = new int[256];
				// In each array position, we count how many times a letter appears in the word
				for(int j=0; j<word.length();j++){
					int letter = word.charAt(j);
					firstWordChecker[letter]++;
				}
				
				System.out.print(word+" ->");
				String word2;
				while((word2 = br2.readLine())!=null){
					int[] temporalArray = new int[firstWordChecker.length];
					System.arraycopy(firstWordChecker, 0, temporalArray, 0, temporalArray.length);
					if(ChekSimilarWords(word,temporalArray,word2)){
						System.out.print(" "+word2);
					}
				}
				System.out.println();
				
			}
			
	
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static boolean ChekSimilarWords(String word1,int[] listOfCharacters, String word2){
		if(word1.length() != word2.length())
			return false;
		for(int i=0; i<word2.length();i++){
			int pos = word2.charAt(i);
			if(listOfCharacters[pos] == 0){
				return false;
			}else{
				listOfCharacters[pos]--;
			}
		}
	return true;	
	}

}
