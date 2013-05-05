import java.util.Vector;

public class LanguageVector implements Recognizer {

	int element = 0;
	int a = 0;
	int b = 0;

	Vector<Character> v = new Vector<Character>();

	public void nextChar(char c) {
		v.add(c);
		if (c == 'a') {
			a ++;
		}
		if (c == 'b'){
			b ++;
		}
		
	}

	String[] stringarray = new String[10];

	public boolean isIn() {
		boolean isTrue = true;
		for (int i = 0; i < stringarray.length; i++) {
			if (v.size() == 1) {
				if (v.firstElement() == 'a' || v.firstElement() == 'b') {
					isTrue = true;
				} 
				else
					isTrue = false;
			} 
			else if (v.firstElement() == 'a') {
				if (v.lastElement() == 'a'){
					isTrue = false;
				}
				else if (v.lastElement() == 'b') {
					while (v.elementAt(element) == 'a') {
						element++;
					}
				}
				if (v.elementAt(element) != 'b') {
					isTrue = false;
				} 
				else if (a > 1 && b > 1) {
					isTrue = false;
				} 
				else
					isTrue = true;
			} 
			else if (v.firstElement() == 'b') {
				if (v.lastElement() == 'b') {
					isTrue = false;
				}
				else if (v.lastElement() == 'a') {
					while (v.elementAt(element) == 'b') {
						element++;
					}
				}
				if (v.elementAt(element) != 'a'){
					isTrue = false;
				}
				else if (a > 1 && b >1) {
					isTrue = false;
				}
				else
					isTrue = true;
			} 
			else {
				return isTrue;
			}
		}
		return isTrue;
	}

	public void reset() {
		v.clear();
		a = 0;
		b = 0;
		element = 0;
	}
	
	public int A(){
		int A = a;
		return A;
	}
	
	public int B(){
		int B = b;
		return B;
	}
	
	public Vector<Character> test(){
		return this.v;
	}

}