import java.util.ListIterator;
import java.util.Vector;


/** The Recognizer interface provides a recognizer for the  
 *  language L below.
 * 
 *  Let Sigma = {a,b} = the input character set.
 * 
 *  Let L = {ab*} union {a*b} be the language (set of
 *  legal strings) recognized by this recognizer.
 *  
 *  Let S = s1s2...sn be the string of n characters already
 *  input by this recognizer.
 *
 *  Recognizer constructor must ensure: S' = < >
 */

public interface Recognizer {

	/**
	 * require: c in Sigma
	 * 
	 * ensure:  S' = S ^ c
	 * 
	 * param c
	 */
	public void nextChar(char c);

	/**
	 * Checks if input string S is in language L.
	 * 
	 * return (S in L)
	 */
	public boolean isIn();

	/**
	 * ensure: S' = < >
	 */ 
	public void reset();
	
	public int A();
	
	public int B();
	
	public Vector<Character> test();





}

