/*
 * wordElem objects contain a word as key
 * and a value associated with it, which can be used
 * like a Map object but we can also store them into arrays
 * in order to sort them because it implements the Comparable interface
 */
public class WordElem implements Comparable<WordElem> {
	private String key;
	private int value;
	
	//constructor
	public WordElem(String key, int value) {
		this.key = key;
		this.value = value;
	}
	
	//getter
	public String getKey() {
		return this.key;
	}
	
	//for the comparable interface
	public int compareTo(WordElem other) {
		if(this.value == other.value)
			return 0;
		else if(this.value > other.value)
			return -1;
		else
			return 1;
	}
}
