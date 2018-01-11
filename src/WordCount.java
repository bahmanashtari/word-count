import java.util.*;
import java.io.*;
/*
 * the main point of this program is that we use a LinkedList to store the keys from the Map
 * then we use the Collections interface to sort elements of the LinkedList 
 * then we use the sorted LinkedList to print out its element and we get the associated values from the Map 
 * 
 */
public class WordCount {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("hamlet.txt")); 
		
		Map<String, Integer> WordCount = new TreeMap<String, Integer>(); //this map will store all the words without punctuation as keys 
																			 //and the count for each word as value 
		while(in.hasNext()) {
			String temp = stripPunc(in.next().toUpperCase()); //getting rid of punctuation
			if( ! WordCount.containsKey(temp)) {  //if key doesn't exist in the map, add it with the value one
				WordCount.put(temp, 1);		
			} else {
				WordCount.put(temp, WordCount.get(temp)+1);////if already exist just increment the value associated with it
			}
		}
		
		List<WordElem> wordElemList = new LinkedList<WordElem>();  //this list will store all WordElem objects so we can sort them
		Iterator<String> itr = WordCount.keySet().iterator();  //iterator to go through a set of all keys from the map
		while(itr.hasNext()) {
			String key = itr.next();
			WordElem tempWordElem = new WordElem(key, WordCount.get(key));  //creating WordElem objects with keys from WordCount and their associated values
			wordElemList.add(tempWordElem);  //adding object to the LinkedList
		}
		Collections.sort(wordElemList); //now we can use the Collections sorting method over the LinkedList to sort it
		for(WordElem e : wordElemList)
			System.out.printf("\n[%s, %d]\n", e.getKey(), WordCount.get(e.getKey()));
	}

	//this method gets rid of all punctuation in a string
	public static String stripPunc(String str) {
		String res ="";
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(Character.isLetter(c))
				res += c;
		}
		return res;
	}
}
